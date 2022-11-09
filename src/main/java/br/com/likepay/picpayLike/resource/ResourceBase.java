package br.com.likepay.picpayLike.resource;

import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class ResourceBase<T> {

    protected ResponseEntity<T> responseCreatedItem(T object){
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    protected ResponseEntity<T> responseCreatedItemWithURI(T object, UriComponentsBuilder uriBuilder, String path, String code ){
        URI uri = uriBuilder.path(path).buildAndExpand(code).toUri();
        return ResponseEntity.status(HttpStatus.OK).body(object);
    }

    protected ResponseEntity<T> reponseNotFoundItem(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<T> responseSucess(){
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

   protected ResponseEntity<T> responseSucessWithItem(T object){
       return ResponseEntity.status(HttpStatus.OK).body(object);
   }
   protected ResponseEntity<List<T>> responseSucessEmptyList(){
       List<T> emptyList = new ArrayList<>();
       return ResponseEntity.status(HttpStatus.OK).body(emptyList);
   }

   protected ResponseEntity<List<T>> responseListItems(List<T> items){
       return ResponseEntity.status(HttpStatus.OK).body(items);
   }

   protected ResponseEntity<T> responseBadRequest(){
       return ResponseEntity.badRequest().build();
   }

   protected ResponseEntity<Page<T>> responseListItemsPaged(Page<T> items){
        return ResponseEntity.status(HttpStatus.OK).body(items);
   }


}
