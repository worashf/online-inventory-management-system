/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.controller;


import com.inventory.deva_inventory.dto.CategoryDto;
import com.inventory.deva_inventory.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author best
 */
@RestController
@RequestMapping("/api")
public class CategoryController {
    
    @Autowired
     private CategoryService catService;
    
    @PostMapping("categories")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto){
         CategoryDto savedCat = catService.AddCategory(catDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CategoryController");
        return ResponseEntity.accepted().headers(headers).body(savedCat);
    }
    
        @PutMapping("/update-categories")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto catDto){
         CategoryDto updatedCat = catService.editCategory(catDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CategoryController");
        return ResponseEntity.accepted().headers(headers).body(updatedCat);
    }
 @GetMapping("/categories")
 public  ResponseEntity<List<CategoryDto>> ListAllCategories(){
   List<CategoryDto> catList =  catService.ListAllCategory();
   return  ResponseEntity.ok().body(catList);
 }
 @GetMapping("/categories/{categoryId}")
 public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long categoryId){
      CategoryDto catById = catService.searchByCategoryId(categoryId);
     return ResponseEntity.ok().body(catById);
 }
  @GetMapping("/categories-name/{categoryName}")
 public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable  String categoryName){
      CategoryDto catByName = catService.findCategoryByName(categoryName);
     
       return ResponseEntity.ok().body(catByName);
 
}
}