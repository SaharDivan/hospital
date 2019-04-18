package at.nacs.drhouseadministration.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    private Long id;
    private Patient patient;
    private Kind kind;
    private String symptoms;
    private String diagnosis;
    private String provided;
    private double cost;
    private boolean paid;
    private LocalDateTime timestamp;
}
