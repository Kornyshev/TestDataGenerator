package com.something.TestDataManagementTool.models.entities;

import com.something.TestDataManagementTool.models.OrderStatus;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Order")
@Table(name = "Orders")
public class Order {

    private static final Faker FAKER = Faker.instance();

    @Id
    @Column(name = "orderNumber", nullable = false)
    public int orderNumber;
    @Column(name = "orderDate", nullable = false)
    @Builder.Default
    public Date orderDate = new Date(FAKER.date().past(365, TimeUnit.DAYS).getTime());
    @Column(name = "requiredDate", nullable = false)
    @Builder.Default
    public Date requiredDate = new Date(FAKER.date().past(365, TimeUnit.DAYS).getTime());
    @Column(name = "shippedDate")
    public Date shippedDate;
    @Column(name = "status", nullable = false)
    @Builder.Default
    public String status = OrderStatus.getOrderStatusById(FAKER.random().nextInt(3)).getName();
    @Column(name = "comments", nullable = false)
    @Builder.Default
    public String comments = FAKER.lorem().fixedString(100);
    @ManyToOne()
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false, foreignKey = @ForeignKey(name = "fk_orders_to_customer"))
    public Customer customerNumber;

    @OneToOne(mappedBy = "orderNumber")
    public OrderDetails orderDetails;

}
