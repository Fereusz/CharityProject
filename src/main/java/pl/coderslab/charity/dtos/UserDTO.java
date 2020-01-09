package pl.coderslab.charity.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private Long id;
    @NotBlank
    private String username;
    @Email @NotBlank
    private String email;
    @Size(min = 4, max = 12) @NotBlank
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String rePassword;
    private Boolean active;
}
