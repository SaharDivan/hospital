package at.nacs.drhouseadmission.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class endpointsConfiguration {


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
