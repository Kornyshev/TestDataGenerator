package com.epam.TestDataManagementTool.models;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OrderDetails")
@Table(name = "OrderDetails")
@IdClass(OrderDetailsId.class)
public class OrderDetails {

    private static final Faker FAKER = Faker.instance();

    @Id
    @OneToOne()
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber", nullable = false, foreignKey = @ForeignKey(name = "fk_order_details_to_order"))
    public Order orderNumber;
    @Id
    @ManyToOne()
    @JoinColumn(name = "productCode", referencedColumnName = "productCode", nullable = false, foreignKey = @ForeignKey(name = "fk_order_details_to_products"))
    public Product productCode;
    @Column(name = "quantityOrdered", nullable = false)
    @Builder.Default
    public int quantityOrdered = FAKER.random().nextInt(10) + 1;
    @Column(name = "priceEach", nullable = false)
    @Builder.Default
    public BigDecimal priceEach = null;
    @Column(name = "orderLineNumber", nullable = false)
    @Builder.Default
    public short orderLineNumber = (short) FAKER.random().nextInt(256);

}
