package br.com.likepay.picpayLike.service;

import br.com.likepay.picpayLike.dto.TransactionDTO;
import br.com.likepay.picpayLike.model.Transaction;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class TransactionService implements ITransactionService {

    public TransactionDTO processing(@Valid TransactionDTO transactionDTO){
        Transaction transaction = save(transactionDTO);
        creditCardService.save(transactionDTO.getCreditCard());
        userService.updateBalance(transaction, transactionDTO.getIsCreditCard());
        TransactionDTO novo = new TransactionDTO();
        return transactionConverter.transformEntityToDTO(transaction);
    }

    private Transaction save(TransactionDTO transactionDTO){
        Transaction transaction = transactionConverter.transformDtoToEntity(transactionDTO);
        usuarioService.valid(transaction.getDestination(), transaction.getOrigin());
        return TransactionRepository.save(transaction);
    }
}

