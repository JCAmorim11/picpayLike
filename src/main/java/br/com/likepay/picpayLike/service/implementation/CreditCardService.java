package br.com.likepay.picpayLike.service.implementation;

import br.com.likepay.picpayLike.dto.CreditCardDTO;
import br.com.likepay.picpayLike.model.CreditCard;
import br.com.likepay.picpayLike.service.ICreditCardService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements ICreditCardService {

    public CreditCard save(CreditCardDTO creditCardDTO){
        return new CreditCard();
    }
}
