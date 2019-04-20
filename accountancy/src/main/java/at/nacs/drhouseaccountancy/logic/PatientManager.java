package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.domian.Patient;
import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistance.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatientManager {

    private final PatientRepository patientRepository;


    public Patient saveOrUpdatePatient(PatientDTO dto) {
        Patient patient;
        Optional<Patient> optionalPatient =
                patientRepository.findByUuid(dto.getId());
        if (optionalPatient.isEmpty()) {
            patient = patientRepository.save(Patient.builder()
                    .name(dto.getName())
                    .build());

        } else {
            patient = optionalPatient.get();
            patient.setName(dto.getName());
            patientRepository.save(patient);
        }
        return patient;
    }
}
