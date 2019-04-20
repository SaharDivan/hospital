package at.nacs.drhousediagnoses.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties("communication.illnesses")
public class DrHouseConfiguration {

    @Getter
    @Setter
     private Map<String, String> diagnosesBook;

    @Value("${severcases}")
    @Getter
    @Setter
    private List<String> severcases;

    @Bean
    List<String> makeSeverCases() {
        return severcases;
    }

    @Bean
    Map<String, String> publishMedicalReferenceBook(){
        return diagnosesBook;
    }
}
