/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;


import com.inventory.deva_inventory.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author best
 */
@Repository
public interface ProductRepository  extends  JpaRepository<Product, Integer>{
        @Query("SELECT p FROM Product p  JOIN  p.order o  WHERE o.orderId =:orderId")
     List<Product>  getAllProductByOrderId(@Param (value ="orderId") Integer orderId);
      
}
