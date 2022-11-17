package br.com.likepay.picpayLike.resource;

import br.com.likepay.picpayLike.dto.TransactionDTO;
import br.com.likepay.picpayLike.service.ITransactionService;
import br.com.likepay.picpayLike.service.implementation.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.awt.print.Pageable;

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

    @GetMapping()
    public ResponseEntity<Page<TransactionDTO>> list(@PageableDefault(page=0,size=20) Pageable paginator, @RequestParam String login){
        Page<TransactionDTO> transactions = transactionService.list(paginator, login);
        return responseListItemsPaged(transactions);
    }
}
