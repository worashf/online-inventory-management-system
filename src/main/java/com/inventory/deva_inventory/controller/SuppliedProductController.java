/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.SuppliedProduct;
import com.inventory.deva_inventory.service.SuppliedProductService;
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

@RestController
@RequestMapping("/api")
public class SuppliedProductController {
    @Autowired
    private SuppliedProductService supProductService;
    
    
    @PostMapping("/supplied-products/{saleOrderId}")
   public ResponseEntity<SuppliedProduct> saveSuppledProduct(@PathVariable Integer saleOrderId ,@RequestBody SuppliedProduct supProData){ 
           SuppliedProduct supProduct = supProductService.saveSuppliedProduct(saleOrderId, supProData);
        return  ResponseEntity.ok().body(supProduct);
    }
    @PutMapping("/supplied-products/{saleOrderId}")
    public ResponseEntity<SuppliedProduct> updateSuppliedProduct(@PathVariable Integer saleOrderId,@RequestBody SuppliedProduct supProduct){
        
         SuppliedProduct suppliedProduct = supProductService.editSuppliedProduct(saleOrderId, supProduct);
        return ResponseEntity.ok().body(suppliedProduct);
    }
    @GetMapping("/supplied-products")
    public ResponseEntity<List<SuppliedProduct>> getAllSuppliedProducts(){
       
         List<SuppliedProduct> listSuppliedPro = supProductService.listAllSuppliedProduct();
        return ResponseEntity.ok().body(listSuppliedPro);
    }
       @GetMapping("/supplied-products/{saleOrderId}")
    public ResponseEntity<List<SuppliedProduct>> getAllSuppliedProductsBySaleOrderId(@PathVariable Integer saleOrderId){
       
         List<SuppliedProduct> listSuppliedPro = supProductService.listAllSuppliedProductBySaleOrderId(saleOrderId);
        return ResponseEntity.ok().body(listSuppliedPro);
    }
       @GetMapping("/supplied-products/order/{orderId}")
    public ResponseEntity<List<SuppliedProduct>> getAllSuppliedProductsByOrderId(@PathVariable Integer orderId){
       
         List<SuppliedProduct> listSuppliedPro = supProductService.listAllSuppliedProductByrderId(orderId);
        return ResponseEntity.ok().body(listSuppliedPro);
    }
    @DeleteMapping("/supplied-products/{suppliedProductId}")
    public ResponseEntity<Map<String,Boolean>> deleteSuppliedProduct(@PathVariable Integer suppliedProductId){
         supProductService.deleteSuppliedProduct(suppliedProductId);
        Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
    
}
