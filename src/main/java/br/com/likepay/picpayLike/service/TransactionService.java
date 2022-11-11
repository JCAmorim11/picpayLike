package br.com.likepay.picpayLike.service;

import br.com.likepay.picpayLike.converter.TransactionConverter;
import br.com.likepay.picpayLike.dto.TransactionDTO;
import br.com.likepay.picpayLike.model.Transaction;
import br.com.likepay.picpayLike.repository.TransactionRepository;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class TransactionService implements ITransactionService {


    IUserService userService;

    TransactionConverter transactionConverter;

    ICreditCardService creditCardService;

    TransactionRepository Tra1nsactionRepository;
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
        return TransactionRepository.save(transaction);
    }
}

