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
//        Optional<Patient> optionalPatientByUuid =
//                patientRepository.findByUuid(dto.getId());
        Optional<Patient> optionalPatientByName =
                patientRepository.findByName(dto.getName());

        if (!patientRepository.existsByName(dto.getName())){
            return patientRepository.save(
                    Patient.builder()
                            .name(dto.getName())
                            .uuid(dto.getId())
                            .build()
            );
        }
        else {

            Patient patient = optionalPatientByName.get();
            patient.setUuid(dto.getId());
            return patientRepository.save(patient);
        }
    }
}
