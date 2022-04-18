/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Supplier;
import com.inventory.deva_inventory.service.SupplierService;
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
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    
    @PostMapping("/suppliers")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier sup){
     Supplier suppplier=   supplierService.saveSupplier(sup);
        
        return ResponseEntity.ok().body(suppplier);
    }
    
      @PutMapping("/suppliers/{supplierId}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Integer supplierId,@RequestBody Supplier sup){
        Supplier supplier = supplierService.updateSupplier(supplierId, sup);
       return ResponseEntity.ok().body(supplier);
    }
    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
         List<Supplier> listSupplier = supplierService.getAllSupplier();
         return ResponseEntity.ok().body(listSupplier);
    }
        @PutMapping("/suppliers/approve/{supplierId}")
    public ResponseEntity<Supplier> approveSupplier(@PathVariable Integer supplierId,
     @RequestBody Supplier sup){
         Supplier supplier = supplierService.approveSupplier(supplierId,sup);
            System.out.println(supplierId);
         return ResponseEntity.ok().body(supplier);
    }
         @PutMapping("/suppliers/decline/{supplierId}")
    public ResponseEntity<Supplier> declineSupplier(@PathVariable Integer supplierId){
         Supplier supplier = supplierService.declineSupplier(supplierId);
         return ResponseEntity.ok().body(supplier);
    }
       @DeleteMapping("/suppliers/{supplierId}")
    public ResponseEntity<Map<String,Boolean>> deleteSupplier(@PathVariable Integer supplierId){
       supplierService.deleteSupplier(supplierId);
        Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
}
