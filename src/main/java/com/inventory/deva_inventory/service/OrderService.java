/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Order;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface OrderService {
 
     public Order   saveOrder(Integer supplierId, Order  order);
     public void deleteOrder ( Integer orderId);
     public Order  editOrder (Integer orderId,Order  order);
     public List<Order> listAllOrder ();   
       public List<Order> listAllOrderBySupplierId(Integer supplierId);   
    
}
