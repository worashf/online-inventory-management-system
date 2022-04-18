/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author best
 */
@Entity
@Table(name ="address")
public class Address  implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="address_id")
    private Integer addressId;
     @Column(name="country")
     private String country;
     @Column(name ="city")
     private String city;
     @Column(name="sub_city")
     private String subCity;
     @Column(name="state")
     private String state;
     @Column(name ="street")
     private String street;
     @Column(name="postal_code")
     private String postalCode;
     
    
       @OneToOne
       @JoinColumn(name="comp_id")
     private Company company;
      @OneToOne
      @JoinColumn(name="store_id")
     private Store store;
     
     @OneToOne
     @JoinColumn(name ="supplier_id")
     private Supplier supplier;
     @OneToOne
     @JoinColumn(name="customer_id")
     private Customer customer;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

 

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

  
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSubCity() {
        return subCity;
    }

    public void setSubCity(String subCity) {
        this.subCity = subCity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

 

   

    @JsonBackReference(value = "store-address")
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
@JsonBackReference(value = "supplier-address")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
     
     
     
}
