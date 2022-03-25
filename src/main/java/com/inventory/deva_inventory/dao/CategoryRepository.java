/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;


import com.inventory.deva_inventory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author best
 */
public interface CategoryRepository  extends  JpaRepository<Category, Long> {
     public Category findByCategoryId(Long categoryId);
     public Category findBycategoryName( String categoryName);
}
