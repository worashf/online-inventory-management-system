/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Order;
import com.inventory.deva_inventory.model.Supplier;

import com.inventory.deva_inventory.service.OrderService;
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
public class OrderController {
  
    @Autowired
    private OrderService orderService;
    @Autowired
    private SupplierService supService;
            
    @PostMapping("/orders/{supplierId}")
    public ResponseEntity<Order> saveOrder(@PathVariable Integer supplierId ,@RequestBody Order orderData){ 
      Order order=  orderService.saveOrder(supplierId, orderData);
      System.out.println(supplierId + "    " + orderData);
        return  ResponseEntity.ok().body(order);
    }
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer orderId,@RequestBody Order orderData){
        
         Order order = orderService.editOrder(orderId, orderData);
       
        return ResponseEntity.ok().body(order);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
       
         List<Order> listOrder = orderService.listAllOrder();
        return ResponseEntity.ok().body(listOrder);
    }
      @GetMapping("/orders/{userName}")
    public ResponseEntity<List<Order>> getAllOrdersSupplierId(@PathVariable String userName){
          Supplier sup = supService.findSupplierByUser(userName);
         List<Order> listOrder = orderService.listAllOrderBySupplierId(sup.getSupplierId());
        return ResponseEntity.ok().body(listOrder);
    }
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Map<String,Boolean>> deleteOrder(@PathVariable Integer orderId){
           orderService.deleteOrder(orderId);
        Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }
    
}
