/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.OrderProduct;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mntemnte
 */
@Repository
public interface OrderProductRepository  extends JpaRepository<OrderProduct, Integer>{
  
      @Query("SELECT op FROM OrderProduct op  JOIN  op.order o  WHERE o.orderId =:orderId")
     List<OrderProduct>  getAllProductById(@Param (value ="orderId") Integer orderId);
        
    
} 
