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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

/**
 *
 * @author mntemnte
 */
@Entity
@Table(name = "order_table")

public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "order_type")
    private String orderType;
    @Column(name = "order_number")
    private String orderNumber;
   @Column(name = "order_status")
   private String orderStatus;
    @Column(name ="description")
    private String description;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
         
     @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
     private List<OrderProduct> productsOrdered;
   
     @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
     private List<Product> products;
     
    @ManyToOne
    @JoinColumn(name ="supplier_id")
    private Supplier supplier;
    
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private SaleOrder saleOrder;
    @JsonManagedReference(value = "order-saleOrder")
    public SaleOrder getSaleOrder() {
        return saleOrder;
    }
    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    
    @JsonManagedReference(value = "product-ordered")

    public List<Product> getProducts() {
        return products;
    }
    

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    

    @JsonBackReference(value = "supplier-order")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
   
  
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonManagedReference
    public List<OrderProduct> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(List<OrderProduct> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }
 
    
    
    

}
