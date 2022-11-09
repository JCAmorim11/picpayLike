package br.com.likepay.picpayLike.resource;

import dto.TransactionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends ResourceBase<TransactionDTO> {

    public ResponseEntity<TransactionDTO> save(@RequestBody @Valid TransactionDTO transactionDTO){
        return (ResponseEntity<TransactionDTO>) ResponseEntity.status(HttpStatus.OK);
    }

}
