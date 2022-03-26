/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.BrandRepository;
import com.inventory.deva_inventory.model.Brand;
import com.inventory.deva_inventory.service.BrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author best
 */
@Service
public class BrandServiceImpl implements BrandService{
 
    @Autowired
    private BrandRepository brandRepo;
    @Override
    public Brand findBrandById(Integer brandId) {
        return null;
        }

    @Override
    public Brand findBrandByName(String brandName) {
      return null;  
    }

    @Override
    public Brand saveBrand(Brand brandData) {
      Brand brand=null;
        try {
             brand = brandRepo.save(brandData);
            
        } catch (Exception e) {
            brand = null;
        }
        return  brand;      
                }

    @Override
    public void deleteBrand(Integer brandId) {
        try {
            brandRepo.deleteById(brandId);
        } catch (Exception e) {
            
        }
    }

    @Override
    public Brand editBrand(Integer brandId, Brand brandDetail) {
        Brand updatedBrand =null;
        try {
             Brand brand = brandRepo.getById(brandId);
             brand.setBrandName(brandDetail.getBrandName());
             brand.setBrandDescription(brandDetail.getBrandDescription());
             updatedBrand = brandRepo.save(brand);
        } catch (Exception e) {
            updatedBrand =null;
        }
        return updatedBrand;
    }

    @Override
    public List<Brand> listAllBrand() {
         
      List<Brand> brandList  =null;
        try {
            brandList =brandRepo.findAll();
        } catch (Exception e) {
            brandList =null;
        }
        
return brandList;
        
    }
}
