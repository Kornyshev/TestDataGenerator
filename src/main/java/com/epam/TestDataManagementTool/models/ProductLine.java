package com.epam.TestDataManagementTool.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ProductLine")
@Table(name = "ProductLines")
public class ProductLine {

    @Id
    @Column(name = "productLine", nullable = false)
    private int productLine;
    @Column(name = "textDescription", nullable = false)
    public String textDescription;
    @Column(name = "htmlDescription", nullable = false)
    public String htmlDescription;
    @Column(name = "image", nullable = false)
    public String image;

}
