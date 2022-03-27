/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Address;
import java.util.List;

/**
 *
 * @author best
 */
public interface AddressService {
      public Address findAddressById(Integer addressId);
    
     public Address  saveStoreAddress(Integer parentId, Address a);
   public Address  saveCompanyAddress(Integer parentId, Address a);
     public void deleteAddress( Integer addressId);
     public Address  editStoreAddress(Integer parrentId,Address a);
      public Address  editCompanyAddress(Integer parrentId,Address a);
   public List<Address> listAllStoreAddress();
}
