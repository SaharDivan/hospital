package at.nacs.drhouseaccountancy.persistance.repository;

import at.nacs.drhouseaccountancy.persistance.domian.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByUuid(String uuid);
    Optional<Patient> findByName(String name);

    boolean existsByUuidOrName(String uuid, String name);

    boolean existsByName(String name);
}
