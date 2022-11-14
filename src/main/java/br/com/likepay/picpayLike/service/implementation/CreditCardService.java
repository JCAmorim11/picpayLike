package br.com.likepay.picpayLike.service.implementation;

import br.com.likepay.picpayLike.converter.CreditCardConverter;
import br.com.likepay.picpayLike.dto.CreditCardDTO;
import br.com.likepay.picpayLike.model.CreditCard;
import br.com.likepay.picpayLike.repository.CreditCardRepository;
import br.com.likepay.picpayLike.service.ICreditCardService;
import br.com.likepay.picpayLike.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardConverter creditCardConverter;

    @Autowired
    private IUserService userService;

    public CreditCardDTO save(CreditCardDTO creditCardDTO){
        CreditCardDTO card =null;
        if(creditCardDTO.getIsSaved()){
            CreditCard creditCard = creditCardConverter.converterDtoToEntity(creditCardDTO);
            userService.checkEntity(creditCard.getUser().getLogin());
            CreditCard creditCardSaved = creditCardRepository.save(creditCard);
            card = creditCardConverter.converterEntityToDTO(creditCardSaved);
        }

        return card;
    }
}
