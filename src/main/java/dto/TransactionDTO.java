package dto;

import java.time.LocalDateTime;

public class TransactionDTO {

  private String code;
  private UserDTO origin;
  private UserDTO destiny;
  private LocalDateTime dateHour;
  private Double value;
  private CreditCardDTO creditCard;
  private Boolean isCreditCard = false;
}
