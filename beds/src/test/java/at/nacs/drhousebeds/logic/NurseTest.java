package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistance.domain.Patient;
import at.nacs.drhousebeds.persistance.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class NurseTest {

    @Autowired
    Nurse nurse;

    @MockBean
    RestTemplate restTemplate;

    @Autowired
    PatientRepository repository;
    private Patient patient = Patient.builder()
            .name("David")
            .diagnosis("asthma")
            .build();

    @BeforeEach
    void before() {
        repository.deleteAll();
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }

    @Test
    void provideTreatments() {
        Patient handledPatient = nurse.provideTreatments(patient);

        assertThat(handledPatient).isNotNull();
        assertThat(handledPatient.getTreatment()).isEqualTo("oxigon");
    }

    @Test
    void checkRepository() {
        nurse.provideTreatments(patient);

        assertThat(repository.count()).isEqualTo(1);
    }
}
