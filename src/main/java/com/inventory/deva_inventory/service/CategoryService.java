/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.dto.CategoryDto;
import com.inventory.deva_inventory.model.Category;
import java.util.List;

/**
 *
 * @author best
 */
public interface CategoryService {
    public CategoryDto AddCategory( CategoryDto catDto);
  
    public CategoryDto  searchByCategoryId( Long categoryId);
    public List<CategoryDto> ListAllCategory();
    public CategoryDto  editCategory(CategoryDto catDto);
    public CategoryDto findCategoryByName(String categoryName);
    
    
    

    
            
 
 }


