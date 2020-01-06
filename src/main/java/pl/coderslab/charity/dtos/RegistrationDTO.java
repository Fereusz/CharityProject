package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationDTO {

    @NotBlank
    @Size(min = 3, max = 12)
    private String username;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 4, max = 12)
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String rePassword;
    private Long id;
    private Boolean active;
}
