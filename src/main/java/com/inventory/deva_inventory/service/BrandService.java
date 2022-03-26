/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Brand;
import java.util.List;

/**
 *
 * @author best
 */
public interface BrandService {
     public Brand findBrandById(Integer brandId);
     public Brand findBrandByName(String brandName);
     public Brand  saveBrand( Brand b);
     public void deleteBrand( Integer brandId);
     public Brand  editBrand(Integer brandId,Brand b);
     public List<Brand> listAllBrand();
     
     
     
     
}
