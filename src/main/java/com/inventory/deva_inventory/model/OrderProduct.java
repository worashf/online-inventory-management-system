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

/**
 *
 * @author mntemnte
 */
@Entity
@Table(name= "order_product")
public class OrderProduct  implements Serializable{
    
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_product_id")
    private Integer orderProductId;
    @Column(name = "order_product_name")
    private String  orderProductName;
    @Column(name = "order_product_quantity")
    private Integer orderProductQuantity;
     @Column(name= "order_product_price")
     private Double orderProductPrice;
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name ="order_id")
    private  Order order;
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name ="sale_order_id")
    private  SaleOrder saleOrder;
     
     
    @JsonBackReference(value = "sale-order-product")
    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }
     
     

    public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getOrderProductName() {
        return orderProductName;
    }

    public void setOrderProductName(String orderProductName) {
        this.orderProductName = orderProductName;
    }

    public Integer getOrderProductQuantity() {
        return orderProductQuantity;
    }

    public void setOrderProductQuantity(Integer orderProductQuantity) {
        this.orderProductQuantity = orderProductQuantity;
    }

    public Double getOrderProductPrice() {
        return orderProductPrice;
    }

    public void setOrderProductPrice(Double orderProductPrice) {
        this.orderProductPrice = orderProductPrice;
    }

    @JsonBackReference(value = "order-product")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
     
     
     
    
    
}
