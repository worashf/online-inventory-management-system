/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.CategoryRepository;
import com.inventory.deva_inventory.dto.CategoryDto;
import com.inventory.deva_inventory.model.Category;
import com.inventory.deva_inventory.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author best
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository catRepo;

    public CategoryDto convertCategoryEntityToCategoryDto(Category cat) {

        CategoryDto catDto = new CategoryDto();
        catDto.setCategoryId(cat.getCategoryId());
        catDto.setCategoryName(cat.getCategoryName());
        catDto.setCategoryDescription(cat.getCategoryDescription());
        return catDto;
    }

    public Category convertCategoryDtoToCategoryEntity(CategoryDto catDto) {

        Category cat = new Category();
        cat.setCategoryId(catDto.getCategoryId());
        cat.setCategoryName(catDto.getCategoryName());
        cat.setCategoryDescription(catDto.getCategoryDescription());
        return cat;
    }

    @Override
    public Category AddCategory(Category cat) {
        Category savedCat  =null;
        try {
             savedCat = catRepo.save(cat);
        } catch (Exception e) {
            savedCat =null;
        }
      
       
        return savedCat;
    }

    @Override
    public Category searchByCategoryId(Integer categoryId) {
        Category cat =null;
        try {
             cat =catRepo.findByCategoryId(categoryId);
        } catch (Exception e) {
            cat =null;
        }
        
       
        return cat;
    }

    @Override
    public List<Category> ListAllCategory() {
        
        List<Category> catList = catRepo.findAll();
      
      
return catList;
        
    }
@Transactional
    @Override
    public Category editCategory(Category cat) {
//       CategoryDto cat_dto = searchByCategoryId(convertCategoryDtoToCategoryEntity(catDto).getCategoryId());
//         
//        Category cat = new Category();
//        cat.setCategoryId(cat_dto.getCategoryId());
//        cat.setCategoryName(cat_dto.getCategoryName());
//        cat.setCategoryDescription(cat_dto.getCategoryDescription());
//        
//        Category editedCat = catRepo.save(cat);
//        CategoryDto savedDto = convertCategoryEntityToCategoryDto(editedCat);
        Category updatedCat = null;
        try {
            Category cat1 =null;
            cat1 = catRepo.getById(cat.getCategoryId());
           
            System.out.println(cat.getCategoryId() + " data " + cat.getCategoryName());
            Integer catId = catRepo.editCategory(cat1.getCategoryId(), cat1.getCategoryName(), cat1.getCategoryDescription());
              System.out.println(catId);
             updatedCat = catRepo.findBycategoryName(cat1.getCategoryName());
           
            System.out.println(updatedCat);
       } catch (Exception e) {
            updatedCat= null;
            System.out.println(e.getMessage());
        }

        return updatedCat;
    }

    @Override
    public Category findCategoryByName(String categoryName) {

        Category cat = catRepo.findBycategoryName(categoryName);
       
        return cat;
    }

  

}
