/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.OrderRepository;
import com.inventory.deva_inventory.dao.SupplierRepository;
import com.inventory.deva_inventory.model.Order;
import com.inventory.deva_inventory.model.Supplier;
import com.inventory.deva_inventory.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mntemnte
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private SupplierRepository supplierRepo;
    @Override
    public Order saveOrder(Integer supplierId,Order order) {
        Supplier  sup =null;
        try {
            sup = supplierRepo.getById(supplierId);
            System.out.print(sup.getSupplierName());
               order.setSupplier(sup);
//               sup.getOrder().setSupplier(sup);
            
            order = orderRepo.save(order);
        } catch (Exception e) {
            order =null;
            
        }
        return order;
    }

    @Override
    public void deleteOrder(Integer orderId) {
        try {
            orderRepo.deleteById(orderId);
        } catch (Exception e) {
        }
    }

    @Override
    public Order editOrder(Integer orderId, Order order) {
        Order or = orderRepo.getById(orderId);
        
        try {
             or.setOrderName(order.getOrderName());
             or.setOrderType(order.getOrderType());
             or.setDescription(order.getDescription());
            
        } catch (Exception e) {
            or=null;
            
        }
        return or;
    }

    @Override
    public List<Order> listAllOrder() {
        List<Order> orderList =null;
        try {
            orderList = orderRepo.findAll();
                    
            
        } catch (Exception e) {
            orderList =null;
                    
        }
        return orderList;
        
    }
    
}
