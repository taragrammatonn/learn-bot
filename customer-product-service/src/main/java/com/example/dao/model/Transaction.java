package com.example.dao.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transaction")
@Table(schema = "transactions", name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "occured_at")
    private LocalDateTime occuredAt;

    @Column(name = "cleared_date")
    private LocalDateTime clearedDate;

    @Column(name = "authorization_date")
    private LocalDateTime authorizationDate;

    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    @Column(name = "balance_before")
    private BigDecimal balanceBefore;

    @Column(name = "balance_after")
    private BigDecimal balanceAfter;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    public Transaction() {}

    public Transaction(Long id, LocalDateTime occuredAt, LocalDateTime clearedDate, LocalDateTime authorizationDate,
                       BigDecimal transactionAmount, BigDecimal balanceBefore, BigDecimal balanceAfter) {
        this.id = id;
        this.occuredAt = occuredAt;
        this.clearedDate = clearedDate;
        this.authorizationDate = authorizationDate;
        this.transactionAmount = transactionAmount;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOccuredAt() { return occuredAt; }

    public void setOccuredAt(LocalDateTime occuredAt) {
        this.occuredAt = occuredAt;
    }

    public LocalDateTime getClearedDate() { return clearedDate; }

    public void setClearedDate(LocalDateTime clearedDate) {
        this.clearedDate = clearedDate;
    }

    public LocalDateTime getAuthorizationDate() { return authorizationDate; }

    public void setAuthorizationDate(LocalDateTime authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public BigDecimal getTransactionAmount() { return transactionAmount; }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getBalanceBefore() { return balanceBefore; }

    public void setBalanceBefore(BigDecimal balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public BigDecimal getBalanceAfter() { return balanceAfter; }

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public User getOwner() { return owner; }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
