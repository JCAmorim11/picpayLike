package dto;

import enums.CardBrand;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreditCardDTO {

  @NotBlank
  private CardBrand brand;

  @NotBlank
  private String securityCode;

  @NotBlank
  private String expirationDate;

  @NotBlank
  private String titularName;

  private String number;

  private String numberToken;

  private UserDTO user;

  private Boolean isSaved = false;
}
