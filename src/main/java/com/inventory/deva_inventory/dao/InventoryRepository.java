/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.Inventory;
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
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
     @Query("SELECT inv FROM Inventory inv  JOIN  inv.store s  WHERE s.storeId =:storeId")
     List<Inventory>  getAllInventoryByStoreId(@Param (value ="storeId") Integer storeId);
        
}
