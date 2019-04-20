package at.nacs.drhousepharmacy.communication;

import org.junit.jupiter.api.Test;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
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

    @Autowired
    PatientsEndpoint patientsEndpoint;

    @MockBean
    RestTemplate restTemplate;

    private Patient patient = Patient.builder()
            .name("David")
            .diagnosis("coughing")
            .build();

    @Test
    void pharmacyRegistry() {
        String url = "/patients";

        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);

        assertThat(actual).isNotNull();
        assertThat(actual.getMedicine()).isEqualTo("foster");

    }

//    @Test
//    void forwardToAccountancy() {
//        String sentMessage = patientsEndpoint.forwardToAccountancy(patient);
//
//        assertThat(sentMessage).isNotEmpty();
//    }
}