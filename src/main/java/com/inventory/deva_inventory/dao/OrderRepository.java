/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.dao;


import com.inventory.deva_inventory.model.Order;
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
public interface OrderRepository  extends JpaRepository<Order, Integer>{
    
     
      @Query("SELECT o FROM Order o   WHERE o.orderNumber =:orderNumber")
     Order  getAllOrderByOrderNumber(@Param (value ="orderNumber") String  orderNumber);
              @Query("SELECT o FROM Order o LEFT OUTER JOIN  o.supplier s  WHERE"
                    + " s.supplierId =:supplierId")
 List<Order> getOrderBySupplierId(@Param (value ="supplierId") Integer supplierId); 
}
