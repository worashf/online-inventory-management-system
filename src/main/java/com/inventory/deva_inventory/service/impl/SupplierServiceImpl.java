/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.SupplierRepository;
import com.inventory.deva_inventory.model.Supplier;
import com.inventory.deva_inventory.service.SupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author best
 */
@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierRepository supRepo;
    @Override
    public Supplier saveSupplier(Supplier sup) {
        try {
            sup.setSupplierStatus("waiting");
            sup = supRepo.save(sup);
        } catch (Exception e) {
        }
        return sup;
    }

    @Override
    public Supplier updateSupplier(Integer supId, Supplier sup) {
          Supplier supplier = supRepo.getById(supId);
        try {
          
            supplier.setSupplierName(sup.getSupplierName());
            supplier.setEmail(sup.getEmail());
            supplier.setPhone1(sup.getPhone1());
            supplier.setPhone2(sup.getPhone2());
            
            supplier = supRepo.save(supplier);
            
            
        } catch (Exception e) {
            supplier=  null;
        }
        return supplier;
    }

    @Override
    public void deleteSupplier(Integer supId) {
        try {
            supRepo.deleteById(supId);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Supplier> getAllSupplier() {
        List<Supplier> supList = null;
        try {
            supList= supRepo.findAll();
        } catch (Exception e) {
            supList =null;
        }
        return supList;
                
    }

    @Override
    public Supplier changeSupplierStatus(Integer supId, String supplierStatus) {
        Supplier sup = supRepo.getById(supId);
        try {
            sup.setSupplierStatus(supplierStatus);
            sup = supRepo.save(sup);
        } catch (Exception e) {
            sup = null;
        }
        return sup;
    }
    
}
