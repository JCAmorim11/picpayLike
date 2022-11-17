package br.com.likepay.picpayLike.service.implementation;

import br.com.likepay.picpayLike.exceptions.BussinessException;
import br.com.likepay.picpayLike.model.Transaction;
import br.com.likepay.picpayLike.model.User;
import br.com.likepay.picpayLike.repository.UserRepository;
import br.com.likepay.picpayLike.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkEntity(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void valid(User... users ) {
        Arrays.asList(users).stream().forEach(user -> {
            throw new BussinessException("o usuario nao existe");
        });
    }


    @Override
    @Async
    public void updateBalance(Transaction transaction, Boolean isCreditCard){
        negativeBalance(transaction, isCreditCard);
        positiveBalance(transaction);
    }

    private void positiveBalance(Transaction transactionSaved) {
        userRepository.updatePositveBalance(transactionSaved.getDestination().getLogin(), transactionSaved.getValue());
    }

    private void negativeBalance(Transaction transactionSaved, Boolean isCreditCard) {
        if(!isCreditCard){
            userRepository.updateNegativeBalance(transactionSaved.getOrigin().getLogin(), transactionSaved.getValue());
        }
    }


}
