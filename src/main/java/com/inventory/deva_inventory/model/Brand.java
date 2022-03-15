/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author best
 */
@Entity
@Table(name="brand")
public class Brand {
    @Id
    @GeneratedValue
    private  Long brand_id;
    @Column(name="brand_name")
    private String brand_name;
    @Column(name="brand_description")
    private String brand_desc;
    
    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> products;

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_desc() {
        return brand_desc;
    }

    public void setBrand_desc(String brand_desc) {
        this.brand_desc = brand_desc;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
   
    
    
}
