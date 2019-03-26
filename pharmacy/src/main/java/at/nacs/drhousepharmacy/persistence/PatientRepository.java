package at.nacs.drhousepharmacy.persistence;

import at.nacs.drhousepharmacy.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient,String> {

}
