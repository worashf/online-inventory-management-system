/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author best
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventory_id;
    @Column(name = "inventory_name")
    private String inventory_name;
  
    @Column(name = "inventory_date")
    @Temporal(TemporalType.DATE)
    private Date inventory_date;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getInventory_name() {
        return inventory_name;
    }

    public void setInventory_name(String inventory_name) {
        this.inventory_name = inventory_name;
    }

    public Date getInventory_date() {
        return inventory_date;
    }

    public void setInventory_date(Date inventory_date) {
        this.inventory_date = inventory_date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    

}
