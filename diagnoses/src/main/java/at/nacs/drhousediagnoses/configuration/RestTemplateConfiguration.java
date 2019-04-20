package at.nacs.drhousediagnoses.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
