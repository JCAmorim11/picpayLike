package br.com.likepay.picpayLike.service.implementation;

import br.com.likepay.picpayLike.converter.TransactionConverter;
import br.com.likepay.picpayLike.dto.TransactionDTO;
import br.com.likepay.picpayLike.model.Transaction;
import br.com.likepay.picpayLike.repository.TransactionRepository;
import br.com.likepay.picpayLike.service.ICreditCardService;
import br.com.likepay.picpayLike.service.ITransactionService;
import br.com.likepay.picpayLike.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private IUserService userService;

    @Autowired
    private TransactionConverter transactionConverter;

    @Autowired
    private ICreditCardService creditCardService;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDTO processing(@Valid TransactionDTO transactionDTO){
        Transaction transaction = save(transactionDTO);
        creditCardService.save(transactionDTO.getCreditCard());
        userService.updateBalance(transaction, transactionDTO.getIsCreditCard());
        TransactionDTO novo = new TransactionDTO();
        return transactionConverter.converterEntityToDTO(transaction);
    }

    private Transaction save(TransactionDTO transactionDTO){
        Transaction transaction = transactionConverter.converterDtoToEntity(transactionDTO);
        userService.valid(transaction.getDestination(), transaction.getOrigin());
        return transactionRepository.save(transaction);
    }
}

