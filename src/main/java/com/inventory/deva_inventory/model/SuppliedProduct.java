/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="supplier_product")
public class SuppliedProduct  implements Serializable {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="suppliered_product_id")
    private Integer  suppieredProductId;
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

    public String getSuppliedProductStatus() {
        return suppliedProductStatus;
    }

    public void setSuppliedProductStatus(String suppliedProductStatus) {
        this.suppliedProductStatus = suppliedProductStatus;
    }
     

    public Integer getSuppieredProductId() {
        return suppieredProductId;
    }

    public void setSuppieredProductId(Integer suppieredProductId) {
        this.suppieredProductId = suppieredProductId;
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
