/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;


import com.inventory.deva_inventory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author best
 */
@Repository
public interface CategoryRepository  extends  JpaRepository<Category, Integer> {
     public Category findByCategoryId(Integer categoryId);
     public Category findBycategoryName( String categoryName);

 @Modifying
    @Query("Update Category c set c.categoryName= :categoryName, c.categoryDescription = :categoryDescription"
             + "  WHERE c.categoryId = :categoryId")
    public Integer editCategory( @Param("categoryId") Integer categoryId, 
            @Param("categoryName") String categoryName,
           @Param("categoryDescription") String categoryDescription);
}
