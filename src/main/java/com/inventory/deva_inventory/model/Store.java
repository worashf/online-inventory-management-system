/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import java.io.Serializable;
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
@Table(name= "store")
public class Store  implements    Serializable{
    @Id
    @GeneratedValue
    private long  store_id;
    @Column(name="store_name")
    private String store_name;
    @Column(name="store_size")
    private int store_size;
    
    
         
    
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="comp_id")
    private Company company;

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getStore_size() {
        return store_size;
    }

    public void setStore_size(int store_size) {
        this.store_size = store_size;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
}
