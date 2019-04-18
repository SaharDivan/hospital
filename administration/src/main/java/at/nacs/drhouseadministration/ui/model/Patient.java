package at.nacs.drhouseadministration.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @NotEmpty
    private String name;
    @NotEmpty
    private String symptoms;
}
