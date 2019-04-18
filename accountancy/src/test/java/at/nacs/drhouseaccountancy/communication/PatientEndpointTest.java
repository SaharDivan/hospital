package at.nacs.drhouseaccountancy.communication;


import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    PatientEndpoint patientEndpoint;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    PatientDTO patientDTO;

    @SpyBean
    Accountant accountant;


    @Test
    void passDTOToAccountancyDepartments() {
        String url = "/patients";
        testRestTemplate.postForObject(url, patientDTO, void.class);

        Mockito.verify(accountant).administerTheAccount(patientDTO);
    }
}