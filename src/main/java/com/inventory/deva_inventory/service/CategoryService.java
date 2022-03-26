/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.dto.CategoryDto;
import com.inventory.deva_inventory.model.Category;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author best
 */
public interface CategoryService {
    public Category AddCategory( Category cat);
  
    public Category searchByCategoryId( Integer categoryId);
    public List<Category> ListAllCategory();
    public Category editCategory(Integer catId,Category cat);
    public Category findCategoryByName(String categoryName);
    public void deleteCategory(Integer catId);
    
    
    

    
            
 
 }


