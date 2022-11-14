package br.com.likepay.picpayLike.service;

import br.com.likepay.picpayLike.model.Transaction;
import br.com.likepay.picpayLike.model.User;

public interface IUserService {
    User checkEntity(String login);

    void updateBalance(Transaction transaction, Boolean isCreditCard);

    void valid(User... users);
}
