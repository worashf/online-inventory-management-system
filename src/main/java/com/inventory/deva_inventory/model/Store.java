/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author best
 */
@Entity
@Table(name= "store")
public class Store  implements    Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="store_id")
    private Integer  storeId;
    @Column(name="store_name")
    private String storeName;
    @Column(name="store_size")
    private int storeSize;
    @Column(name = "building")
    private String building;
    @Column(name = "floor")
    private int  floor;
    @Column(name = "room")
    private int room;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name ="comp_id")
    private Company company;
    
   @OneToOne(mappedBy ="store",fetch = FetchType.EAGER)
      private Address address;
   @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
     private List<Inventory> inventories;

   @JsonManagedReference
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

  

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStoreSize() {
        return storeSize;
    }

    public void setStoreSize(int storeSize) {
        this.storeSize = storeSize;
    }
 @JsonBackReference
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
   
   
    
}
