package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdminAssistanceTest {

    @Autowired
    AdminAssistance adminAssistance;

    @MockBean
    RestTemplate restTemplate;


    @ParameterizedTest
    @CsvSource({
            "Mina, Headache",
    })
    void admit(String name, String symptoms) {
        Patient patient = Patient.builder()
                .name(name)
                .symptoms(symptoms)
                .build();
        adminAssistance.register(patient);

        Assertions.assertThat(patient.getId()).isNotNull();

    }
}