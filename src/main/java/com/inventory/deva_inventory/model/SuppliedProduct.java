/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="supplier_product")

public class SuppliedProduct  implements Serializable {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="suppliered_product_id")
    private Integer  suppliedProductId;
     @Column(name = "supplied_product_name")
    private String  suppliedProductName;
    @Column(name = "supplied_product_quantity")
    private Integer suppliedProductQuantity;
     @Column(name= "supplied_product_price")
     private Double suppliedProductPrice;
     @Column(name="supplied_product_status")
     private String suppliedProductStatus;
    
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="sale_order_id")
    private SaleOrder saleOrder;
       @JsonIgnore
    @OneToOne(mappedBy = "supProduct",cascade = CascadeType.ALL)
    private Product product;
    @JsonManagedReference(value = "product-supplied-product")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public String getSuppliedProductStatus() {
        return suppliedProductStatus;
    }

    public void setSuppliedProductStatus(String suppliedProductStatus) {
        this.suppliedProductStatus = suppliedProductStatus;
    }

    public Integer getSuppliedProductId() {
        return suppliedProductId;
    }

    public void setSuppliedProductId(Integer suppliedProductId) {
        this.suppliedProductId = suppliedProductId;
    }
     

  
    public String getSuppliedProductName() {
        return suppliedProductName;
    }

    public void setSuppliedProductName(String suppliedProductName) {
        this.suppliedProductName = suppliedProductName;
    }

    public Integer getSuppliedProductQuantity() {
        return suppliedProductQuantity;
    }

    public void setSuppliedProductQuantity(Integer suppliedProductQuantity) {
        this.suppliedProductQuantity = suppliedProductQuantity;
    }

    public Double getSuppliedProductPrice() {
        return suppliedProductPrice;
    }

    public void setSuppliedProductPrice(Double suppliedProductPrice) {
        this.suppliedProductPrice = suppliedProductPrice;
    }
  @JsonBackReference(value = "supplied-product")
    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }
 
     
}
