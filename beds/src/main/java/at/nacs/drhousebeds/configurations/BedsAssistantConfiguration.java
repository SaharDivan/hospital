package at.nacs.drhousebeds.configurations;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("nurse")
public class BedsAssistantConfiguration {

    @Setter
     private Map<String,String> book;

    @Bean
    Map<String,String> publishMedicalGuideBook(){
        return book;
    }
}
