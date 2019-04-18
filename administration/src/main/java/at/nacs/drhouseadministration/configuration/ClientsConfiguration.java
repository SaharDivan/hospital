package at.nacs.drhouseadministration.configuration;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientsConfiguration {

    @Value("${admission.address.url}")
    @Setter
    private String url;

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    String urlAddress(){
        return url;
    }
}
