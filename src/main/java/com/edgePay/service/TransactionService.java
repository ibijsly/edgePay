package com.edgePay.service;

import com.edgePay.model.ResponseModel;
import com.edgePay.model.Transaction;
import com.edgePay.model.User;
import com.edgePay.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    public ResponseEntity<ResponseModel> addTransaction(Transaction transaction, Principal principal){
        try{
            User user = userService.getUserByUsername(principal.getName());
            transaction.setSender(user);
            transaction.setTransactionId("EP" + System.currentTimeMillis());

            if (user.hasRole("ROLE_AGENT")){
                //Set the name of the sender as the NIN details retrieved
            }else if (user.hasRole("ROLE_ENDUSER")){
                transaction.setSenderName(user.getFullName());
            }
            transaction.setStatus("Sent");

            transactionRepository.save(transaction);

            return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", transaction), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", transaction), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseModel> findBySender(User user){
        try {
            List<Transaction> transactions = transactionRepository.findBySender(user);

            if (transactions.size() < 1)
                return new ResponseEntity<ResponseModel>( new ResponseModel("02", "No Transactions Found", transactions), HttpStatus.NOT_FOUND);

            return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", transactions), HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseModel> findByDispatcherAgent(User user){
        try {
            List<Transaction> transactions = transactionRepository.findByDispatcherAgent(user);

            if (transactions.size() < 1)
                return new ResponseEntity<ResponseModel>( new ResponseModel("02", "No Transactions Found", transactions), HttpStatus.NOT_FOUND);

            return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", transactions), HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseModel> findByReceiverId(String id){
        try {
            List<Transaction> transactions = transactionRepository.findByReceiverId(id);

            if (transactions.size() < 1)
                return new ResponseEntity<ResponseModel>( new ResponseModel("02", "No Transactions Found", transactions), HttpStatus.NOT_FOUND);

            return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", transactions), HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseModel> findByTransactionId(String tnxId){
        try {
            Transaction transaction = transactionRepository.findByTransactionId(tnxId);

            if (transaction == null)
                return new ResponseEntity<ResponseModel>( new ResponseModel("02", "No Transactions Found", transaction), HttpStatus.NOT_FOUND);

            return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", transaction), HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>( new ResponseModel("99", "Error Occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
