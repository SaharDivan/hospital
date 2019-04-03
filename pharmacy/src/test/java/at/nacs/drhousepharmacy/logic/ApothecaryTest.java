package at.nacs.drhousepharmacy.logic;


import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ApothecaryTest {

    @Autowired
    Apothecary apothecary;

    @Autowired
    PatientRepository repository;


    private Patient patient = Patient.builder()
            .name("David")
            .diagnosis("coughing")
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
    void provideMedicine() {
        Patient actual = apothecary.provideMedicine(patient);

        assertThat(actual.getMedicine()).isNotNull();
        assertThat(actual.getMedicine()).isEqualTo("foster");
    }

    @Test
    void testRepository() {
        apothecary.provideMedicine(patient);

        assertThat(repository.count()).isEqualTo(1);
    }
}