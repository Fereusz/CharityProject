package pl.coderslab.charity.dtos;

import lombok.Data;
import pl.coderslab.charity.domain.entities.Donation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class InstitutionDTO {

    private Long id;
    private List<Donation> donations;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}

