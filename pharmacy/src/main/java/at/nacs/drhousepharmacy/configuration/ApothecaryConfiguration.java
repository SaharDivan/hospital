package at.nacs.drhousepharmacy.configuration;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("apothecary")
public class ApothecaryConfiguration {

    @Setter
    private Map<String,String> prescription;

    @Bean
    public Map<String,String> publishPrescription(){
        return prescription;
    }

}
