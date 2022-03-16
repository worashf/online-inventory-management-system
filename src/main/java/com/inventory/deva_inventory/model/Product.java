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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author best
 */
@Entity
@Table(name="product")
public class Product implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
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
     @Temporal(TemporalType.DATE)
     @Column(name ="recieved_date")
     private Date recieved_date;
     @Temporal(TemporalType.DATE)
     @Column(name="expiry_date")
     private Date expiry_date;
   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="category_id")
   private Category category;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="brand_id")
   private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name ="inventory_id")
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    

    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_number() {
        return prod_number;
    }

    public void setProd_number(String prod_number) {
        this.prod_number = prod_number;
    }

    public Double getProd_price() {
        return prod_price;
    }

    public void setProd_price(Double prod_price) {
        this.prod_price = prod_price;
    }

    public int getProd_quantity() {
        return prod_quantity;
    }

    public void setProd_quantity(int prod_quantity) {
        this.prod_quantity = prod_quantity;
    }

    public Date getRecieved_date() {
        return recieved_date;
    }

    public void setRecieved_date(Date recieved_date) {
        this.recieved_date = recieved_date;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
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
    
    
     
}
