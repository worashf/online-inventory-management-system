/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.model;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 *
 * @author best
 */
public class Customer {
    
      @OneToOne(mappedBy ="customer",fetch = FetchType.LAZY)
    private Address address;
}
