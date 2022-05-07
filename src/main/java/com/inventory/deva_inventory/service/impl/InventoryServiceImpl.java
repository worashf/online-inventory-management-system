/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.InventoryRepository;
import com.inventory.deva_inventory.dao.StoreRepository;
import com.inventory.deva_inventory.model.Inventory;
import com.inventory.deva_inventory.model.Store;
import com.inventory.deva_inventory.service.InventoryService;
import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepo;
    @Autowired
    private StoreRepository storeRepo;
    
    @Override
    public Inventory saveInventory(Integer storeId, Inventory inventory) {
        
        Store store =null;
      
        try {
            store = storeRepo.getById(storeId);
            Date date = new Date();
               inventory.setInventoryDate(date);
               inventory.setStore(store);
               inventory = inventoryRepo.save(inventory);
            
        } catch (Exception e) {
            inventory =null;
        }
        return inventory;
    }

    @Override
    public void deleteInventory(Integer inventoryId) {
        try {
             inventoryRepo.deleteById(inventoryId);
        } catch (Exception e) {
        }
    }

    @Override
    public Inventory editInventory(Integer inventoryId,Integer storeId,Inventory inventory) {
       
         Inventory inv =null;
         Store store =null;
        try {
            inv = inventoryRepo.getById(inventoryId);
             store = storeRepo.getById(storeId);
            inv.setInventoryName(inventory.getInventoryName());
            inv.setInventoryDate(inventory.getInventoryDate());
            inv.setStore(store);
            
            inv = inventoryRepo.save(inv);
        } catch (Exception e) {
            inv =null;
        }
        return inv;
    }

    @Override
    public List<Inventory> listAllInventorys() {
         List<Inventory> listInventory =null;
        try {
             listInventory = inventoryRepo.findAll();
        } catch (Exception e) {
            listInventory = null;
        }
        return listInventory;
    }
@Transactional
    @Override
    public List<Inventory> listAllInventorysByStoreId(Integer storeId) {
       List<Inventory> listInventory =null;
       
        try {
             listInventory = inventoryRepo.getAllInventoryByStoreId(storeId);
        } catch (Exception e) {
            
            listInventory  =null;
        }
       
        return listInventory;

    }

    @Override
    public Inventory findInventoryByInventoryCode(String inventoryCode) {
        Inventory inv =null;
        try {
            inv = inventoryRepo.getInventoryByInventoryCode(inventoryCode);
        } catch (Exception e) {
            inv= null;
        }
    return inv;
    }

    @Override
    public List<Inventory> findInventoryByReorderLevel(Integer reorderLevel) {
         List<Inventory> listInventory =null;
       
        try {
             listInventory = inventoryRepo.getInventoryByReorderLevel(reorderLevel);
        } catch (Exception e) {
            
            listInventory  =null;
        }
       
        return listInventory;
    }

    @Override
    public List<Inventory> findInventoryByAlertLevel(Integer alertLevel) {
 
           List<Inventory> listInventory =null;
       
        try {
             listInventory = inventoryRepo.getInventoryByAlertLevel(alertLevel);
        } catch (Exception e) {
            
            listInventory  =null;
        }
       
        return listInventory;}
    
}
