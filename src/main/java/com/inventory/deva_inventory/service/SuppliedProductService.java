/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.SuppliedProduct;
import java.util.List;

public interface SuppliedProductService {

    public SuppliedProduct saveSuppliedProduct(Integer slaOrderId, SuppliedProduct suppliedProduct);

    public void deleteSuppliedProduct(Integer suppliedProductId);

    public SuppliedProduct editSuppliedProduct(Integer suppliedProductId, SuppliedProduct suppliedProduct);

    public List<SuppliedProduct> listAllSuppliedProduct();

    public List<SuppliedProduct> listAllSuppliedProductBySaleOrderId(Integer saleOrderId);

    public List<SuppliedProduct> listAllSuppliedProductByrderId(Integer orderId);
}
