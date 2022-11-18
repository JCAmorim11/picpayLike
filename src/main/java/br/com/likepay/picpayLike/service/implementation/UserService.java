package br.com.likepay.picpayLike.service.implementation;

import br.com.likepay.picpayLike.converter.UserConverter;
import br.com.likepay.picpayLike.dto.UserDTO;
import br.com.likepay.picpayLike.exceptions.BussinessException;
import br.com.likepay.picpayLike.model.Transaction;
import br.com.likepay.picpayLike.model.User;
import br.com.likepay.picpayLike.repository.UserRepository;
import br.com.likepay.picpayLike.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter converter;

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
    public UserDTO search(String login) {
        User user = checkEntity(login);
        return converter.converterEntityToDTO(user);
    }

    @Override
    public List<UserDTO> list(String login) {
        return null;
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
