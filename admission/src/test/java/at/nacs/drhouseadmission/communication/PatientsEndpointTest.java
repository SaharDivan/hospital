package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    String url = "/patients";

    @Test
    public void post() {
        Patient patient = Patient.builder()
                .name("Mina")
                .symptoms("coughing")
                .build();

        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);

        assertThat(actual.getName()).isEqualTo("Mina");
        assertThat(actual.getSymptoms()).isEqualTo("coughing");
        assertThat(actual.getId()).isNotEmpty();
    }
}