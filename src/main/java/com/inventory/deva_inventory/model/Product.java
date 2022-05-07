/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="product")

public class Product implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name ="product_id")
     private Integer productId;
     @Column(name="product_name")
     private String productName;
     @Column(name="product_number")
     private String productNumber;
     @Column(name="product_price")
     private Double productPrice;
     @Column(name="product_quanttity")
     private int productQuantity;
     @Temporal(TemporalType.DATE)
     @Column(name ="recieved_date")
     private Date recievedDate;
     @Temporal(TemporalType.DATE)
     @Column(name="expiry_date")
     private Date expiryDate;
     @Column(name="stock_status")
     private String stockStatus;
   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="category_id")
   private Category category;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="brand_id")
   private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name ="inventory_id")
    private Inventory inventory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
     
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "supplier_id")
    private  Supplier supplier;
     
    @OneToOne
    @JoinColumn(name="suppliered_product_id")
    private SuppliedProduct supProduct;

    @JsonBackReference(value = "product-supplied-product")
    public SuppliedProduct getSupProduct() {
        return supProduct;
    }

    public void setSupProduct(SuppliedProduct supProduct) {
        this.supProduct = supProduct;
    }
    
    @JsonBackReference(value = "product-supplier")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
    @JsonBackReference(value = "product-ordered")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
@JsonBackReference(value = "product-inventory")
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Date getRecievedDate() {
        return recievedDate;
    }

    public void setRecievedDate(Date recievedDate) {
        this.recievedDate = recievedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }
    

     
}
