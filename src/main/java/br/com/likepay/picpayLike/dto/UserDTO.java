package br.com.likepay.picpayLike.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotBlank
    private String login;
    private String password;
    private String email;
    private String fullName;
    private String CPF;
    private LocalDateTime birthDate;
    private String telephoneNumber;
    private Double balance;
}
