package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Payment")
@Table(name = "Payments")
public class Payment {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    private Customer customerNumber;
    @Id
    @Column(name = "checkNumber")
    private int checkNumber;
    @Column(name = "paymentDate", nullable = false)
    public Date paymentDate;
    @Column(name = "amount", nullable = false)
    public BigDecimal amount;

}
