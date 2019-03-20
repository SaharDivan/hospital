package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class DrHouseTest {

    @Autowired
    DrHouse drHouse;

    @MockBean
    RestTemplate restTemplate;

    @ParameterizedTest
    @CsvSource({
            "accident,brucken leg",
            "headache,migren",
            "toothache,lupus",
            ",lupus"
    })
    void diagnose(String symptoms, String diagnosis) {
        Patient patient = Patient.builder()
                .name("David")
                .symptoms(symptoms)
                .id(UUID.randomUUID().toString())
                .build();
        Patient diagnosed = drHouse.diagnose(patient);

        Assertions.assertThat(diagnosed.getDiagnoses()).isEqualTo(diagnosis);
    }
}