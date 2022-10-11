package com.epam.TestDataManagementTool.models;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Product")
@Table(name = "Products")
public class Product {

    private static final Faker FAKER = Faker.instance();

    @Id
    @Column(name = "productCode", nullable = false)
    public int productCode;
    @Column(name = "productName", nullable = false)
    @Builder.Default
    public String productName = FAKER.lorem().fixedString(20);
    @ManyToOne()
    @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false, foreignKey = @ForeignKey(name = "fk_products_to_line"))
    public ProductLine productLine;
    @Column(name = "productScale", nullable = false)
    @Builder.Default
    public String productScale = FAKER.lorem().fixedString(30);
    @Column(name = "productVendor", nullable = false)
    @Builder.Default
    public String productVendor = FAKER.company().name();
    @Column(name = "productDescription", nullable = false)
    @Builder.Default
    public String productDescription = FAKER.lorem().fixedString(30);
    @Column(name = "quantityInStock", nullable = false)
    @Builder.Default
    public short quantityInStock = (short) FAKER.random().nextInt(256);
    @Column(name = "buyPrice", nullable = false)
    @Builder.Default
    public BigDecimal buyPrice = new BigDecimal(FAKER.random().nextInt(1000, 10000));
    @Column(name = "MSRP", nullable = false)
    @Builder.Default
    public BigDecimal MSRP = new BigDecimal(FAKER.random().nextInt(1000, 10000));

    @OneToMany(mappedBy = "productCode")
    public Set<OrderDetails> orderDetails = new HashSet<>();

}
