/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.AddressRepository;
import com.inventory.deva_inventory.dao.CompanyRepository;
import com.inventory.deva_inventory.dao.StoreRepository;
import com.inventory.deva_inventory.model.Address;

import com.inventory.deva_inventory.model.Store;
import com.inventory.deva_inventory.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author best
 */
@Service
public class AddressServiceImpl  implements AddressService{
  @Autowired
  private AddressRepository addressRepo;
  @Autowired
  private CompanyRepository compRepo;
  @Autowired
  private StoreRepository  storeRepo;

    @Override
    public Address findAddressById(Integer addressId) {
        try {
            
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Address saveStoreAddress(Integer parentId, Address addressData) {
        
        try {
             
            Store store = storeRepo.findByStoreId(parentId);
            System.out.println(store.getStoreName());
             addressData.setStore(store);
             addressData = addressRepo.save(addressData);
        } catch (Exception e) {
        }
        return addressData;
    }

    @Override
    public Address saveCompanyAddress(Integer parentId, Address a) {
        try {
            
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void deleteAddress(Integer addressId) {
        try {
            
        } catch (Exception e) {
        }
    }

    @Override
    public Address editStoreAddress(Integer parrentId, Address a) {
        try {
            
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Address editCompanyAddress(Integer parrentId, Address a) {
        try {
            
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Address> listAllStoreAddress() {
        try {
            
        } catch (Exception e) {
        }
        return null;
    }
   
}
