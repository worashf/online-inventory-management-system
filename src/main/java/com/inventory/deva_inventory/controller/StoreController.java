/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Store;
import com.inventory.deva_inventory.service.StoreService;
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
 * @author best
 */
@RestController
@RequestMapping("/api")
public class StoreController {
    
    @Autowired
    private StoreService storeService;
    
  @PostMapping("/stores/{companyId}")
    public ResponseEntity<Store> saveStore(@PathVariable Integer companyId ,@RequestBody Store storeData){
      Store store=  storeService.saveStore(companyId, storeData);
        return  ResponseEntity.ok(store);
    }
    @PutMapping("/stores/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable Integer storeId,@RequestBody Store storeData){
         Store store = storeService.updateStore(storeId, storeData);
        
        return ResponseEntity.ok(store);
    }
    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllStores(){
         List<Store> listStore = storeService.getAllStores();
        return ResponseEntity.ok(listStore);
    }
    @DeleteMapping("/stores/{storeId}")
    public ResponseEntity<Map<String,Boolean>> deleteStore(@PathVariable Integer storeId){
        storeService.deleteStore(storeId);
        Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
}
