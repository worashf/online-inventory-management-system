/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.CompanyRepository;
import com.inventory.deva_inventory.dao.StoreRepository;
import com.inventory.deva_inventory.model.Company;
import com.inventory.deva_inventory.model.Store;
import com.inventory.deva_inventory.service.StoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author best
 */
@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
 private StoreRepository storeRepo;
    @Autowired
   private CompanyRepository compRepo;
    @Override
    public Store saveStore(Integer compId,Store storeData) {
      
        try {
            Company comp = compRepo.getById(compId);
         
            
               storeData.setCompany(comp);
//                comp.getStore().add(storeData);
               storeData= storeRepo.save(storeData);
        } catch (Exception e) {
        }
        return  storeData;
    }

    @Override
    public Store updateStore(Integer storeId, Store storeData) {
        Store updateStore =null;
        try {
            Store store=null;
            store = storeRepo.getById(storeId);
            store.setStoreName(storeData.getStoreName());
            store.setStoreSize(storeData.getStoreSize());
            store.setBuilding(storeData.getBuilding());
            store.setFloor(storeData.getFloor());
            store.setRoom(storeData.getRoom());
        updateStore=    storeRepo.save(store);
        } catch (Exception e) {
           updateStore=null;
        }
        return updateStore;
    }

    @Override
    public List<Store> getAllStores() {
        List<Store> listStore =null;
        try {
            listStore = storeRepo.findAll();
        } catch (Exception e) {
            listStore =null;
            
        }
        return listStore;
    }

    @Override
    public void deleteStore(Integer storeId) {
        try {
            storeRepo.deleteById(storeId);
        } catch (Exception e) {
        }
    }
    
}
