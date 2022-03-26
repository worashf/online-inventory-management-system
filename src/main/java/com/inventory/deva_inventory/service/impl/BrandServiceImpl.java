/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.model.Brand;
import com.inventory.deva_inventory.service.BrandService;
import org.springframework.stereotype.Service;

/**
 *
 * @author best
 */
@Service
public class BrandServiceImpl implements BrandService{

    @Override
    public Brand findBrandById(Long brandId) {
        return null;
        }

    @Override
    public Brand findBrandByName(String brandName) {
      return null;  
    }

    @Override
    public Brand saveBrand(Brand b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Brand deleteBrand(Long brandId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Brand editBrand(Brand b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Brand listAllBrand() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
