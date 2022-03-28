/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Supplier;
import java.util.List;

/**
 *
 * @author best
 */
public interface SupplierService {
    public Supplier saveSupplier(Supplier sup);
    public Supplier updateSupplier(Integer supId,Supplier sup);
    public Supplier changeSupplierStatus(Integer supId, String supplierStatus);
    public void  deleteSupplier (Integer supId);
    public List<Supplier> getAllSupplier();
    
}
