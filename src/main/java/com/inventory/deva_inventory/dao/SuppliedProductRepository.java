/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.OrderProduct;
import com.inventory.deva_inventory.model.SaleOrder;
import com.inventory.deva_inventory.model.SuppliedProduct;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliedProductRepository  extends JpaRepository<SuppliedProduct, Integer>{
      @Query("SELECT sp FROM SuppliedProduct sp  JOIN  sp.saleOrder so  WHERE so.saleOrderId =:saleOrderId")
     List<SuppliedProduct>  getAllSuppliedProductBySaleOrderId(@Param (value ="saleOrderId") Integer saleOrderId);
       
@Query("SELECT sp FROM SuppliedProduct sp LEFT OUTER JOIN  sp.saleOrder so "
                    + "LEFT OUTER JOIN so.order o  WHERE"
                    + " o.orderId =:orderId")
 List<SuppliedProduct> getSuppliedProductByOrderId(@Param (value ="orderId") Integer orderId); 

 @Query("SELECT sp FROM SuppliedProduct sp   WHERE sp.suppliedProductStatus =:suppliedProductStatus")
 List<SuppliedProduct>  getAllSupplieredProductStatus(@Param (value ="suppliedProductStatus") String suppliedProductStatus);
}
