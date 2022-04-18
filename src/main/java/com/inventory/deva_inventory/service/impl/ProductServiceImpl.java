/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.OrderRepository;
import com.inventory.deva_inventory.dao.ProductRepository;
import com.inventory.deva_inventory.dao.SupplierRepository;
import com.inventory.deva_inventory.model.Order;
import com.inventory.deva_inventory.model.Product;
import com.inventory.deva_inventory.model.Supplier;
import com.inventory.deva_inventory.service.ProductService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author best
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private SupplierRepository supplierRepo;
    
    @Override
    public Product saveProduct(Integer supplierId, String orderNumber, Product product) {
        
          Order ord =null;
          Product prod =null;
         Supplier sup =null;
        
        try {
            Date date = new Date();
             ord = orderRepo.getAllOrderByOrderNumber(orderNumber);
             sup = supplierRepo.getById(supplierId);
             
            product.setOrder(ord);
            product.setRecievedDate(date);
            product.setSupplier(sup);
            prod = productRepo.save(product);
            
        } catch (Exception e) {
            prod =null;
        }
        return prod;
    }

    @Override
    public void deleteProduct(Integer orderProductId) {
        try {
            productRepo.deleteById(orderProductId);
        } catch (Exception e) {
        }
     
        
    }

    @Override
    public Product editProduct(Integer productId, Product product) {
      Product prod =null;
        try {
            Date date  = new Date();
            prod = productRepo.getById(productId);
            prod.setProductNumber(product.getProductNumber());
            prod.setProductName(product.getProductName());
            prod.setProductQuantity(product.getProductQuantity());
            prod.setProductPrice(product.getProductPrice());
            prod.setRecievedDate(date);
            prod.setExpiryDate(product.getExpiryDate());
            prod = productRepo.save(prod);
        } catch (Exception e) {
        prod =null;
        }
        return prod;
    }

    @Override
    public List<Product> listAllProduct() {
        List<Product> listPro;
        
        try {
             listPro = productRepo.findAll();
        } catch (Exception e) {
            listPro =null;
        }
        return listPro;
    }

    @Override
    public List<Product> listAllProductById(Integer orderId) {
      List<Product> listPro =null;
        try {
            listPro = productRepo.getAllProductByOrderId(orderId);
        } catch (Exception e) {
            listPro =null;
        }
        return listPro;
    }
    
}
