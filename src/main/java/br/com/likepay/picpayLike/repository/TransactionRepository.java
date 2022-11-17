package br.com.likepay.picpayLike.repository;


import br.com.likepay.picpayLike.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    Page<Transaction> findByOrigin_LoginOrDestination_Login(String login, String login1, Pageable paginator);
}
