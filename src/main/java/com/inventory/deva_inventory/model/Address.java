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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Long address_id;
     @Column(name="country")
     private String country;
     @Column(name ="city")
     private String city;
     @Column(name="sub_city")
     private String sub_city;
     @Column(name="state")
     private String state;
     @Column(name ="street")
     private String street;
     @Column(name="postal_code")
     private String postal_code;
     
    
       @OneToOne
       @JoinColumn(name="company_id")
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
     
     
}
