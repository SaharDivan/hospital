//package at.nacs.drhouseaccountancy.logic;
//
//import at.nacs.drhouseaccountancy.persistance.domian.Patient;
//import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
//import at.nacs.drhouseaccountancy.persistance.repository.PatientRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//class PatientManagerTest {
//
//    @Autowired
//    PatientManager patientManager;
////    @Autowired
////    PatientDTO dto;
//
//    @MockBean
//    PatientRepository patientRepository;
//
//    @Test
//    void saveOrUpdatePatient() {
//        String id = "45";
//        Patient patient = Patient.builder()
//                .name("Nima")
//                .uuid(id).build();
//        PatientDTO dto = PatientDTO.builder()
//                .name("Nima")
//                .id("45")
//                .build();
//
//        when(patientRepository.findByUuid(id)).
//                thenReturn(Optional.empty()).thenReturn(Optional.empty());
//        when((patientRepository.save(patient))).thenReturn(patient);
//
//        Patient actual = patientManager.saveOrUpdatePatient(dto);
//        System.out.println(actual.toString());
//
//        Assertions.assertThat(actual).isEqualTo(patient);
//
//    }
//}