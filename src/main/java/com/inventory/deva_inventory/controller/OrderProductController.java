/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.controller;


import com.inventory.deva_inventory.model.OrderProduct;
import com.inventory.deva_inventory.service.OrderProductService;
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
public class OrderProductController {
    @Autowired
    private OrderProductService orderProductService;
    
    
    @PostMapping("/order-products/{orderId}")
   public ResponseEntity<OrderProduct> saveOrderProduct(@PathVariable Integer orderId ,@RequestBody OrderProduct orderProData){ 
                OrderProduct orderPro = orderProductService.saveOrderProduct(orderId, orderProData);
              System.out.println(orderId);
        return  ResponseEntity.ok().body(orderPro);
    }
    @PutMapping("/order-products/{orderProductId}")
    public ResponseEntity<OrderProduct> updateOrderProduct(@PathVariable Integer orderProductId,@RequestBody OrderProduct orderProData){
        
         OrderProduct orderpro = orderProductService.editOrderProduct(orderProductId, orderProData);
        
        return ResponseEntity.ok().body(orderpro);
    }
    @GetMapping("/order-products")
    public ResponseEntity<List<OrderProduct>> getAllOrderProducts(){
       
         List<OrderProduct> listOrderPro = orderProductService.listAllOrderProduct();
        return ResponseEntity.ok().body(listOrderPro);
    }
       @GetMapping("/order-products/{orderId}")
    public ResponseEntity<List<OrderProduct>> getAllOrderProductsByOrderId(@PathVariable Integer orderId){
       
         List<OrderProduct> listOrderPro = orderProductService.listAllOrderProductById(orderId);
        return ResponseEntity.ok().body(listOrderPro);
    }
    @DeleteMapping("/order-products/{orderProductId}")
    public ResponseEntity<Map<String,Boolean>> deleteOrderProduct(@PathVariable Integer orderProductId){
          orderProductService.deleteOrderProduct(orderProductId);
        Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
    
}
