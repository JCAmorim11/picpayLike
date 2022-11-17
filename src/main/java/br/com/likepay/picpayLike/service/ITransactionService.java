package br.com.likepay.picpayLike.service;


import br.com.likepay.picpayLike.dto.TransactionDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ITransactionService {
    TransactionDTO processing(TransactionDTO transactionDTO);

    Page<TransactionDTO> list(Pageable paginator, String login);
}
