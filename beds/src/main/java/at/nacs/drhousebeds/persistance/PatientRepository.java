package at.nacs.drhousebeds.persistance;

import at.nacs.drhousebeds.persistance.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient,String> {

}
