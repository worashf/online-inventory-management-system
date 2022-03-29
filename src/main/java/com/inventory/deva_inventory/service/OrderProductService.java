/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.OrderProduct;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface OrderProductService {
    
     public OrderProduct   saveOrderProduct(Integer orderId, OrderProduct  orderProduct);
     public void deleteOrderProduct  ( Integer orderProductId);
     public OrderProduct   editOrderProduct  (Integer orderProductId,OrderProduct   orderProduct);
     public List<OrderProduct > listAllOrderProduct  ();
}
