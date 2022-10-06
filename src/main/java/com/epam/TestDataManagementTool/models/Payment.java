package com.epam.TestDataManagementTool.models;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Payment")
@Table(name = "Payments")
@IdClass(PaymentId.class)
public class Payment {

    private static final Faker FAKER = Faker.instance();

    @Id
    @ManyToOne()
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false, foreignKey = @ForeignKey(name = "fk_payments_to_customer"))
    public Customer customerNumber;
    @Id
    @Column(name = "checkNumber")
    public int checkNumber;
    @Column(name = "paymentDate", nullable = false)
    @Builder.Default
    public Date paymentDate = Date.valueOf(FAKER.date().past(365, TimeUnit.DAYS).toString());
    ;
    @Column(name = "amount", nullable = false)
    @Builder.Default
    public BigDecimal amount = new BigDecimal(FAKER.random().nextInt(1000, 10000));

}
