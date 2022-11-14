package br.com.likepay.picpayLike.model;

import br.com.likepay.picpayLike.enums.CardBrand;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIOS")
public class CreditCard extends Base {

  @Column(name = "CC_NUMERO", nullable = false)
  private String number;

  @Enumerated(EnumType.STRING)
  @Column(name = "CC_BANDEIRA", nullable = false)
  private CardBrand brand;

  @Column(name = "CC_TOKEN")
  private String numberToken;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "CC_USUARIO_ID", nullable = false)
  private User user;
}
