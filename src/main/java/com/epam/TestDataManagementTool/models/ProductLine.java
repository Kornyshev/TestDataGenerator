package com.epam.TestDataManagementTool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ProductLine")
@Table(name = "ProductLines")
public class ProductLine {

    @Id
    @Column(name = "productLine", nullable = false)
    public int productLine;
    @Column(name = "textDescription", nullable = false)
    public String textDescription;
    @Column(name = "htmlDescription", nullable = false)
    public String htmlDescription;
    @Column(name = "image", nullable = false)
    public String image;

    @OneToMany(mappedBy = "productCode")
    public Set<Product> products = new HashSet<>();

}
