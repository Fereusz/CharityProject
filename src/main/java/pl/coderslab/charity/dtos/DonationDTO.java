package pl.coderslab.charity.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.entities.Institution;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDTO {

    private Long id;
    private Integer quantity;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String zipCode;
    @NotBlank @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotBlank @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    @Size(max = 200)
    private String pickUpComment;
    private List<Category> categories; // tutaj zrobic liste <CategoryDTO>
    private Institution institution; // tutaj zrobic obiekt insitutionDTO

}
