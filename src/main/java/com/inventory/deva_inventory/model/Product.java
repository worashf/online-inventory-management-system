/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author best
 */
@Entity
@Table(name="product")
public class Product implements Serializable{
     @Id
     @GeneratedValue
     @Column(name ="product_id")
     private Long prod_id;
     @Column(name="product_name")
     private String prod_name;
     @Column(name="product_number")
     private String prod_number;
     @Column(name="product_price")
     private Double prod_price;
     @Column(name="product_quanttity")
     private int prod_quantity;
     @Column(name ="recieved_date")
     private Date recieved_date;
     @Column(name="expiry_date")
     private Date expiry_date;
   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="category_id")
   private Category category;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="brand_id")
   private Brand brand;
     
}
