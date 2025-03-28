package org.macquarie.repostories;

import org.macquarie.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionListRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByaccountNumber(Long accountNumber);
}
