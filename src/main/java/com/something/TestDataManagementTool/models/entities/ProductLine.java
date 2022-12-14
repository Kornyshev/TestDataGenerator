package com.something.TestDataManagementTool.models.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "ProductLine")
@Table(name = "ProductLines")
public class ProductLine {

    private static final Faker FAKER = Faker.instance();

    @Id
    @Column(name = "productLine", nullable = false)
    public int productLine;
    @Column(name = "textDescription", nullable = false)
    @Builder.Default
    public String textDescription = FAKER.lorem().fixedString(50);
    @Column(name = "htmlDescription", nullable = false)
    @Builder.Default
    public String htmlDescription = FAKER.lorem().fixedString(50);
    @Column(name = "image", nullable = false)
    @Builder.Default
    public String image = FAKER.internet().url();

    @OneToMany(mappedBy = "productCode")
    public Set<Product> products = new HashSet<>();

}
