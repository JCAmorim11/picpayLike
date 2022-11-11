package br.com.likepay.picpayLike.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TRANSACOES")
public class Transaction extends Base {

  @Column(name = "TR_CODIGO", nullable = false)
  private String code;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "TR_USUARIO_ORIGEM", nullable = false)
  private User origin;

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinColumn(name = "TR_USUARIO_ORIGEM", nullable = false)
  private User destination;

  @Column(name = "TR_VALOR", nullable = false)
  private LocalDateTime dateTime;

  @Column(name = "TR_VALOR", nullable = false)
  private Double value;
}
