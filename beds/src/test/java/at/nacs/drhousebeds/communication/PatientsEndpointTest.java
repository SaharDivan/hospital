package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistance.domain.Patient;
import at.nacs.drhousebeds.logic.BedsAssistance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    PatientsEndpoint patientsEndpoint;

    @MockBean
    RestTemplate restTemplate;

    @MockBean
    BedsAssistance bedsAssistance;

    @SpyBean
    AccountancyClient accountancyClient;

    private Patient patient = Patient.builder()
            .name("David")
            .diagnosis("headache")
            .build();

    @Test
    void bedsRegistry() {
        String url = "/patients";

        when(bedsAssistance.provideTreatments(patient))
                .thenReturn(patient);

        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);

        assertThat(actual).isNotNull();
    }

    @Test
    void testForwardToAccountancy() {
        accountancyClient.forwardToAccountancy(patient);

        verify(accountancyClient).forwardToAccountancy(patient);
    }
}