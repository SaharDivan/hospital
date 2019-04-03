package at.nacs.drhousediagnoses.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class DiagnosesConfiguration {


    @Value("${severcases}")
    @Getter
    @Setter
    private List<String> severcases;

    @Bean
    List<String> makeSevercases() {
        return severcases;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
