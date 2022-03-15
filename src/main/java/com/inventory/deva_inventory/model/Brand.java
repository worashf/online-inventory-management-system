/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author best
 */
@Entity
@Table(name="brand")
public class Brand {
    @Id
    @GeneratedValue
    private  Long brand_id;
    Column(name="brand_name")
    private String brand_name;
    
}
