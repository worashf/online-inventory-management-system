/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Brand;
import com.inventory.deva_inventory.service.BrandService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author best
 */
@RestController
@RequestMapping("/api")
public class BrandController {
    @Autowired
    private  BrandService brandService;
    
    @PostMapping("/brands")
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand){
          Brand savedBrand  = brandService.saveBrand(brand);
        return ResponseEntity.ok(savedBrand);
    }
    @GetMapping("/brands")
      public ResponseEntity<List<Brand>> getAllBrand(){
          List<Brand> listBrand  = brandService.listAllBrand();
        return ResponseEntity.ok(listBrand);
    }
      
      @PutMapping("/brands/{brandId}")
      
        public ResponseEntity< Brand>  updateBrand(@PathVariable Integer brandId,@RequestBody Brand brandDetail){
          Brand brand  = brandService.editBrand(brandId, brandDetail);
          
        return ResponseEntity.ok(brand);
    }
        @DeleteMapping("/brands/{brandId}")
        public  ResponseEntity<Map<String,Boolean>> deleteBrand(@PathVariable Integer brandId){
            brandService.deleteBrand(brandId);
            Map<String,Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
}