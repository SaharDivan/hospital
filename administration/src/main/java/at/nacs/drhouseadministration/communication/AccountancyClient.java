package at.nacs.drhouseadministration.communication;

import at.nacs.drhouseadministration.ui.model.Invoice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {
    private final RestTemplate restTemplate;

    @Getter
    @Value("${accountancy.address.url}")
    private String url;

    public List<Invoice> getAll() {
        return Arrays.asList(restTemplate.getForObject(url, Invoice[].class));
    }

    public void markAsPaid(Long id) {
        String accountancyUrl = url + "/" + id + "/paid";
        restTemplate.put(accountancyUrl, id, void.class);
    }
}

