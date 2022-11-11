package br.com.likepay.picpayLike.enums;

public enum CardBrand {
  VISA("Visa"),
  MASTERCARD("MasterCard"),
  ELO("Elo");

  private String descricao;

  CardBrand(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }
}
