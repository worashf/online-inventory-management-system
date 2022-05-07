/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Store;
import java.util.List;

/**
 *
 * @author best
 */
public interface StoreService {
    public Store saveStore(Integer companyId, Store store);
    public Store updateStore(Integer storeId,Store store);
    public List<Store> getAllStores();
    public void deleteStore(Integer storeId);
    
}
