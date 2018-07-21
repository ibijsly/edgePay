package com.edgePay.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;
    private double amount;
    private String senderName;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;

    private String receiverIdType;
    private String receiverId;
    private String receiverName;

    private Date transactionInitiationDate;
    private Date ValueRecievedDate;

    /*This is the agent the receiver collected from*/
    @ManyToOne
    @JoinColumn(name = "dispatcher_agent", referencedColumnName = "id")
    private User dispatcherAgent;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getReceiverIdType() {
        return receiverIdType;
    }

    public void setReceiverIdType(String receiverIdType) {
        this.receiverIdType = receiverIdType;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getTransactionInitiationDate() {
        return transactionInitiationDate;
    }

    public void setTransactionInitiationDate(Date transactionInitiationDate) {
        this.transactionInitiationDate = transactionInitiationDate;
    }

    public Date getValueRecievedDate() {
        return ValueRecievedDate;
    }

    public void setValueRecievedDate(Date valueRecievedDate) {
        ValueRecievedDate = valueRecievedDate;
    }

    public User getDispatcherAgent() {
        return dispatcherAgent;
    }

    public void setDispatcherAgent(User dispatcherAgent) {
        this.dispatcherAgent = dispatcherAgent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
