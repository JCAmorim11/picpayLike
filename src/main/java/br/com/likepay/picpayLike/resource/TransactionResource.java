package br.com.likepay.picpayLike.resource;

import br.com.likepay.picpayLike.dto.TransactionDTO;
import br.com.likepay.picpayLike.service.ITransactionService;
import br.com.likepay.picpayLike.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends ResourceBase<TransactionDTO> {

    TransactionService ztransactionService;
    private ITransactionService transactionService;

    @PostMapping()
    public ResponseEntity<TransactionDTO> save(@RequestBody @Valid TransactionDTO transactionDTO,
                                               UriComponentsBuilder uriBuilder){
        TransactionDTO transactionReturnDTO = transactionService.processing(transactionDTO);
        return responseCreatedItemWithURI(transactionReturnDTO,uriBuilder, "/transactions/{code}", transactionReturnDTO.getCode());
    }

}
