package br.com.likepay.picpayLike.service;


import br.com.likepay.picpayLike.dto.TransactionDTO;

public interface ITransactionService {
    TransactionDTO processing(TransactionDTO transactionDTO);
}
