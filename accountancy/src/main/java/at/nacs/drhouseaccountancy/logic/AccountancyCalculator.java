package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@ConfigurationProperties("hospital.pricelist")
@RequiredArgsConstructor
@Service
public class AccountancyCalculator {

    private final Map<String, Double> treatment;
    private final Map<String, Double> medicine;

    public Double calculateCostForPatient(PatientDTO dto) {
        String serviceByHospital = dto.getTreatment();
        if (treatment.containsKey(serviceByHospital)) {
            return treatment.get(serviceByHospital);
        }

        if(medicine.containsKey(dto.getMedicine())){
        return medicine.get(dto.getMedicine());
        }

        return 0.0;
    }
}
