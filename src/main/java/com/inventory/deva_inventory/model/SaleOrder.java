/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sale_order")
public class SaleOrder implements  Serializable{
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_order_id")
    private Integer saleOrderId;
    @Column(name = "sale_order_name")
    private String saleOrderName;
    
    @Column(name = "sale_order_number")
    private String saleOrderNumber;
  
    @Column(name ="description")
    private String description;
     @Column(name = "sale_order_status")
     private String saleOrderStatus;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order  order;

      @OneToMany(mappedBy = "saleOrder" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
     private List<OrderProduct> orderProducts;

         @JsonManagedReference(value = "sale-order-product")
    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
      
      
  
    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getSaleOrderName() {
        return saleOrderName;
    }

    public void setSaleOrderName(String saleOrderName) {
        this.saleOrderName = saleOrderName;
    }

    public String getSaleOrderNumber() {
        return saleOrderNumber;
    }

    public void setSaleOrderNumber(String saleOrderNumber) {
        this.saleOrderNumber = saleOrderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSaleOrderStatus() {
        return saleOrderStatus;
    }

    public void setSaleOrderStatus(String saleOrderStatus) {
        this.saleOrderStatus = saleOrderStatus;
    }

    @JsonBackReference(value = "order-saleOrder")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
    
    
}
