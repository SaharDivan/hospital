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


    public void saveOrUpdatePatient(PatientDTO dto) {
        Optional<Patient> optionalPatient =
                patientRepository.findByUuid(dto.getId());
        if (optionalPatient.isEmpty()) {
            patientRepository.save(Patient.builder()
                    .uuid(dto.getId())
                    .name(dto.getName())
                    .build());
        } else {
            Patient patient = optionalPatient.get();
            patient.setName(dto.getName());
            patientRepository.save(patient);
        }
    }
}
