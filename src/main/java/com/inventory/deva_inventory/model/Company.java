/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;


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
      @GeneratedValue
      private Long comp_id;
      
      @Column(name="company_name")
      private String comp_name;
      @Column(name="company_phone1")
      private String comp_phone1;
      
      @Column(name="comp_phone2")
      private String comp_phone2;
      @Column(name="company_email")
      private String comp_email;
      @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Store>  store;
   @OneToOne(mappedBy ="company",fetch = FetchType.LAZY)
    private Address address;
    public Long getComp_id() {
        return comp_id;
    }

    public void setComp_id(Long comp_id) {
        this.comp_id = comp_id;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getComp_phone1() {
        return comp_phone1;
    }

    public void setComp_phone1(String comp_phone1) {
        this.comp_phone1 = comp_phone1;
    }

    public String getComp_phone2() {
        return comp_phone2;
    }

    public void setComp_phone2(String comp_phone2) {
        this.comp_phone2 = comp_phone2;
    }

    public String getComp_email() {
        return comp_email;
    }

    public void setComp_email(String comp_email) {
        this.comp_email = comp_email;
    }
      
      
}
