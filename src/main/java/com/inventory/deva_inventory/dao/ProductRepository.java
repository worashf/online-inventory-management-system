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
     @Query("SELECT p FROM Product p  JOIN  p.category c  WHERE c.categoryId =:categoryId")
    List<Product> getAllProductByCategory(@Param (value = "categoryId") Integer brandId);
    @Query("SELECT p FROM Product p  JOIN  p.brand b  WHERE b.brandId=:brandId")
    List<Product> getAllProductByBrand(@Param (value = "brandId") Integer brandId);
    @Query("SELECT p FROM Product p  JOIN  p.inventory inv  WHERE inv.inventoryId=:inventoryId")
    List<Product> getAllProductByInventory(@Param (value = "inventoryId") Integer inventoryId);
    @Query("SELECT p FROM Product p   WHERE p.productNumber=:productNumber ")
    Product getProductbyProductNumner(@Param (value = "productNumber")String productNumber);
   @Query("SELECT p FROM Product p    WHERE p.stockStatus=:stockStatus")
    List<Product> getAllProductByStockStatus(@Param (value = "stockStatus") String stockStatus);
   
}
