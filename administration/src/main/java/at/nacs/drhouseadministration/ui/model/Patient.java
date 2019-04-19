package at.nacs.drhouseadministration.ui.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Patient {

    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String symptoms;
}
