package com.serverapp.metrodata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name", nullable = false, length = 30)
    private String name;

    @Column(nullable = false, name = "product_desc")
    private String desc;

    @Column(nullable = false, name = "product_price")
    private Integer price;

    @Column(nullable = false, name = "product_qty")
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
