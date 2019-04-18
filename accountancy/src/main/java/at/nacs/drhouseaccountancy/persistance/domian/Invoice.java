package at.nacs.drhouseaccountancy.persistance.domian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private Kind kind;
    private String symptoms;
    private String diagnosis;
    private String provided;
    private double cost;
    private boolean paid;
    private LocalDateTime timestamp;
}
