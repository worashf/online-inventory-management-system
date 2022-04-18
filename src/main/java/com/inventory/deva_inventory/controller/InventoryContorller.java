/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Inventory;
import com.inventory.deva_inventory.model.OrderProduct;
import com.inventory.deva_inventory.service.InventoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mntemnte
 */
@RestController
@RequestMapping("/api")
public class InventoryContorller {

    @Autowired
    private InventoryService invService;
    
    @PostMapping("/inventories/{storeId}")
    public ResponseEntity<Inventory> saveInventory(@PathVariable Integer storeId, @RequestBody Inventory inv) {        
        
        Inventory inventory = invService.saveInventory(storeId, inv);
        
        return ResponseEntity.ok().body(inventory);
    }

    @PutMapping("/inventories/{inventoryId}/{storeId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Integer inventoryId, @PathVariable Integer storeId, @RequestBody Inventory invData) {
        
        Inventory inv = invService.editInventory(inventoryId, storeId, invData);
        return ResponseEntity.ok().body(inv);
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<Inventory>> getAllInventories() {
        
        List<Inventory> listInv = invService.listAllInventorys();
        return ResponseEntity.ok().body(listInv);
    }

    @GetMapping("/inventories/{storeId}")
    public ResponseEntity<List<Inventory>> getAllInventorysByStoreId(@PathVariable Integer storeId) {
        List<Inventory> listInv = invService.listAllInventorysByStoreId(storeId);
        return ResponseEntity.ok().body(listInv);
    }

    @DeleteMapping("/inventories/{inventoryId}")
    public ResponseEntity<Map<String, Boolean>> deleteInventory(@PathVariable Integer inventoryId) {
        invService.deleteInventory(inventoryId);
       Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}
