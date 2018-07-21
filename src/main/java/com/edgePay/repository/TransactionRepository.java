package com.edgePay.repository;

import com.edgePay.model.Transaction;
import com.edgePay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public List<Transaction> findBySender(User user);
    public List<Transaction> findBySenderName(String sender);

    public List<Transaction> findByReceiverId(String receiverId);
    public List<Transaction> findByReceiverName(String receiverName);

    public List<Transaction> findByDispatcherAgent(User dispatcherAgent);
    public Transaction findByTransactionId(String transactionId);
}
