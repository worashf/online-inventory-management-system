/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.OrderProductRepository;
import com.inventory.deva_inventory.dao.OrderRepository;
import com.inventory.deva_inventory.model.Order;
import com.inventory.deva_inventory.model.OrderProduct;
import com.inventory.deva_inventory.service.OrderProductService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mntemnte
 */
@Service
public class OrderProductServiceImpl implements OrderProductService{
@Autowired
private OrderProductRepository orderProductRepo;
@Autowired 
private  OrderRepository orderRepo;
    @Override
    public OrderProduct saveOrderProduct( Integer orderId, OrderProduct orderPro) {
     
       Order order = null;
        try {
            order = orderRepo.getById(orderId);
             orderPro.setOrder(order);
//             order.getOrderProducts().add(orderPro);
            orderPro = orderProductRepo.save(orderPro);
        } catch (Exception e) {
            orderPro =null;
        }
        return  orderPro;
    }

    @Override
    public void deleteOrderProduct(Integer orderProductId) {
      
        try {
            orderProductRepo.deleteById(orderProductId);
        } catch (Exception e) {
        }
            
    }

    @Override
    public OrderProduct editOrderProduct(Integer orderProductId, OrderProduct orderProduct) {
        OrderProduct orderPro = orderProductRepo.getById(orderProductId);
        try {
            
            orderPro.setOrderProductName(orderProduct.getOrderProductName());
            orderPro.setOrderProductQuantity(orderProduct.getOrderProductId());
            orderPro.setOrderProductPrice(orderProduct.getOrderProductPrice());
        } catch (Exception e) {
            orderPro =null;
        }
        return  orderPro;
    }

    @Override
    public List<OrderProduct> listAllOrderProduct() {
        List<OrderProduct>  listOrderProduct =null;
        try {
            listOrderProduct = orderProductRepo.findAll();
        } catch (Exception e) {
            listOrderProduct =null;
        }
        return listOrderProduct;
    }

    @Transactional
    @Override
    public List<OrderProduct> listAllOrderProductById(Integer orderId) {
        List<OrderProduct> listOrderPro = null;
        try {
           listOrderPro = orderProductRepo.getAllProductById(orderId);
           
        } catch (Exception e) {
            listOrderPro =null;
        }
        return listOrderPro;
    }
    
}
