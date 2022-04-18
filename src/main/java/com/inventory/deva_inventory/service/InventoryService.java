/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Inventory;
import java.util.List;

/**
 *
 * @author best
 */
public interface InventoryService {
       public Inventory   saveInventory(Integer storeId, Inventory inventory);
     public void deleteInventory  ( Integer inventoryId);
     public Inventory  editInventory  (Integer inventoryId,Integer storeId,Inventory  inventory);
     public List<Inventory> listAllInventorys  ();
      public List<Inventory> listAllInventorysByStoreId  (Integer storeId);
}
