/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.controller;


import com.inventory.deva_inventory.model.Product;
import com.inventory.deva_inventory.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
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
public class ProductController {
    @Autowired
    private ProductService prodService;
        
         @PostMapping("/products/{supplierId}/{orderNumber}")
   public ResponseEntity<Product> saveProduct(@PathVariable Integer supplierId,@PathVariable String orderNumber ,@RequestBody Product ProData){ 
                Product product = prodService.saveProduct(supplierId,orderNumber, ProData);
               System.out.println(supplierId+ " " + orderNumber);
                return  ResponseEntity.ok().body(product);
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody Product proData){
        
         Product product = prodService.editProduct(productId, proData);
        
        return ResponseEntity.ok().body(product);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
       
         List<Product> listPro = prodService.listAllProduct();
        return ResponseEntity.ok().body(listPro);
    }
       @GetMapping("/products/{orderId}")
    public ResponseEntity<List<Product>> getAllProductsByOrderId(@PathVariable Integer orderId){
       
         List<Product> listPro = prodService.listAllProductById(orderId);
        return ResponseEntity.ok().body(listPro);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable Integer productId){
           prodService.deleteProduct(productId);
           Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }


    
}
