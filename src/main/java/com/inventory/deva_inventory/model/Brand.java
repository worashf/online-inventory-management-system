/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author best
 */
@Entity
@Table(name="brand")
public class Brand  implements  Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
       @Column(name="brand_id")
    private  Long brandId;
    @Column(name="brand_name")
    private String brandName;
    @Column(name="brand_description")
    private String brandDesc;
    
    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> products;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
   
    
    
}
