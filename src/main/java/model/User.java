package model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USUARIOS")
public class User extends Base {

  @Column(name = "USU_LOGIN", nullable = false)
  private String login;

  @Column(name = "USU_SENHA", nullable = false)
  private String password;

  @Column(name = "USU_EMAIL", nullable = false)
  private String email;

  @Column(name = "USU_NOME_COMPLETO", nullable = false)
  private String fullName;

  @Column(name = "USU_CPF", nullable = false)
  private String CPF;

  @Column(name = "USU_DATA_NASCIMENTO", nullable = false)
  private LocalDateTime birthDate;

  @Column(name = "USU_NUMERO_TELEFONE", nullable = false)
  private String telephoneNumber;

  @OneToMany(
    mappedBy = "usuario",
    fetch = FetchType.LAZY,
    cascade = CascadeType.MERGE,
    orphanRemoval = true
  )
  private List<CreditCard> creditCards;

  @Column(name = "USU_SALDO", nullable = false)
  private String balance;

  @Column(name = "USU_ATIVO", nullable = false)
  private Boolean active;
}
