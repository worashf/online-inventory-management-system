/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author best
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
            @Query("SELECT s FROM Supplier s  LEFT OUTER JOIN  s.user u  WHERE"
                    + " u.userName =:userName")
  Supplier getSupplierByUserName(@Param (value ="userName") String userName); 
    
}
