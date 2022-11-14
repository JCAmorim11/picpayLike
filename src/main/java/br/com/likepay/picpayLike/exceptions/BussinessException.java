package br.com.likepay.picpayLike.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BussinessException extends RuntimeException {

    private static final long  serialversionuid = 1L;

    public BussinessException(String mensagem){
        super(mensagem);
    }

    public BussinessException(String mensagem, Exception exception){
        super(mensagem, exception);
    }
}
