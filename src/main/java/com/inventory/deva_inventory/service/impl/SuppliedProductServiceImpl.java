/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.OrderRepository;
import com.inventory.deva_inventory.dao.SaleOrderRepository;
import com.inventory.deva_inventory.dao.SuppliedProductRepository;
import com.inventory.deva_inventory.model.SaleOrder;
import com.inventory.deva_inventory.model.SuppliedProduct;
import com.inventory.deva_inventory.service.SuppliedProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliedServiceImpl implements SuppliedProductService {

    @Autowired
    private SuppliedProductRepository supProductRepo;
    @Autowired
    private SaleOrderRepository saleOrderRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Override
    public SuppliedProduct saveSuppliedProduct(Integer slaOrderId, SuppliedProduct suppliedProduct) {
        SaleOrder saleOrder = null;

        try {
            saleOrder = saleOrderRepo.getById(slaOrderId);
            suppliedProduct.setSaleOrder(saleOrder);
            suppliedProduct.setSuppliedProductStatus("send");
            suppliedProduct = supProductRepo.save(suppliedProduct);

        } catch (Exception e) {
            suppliedProduct = null;
        }
        return suppliedProduct;
    }

    @Override
    public void deleteSuppliedProduct(Integer suppliedProductId) {
        supProductRepo.deleteById(suppliedProductId);
    }

    @Override
    public SuppliedProduct editSuppliedProduct(Integer suppliedProductId, SuppliedProduct suppliedProduct) {
        SuppliedProduct supProduct = supProductRepo.getById(suppliedProductId);
        try {
            supProduct.setSuppliedProductName(suppliedProduct.getSuppliedProductName());
            supProduct.setSuppliedProductPrice(suppliedProduct.getSuppliedProductPrice());
            supProduct.setSuppliedProductQuantity(suppliedProduct.getSuppliedProductQuantity());
            supProduct = supProductRepo.save(supProduct);
        } catch (Exception e) {
            supProduct = null;
        }
        return supProduct;
    }

    @Override
    public List<SuppliedProduct> listAllSuppliedProduct() {
        List<SuppliedProduct> supProduct = null;
        try {
            supProduct = supProductRepo.findAll();
        } catch (Exception e) {
            supProduct = null;
        }

        return supProduct;
    }

    @Override
    public List<SuppliedProduct> listAllSuppliedProductBySaleOrderId(Integer saleOrderId) {
        List<SuppliedProduct> supProduct = null;
        try {
            supProduct = supProductRepo.getAllSuppliedProductBySaleOrderId(saleOrderId);
        } catch (Exception e) {
            supProduct = null;
        }

        return supProduct;
    }

    @Override
    public List<SuppliedProduct> listAllSuppliedProductByrderId(Integer orderId) {
        List<SuppliedProduct> supProduct = null;
        try {
            supProduct = supProductRepo.getSuppliedProductByOrderId(orderId);
        } catch (Exception e) {
            supProduct = null;
        }

        return supProduct;
    }

}
