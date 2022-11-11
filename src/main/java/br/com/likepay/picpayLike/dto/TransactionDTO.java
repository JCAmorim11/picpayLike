package br.com.likepay.picpayLike.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {

  @NotBlank
  private String code;
  @NotNull
  private UserDTO origin;

  @NotNull
  private UserDTO destiny;

  @NotNull
  private LocalDateTime dateHour;

  @NotNull
  private Double value;
  private CreditCardDTO creditCard;
  private Boolean isCreditCard = false;
}
