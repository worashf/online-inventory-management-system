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
    public CategoryDto AddCategory(CategoryDto catDto) {
        Category cat = convertCategoryDtoToCategoryEntity(catDto);
        Category savedCat = catRepo.save(cat);
        CategoryDto savedDto = convertCategoryEntityToCategoryDto(savedCat);
        return savedDto;
    }

    @Override
    public CategoryDto searchByCategoryId(Long categoryId) {
         Category cat = catRepo.findByCategoryId(categoryId);
          CategoryDto catDto = new CategoryDto();
        catDto.setCategoryId(cat.getCategoryId());
        catDto.setCategoryName(cat.getCategoryName());
        catDto.setCategoryDescription(cat.getCategoryDescription());
        return catDto;
    }

    @Override
    public List<CategoryDto> ListAllCategory() {
     List<Category> catList = catRepo.findAll();
      List<CategoryDto> catDtolist = new ArrayList<>();
        CategoryDto catDto = new CategoryDto();
      for(Category cat: catList){
         catDto.setCategoryId(cat.getCategoryId());
        catDto.setCategoryName(cat.getCategoryName());
        catDto.setCategoryDescription(cat.getCategoryDescription());
        catDtolist.add(catDto);
      }
      return  catDtolist;
              
     
    }

    @Override
    public CategoryDto editCategory(CategoryDto catDto) {
       CategoryDto cat_dto = searchByCategoryId(convertCategoryDtoToCategoryEntity(catDto).getCategoryId());
     
        Category cat = new Category();
        cat.setCategoryId(cat_dto.getCategoryId());
        cat.setCategoryName(cat_dto.getCategoryName());
        cat.setCategoryDescription(cat_dto.getCategoryDescription());
        
        Category editedCat = catRepo.save(cat);
        CategoryDto savedDto = convertCategoryEntityToCategoryDto(editedCat);
       
    return savedDto;
    }

    @Override
    public CategoryDto findCategoryByName(String categoryName) {
      
          Category cat = catRepo.findBycategoryName(categoryName);
          CategoryDto catDto = new CategoryDto();
        catDto.setCategoryId(cat.getCategoryId());
        catDto.setCategoryName(cat.getCategoryName());
        catDto.setCategoryDescription(cat.getCategoryDescription());
        return catDto;
        }

 
}
