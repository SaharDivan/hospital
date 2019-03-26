package at.nacs.drhousebeds.endpoints;


import at.nacs.drhousebeds.domain.Patient;
import at.nacs.drhousebeds.logics.Nurse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

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
    Nurse nurse;

    @SpyBean
    ForwardClass forwardClass;

    private Patient patient = Patient.builder()
            .name("David")
            .id(UUID.randomUUID().toString())
            .diagnosis("headache")
            .build();

    @Test
    void bedsRegistry() {
        String url = "/patients";

        when(nurse.provideTreatments(patient))
                .thenReturn(patient);

        Patient actual = testRestTemplate.postForObject(url, patient, Patient.class);

        System.out.println(actual);
    }

    @Test
    void testForwardToAccountancy() {
        forwardClass.forwardToAccountancy(patient);

        verify(forwardClass).forwardToAccountancy(patient);
    }
}