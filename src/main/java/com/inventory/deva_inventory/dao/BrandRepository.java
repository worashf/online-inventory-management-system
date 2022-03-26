/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author best
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
      public Brand findByBrandId(Integer brandId);
     public Brand findByBrandName( String brandName);
}
