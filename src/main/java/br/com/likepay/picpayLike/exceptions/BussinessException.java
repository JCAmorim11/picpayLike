package br.com.likepay.picpayLike.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BussinessException extends Throwable {
    public Object BussinessException(String o_usuario_nao_existe) {
        return null;
    }
}
