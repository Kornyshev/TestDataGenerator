package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Payment")
@Table(name = "Payments")
@IdClass(PaymentId.class)
public class Payment {

    @Id
    @ManyToOne()
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false, foreignKey = @ForeignKey(name = "fk_payments_to_customer"))
    public Customer customerNumber;
    @Id
    @Column(name = "checkNumber")
    public int checkNumber;
    @Column(name = "paymentDate", nullable = false)
    public Date paymentDate;
    @Column(name = "amount", nullable = false)
    public BigDecimal amount;

}
