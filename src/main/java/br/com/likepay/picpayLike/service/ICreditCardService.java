package br.com.likepay.picpayLike.service;

import br.com.likepay.picpayLike.dto.CreditCardDTO;
import br.com.likepay.picpayLike.model.CreditCard;

public interface ICreditCardService {
    CreditCard save(CreditCardDTO creditCard);
}
