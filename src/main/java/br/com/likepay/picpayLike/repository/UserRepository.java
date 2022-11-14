package br.com.likepay.picpayLike.repository;

import br.com.likepay.picpayLike.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByLogin(String login);
}
