package br.com.likepay.picpayLike.repository;

import br.com.likepay.picpayLike.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByLogin(String login);

    @Modifying
    @Query("Update User u set u.balance = u.saldo - ?2 where u.login =?1")
    void updatePositveBalance(String login, Double value);


    @Modifying
    @Query("Update User u set u.balance = u.saldo + ?2 where u.login =?1")
    void updateNegativeBalance(String login, Double value);
}
