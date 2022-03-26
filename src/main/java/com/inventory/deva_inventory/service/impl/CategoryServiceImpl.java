/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.CategoryRepository;

import com.inventory.deva_inventory.model.Category;
import com.inventory.deva_inventory.service.CategoryService;

import java.util.List;


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
      List<Category> catList  =null;
        try {
            catList =catRepo.findAll();
        } catch (Exception e) {
            catList =null;
        }
      
      
      
return catList;
        
    }
@Transactional
    @Override
    public Category editCategory(Integer catId,Category catDetail) {

        Category updatedCat = null;
        try {
          Category  cat;
            cat = catRepo.getById(catId);

            System.out.println(cat.getCategoryId() + " data " + cat.getCategoryName());
 
             cat.setCategoryName(catDetail.getCategoryName());
             cat.setCategoryDescription(catDetail.getCategoryDescription());
             
      
             updatedCat= catRepo.save(cat);
           
            System.out.println(updatedCat.getCategoryName());
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

    @Override
    public void deleteCategory(Integer catId) {
        try {
             catRepo.deleteById(catId);
            
        } catch (Exception e) {
        }
    }

  

}
