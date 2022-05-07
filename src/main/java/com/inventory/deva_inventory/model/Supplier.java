/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author best
 */

@Entity
@Table(name="supplier")

public class Supplier implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="supplier_id")
    private Integer  supplierId;
    @Column(name="supplier_name")
    private String supplierName;
    @Column(name="email")
    private  String email;
    @Column(name="phone1")
    private  String phone1;
    @Column(name="phone2")
    private String phone2;
       @Column(name="user_name")
     private String userName;
     @Column(name="password")
     private String password;
     @Column(name="supplier_status")
     private String supplierStatus;
   
      @OneToOne(mappedBy ="supplier",fetch = FetchType.LAZY)
    private Address address;
       @JsonIgnore
      @OneToMany(mappedBy = "supplier")
      private List<Order> orders;
      @OneToMany(mappedBy = "supplier")
      private List<Product> products;
     @JsonIgnore
        @OneToOne(mappedBy ="supplier")
      private User user;
   
      @JsonManagedReference(value = "user-supplier")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
        
        
      @JsonManagedReference(value = "product-supplier")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
      

         @JsonManagedReference(value = "supplier-order")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

  
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

  

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

 

  
   @JsonManagedReference(value = "supplier-address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
     
}
