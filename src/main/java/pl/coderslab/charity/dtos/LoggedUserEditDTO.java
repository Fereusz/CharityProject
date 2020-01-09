package pl.coderslab.charity.dtos;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoggedUserEditDTO {

    @NotBlank
    private String username;
    @Email @NotBlank
    private String email;

}
