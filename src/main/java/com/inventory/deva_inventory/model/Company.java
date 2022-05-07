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

import javax.persistence.*;

/**
 * @Author: deva
 
 * @Project is Online inventory
 */

@Entity
@Table(name = "company")
public class Company implements Serializable{
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
       @Column(name="comp_id")
      private Integer companyId;
      
      @Column(name="comp_name")
      private String companyName;
      @Column(name="comp_phone1")
      private String phone1;
      
      @Column(name="comp_phone2")
      private String phone2;
      @Column(name="comp_email")
      private String email;
      @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Store>  store;
//   @OneToOne(mappedBy ="company",fetch = FetchType.EAGER)
//    private Address address;
 @JsonManagedReference
    public List<Store> getStore() {
        return store;
    }

    public void setStore(List<Store> store) {
        this.store = store;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
}
