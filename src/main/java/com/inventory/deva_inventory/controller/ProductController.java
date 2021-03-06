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
        
         @PostMapping("/products/{supplierId}/{suppliedProductId}/{categoryId}/{brandId}")
   public ResponseEntity<Product> saveProduct(@PathVariable Integer supplierId,@PathVariable Integer suppliedProductId,
           @PathVariable Integer categoryId, @PathVariable Integer brandId,@RequestBody Product ProData){ 
                Product product = prodService.saveProduct(supplierId, suppliedProductId, categoryId, brandId, ProData);
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
        @GetMapping("/products/un-stocked")
    public ResponseEntity<List<Product>> getAllUnStockedProducts(){
       
         List<Product> listPro = prodService.listAllProductByProductStockStatus("un-stocked");
        return ResponseEntity.ok().body(listPro);
    }
        @GetMapping("/products/stocked")
    public ResponseEntity<List<Product>> getAllStockedProducts(){
       
         List<Product> listPro = prodService.listAllProductByProductStockStatus("stocked");
        return ResponseEntity.ok().body(listPro);
    }
       @GetMapping("/products/{orderId}")
    public ResponseEntity<List<Product>>  getAllProductsByCategory(@PathVariable Integer orderId){
       
         List<Product> listPro = prodService.listAllProductById(orderId);
        return ResponseEntity.ok().body(listPro);
    }
        @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<Product>> getAllProductsByOrderId(@PathVariable Integer categoryId){
       
         List<Product> listPro = prodService.listAllProductByCategoryId(categoryId);
        return ResponseEntity.ok().body(listPro);
    }
        @GetMapping("/products/brand/{brandId}")
    public ResponseEntity<List<Product>> getAllProductsByBrandId(@PathVariable Integer brandId){
       
         List<Product> listPro = prodService.listAllProductByBrandId(brandId);
        return ResponseEntity.ok().body(listPro);
    }
    
     @GetMapping("/products/product-number/{productNumber}")
    public ResponseEntity<Product> getAllProductsByProductNumber(@PathVariable String productNumber){
       
         Product pro = prodService.getProductByProductNumber(productNumber);
        return ResponseEntity.ok().body(pro);
    }
    
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable Integer productId){
           prodService.deleteProduct(productId);
           Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
    
       @PutMapping("/products/add-product-inventory/{productId}/{inventoryCode}")
    public ResponseEntity<Product>  addProductToInventory(@PathVariable Integer productId,
            @PathVariable String inventoryCode){
           System.out.println(productId + "this " + inventoryCode);
         Product pro = prodService.addProductToInventory(productId, inventoryCode);
        return ResponseEntity.ok().body(pro);
    }
    
    
    
    


    
}
