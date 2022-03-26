/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Brand;

/**
 *
 * @author best
 */
public interface BrandService {
     public Brand findBrandById(Long brandId);
     public Brand findBrandByName(String brandName);
     public Brand  saveBrand( Brand b);
     public Brand  deleteBrand(Long brandId);
     public Brand  editBrand(Brand b);
     public Brand listAllBrand();
     
     
     
     
}
