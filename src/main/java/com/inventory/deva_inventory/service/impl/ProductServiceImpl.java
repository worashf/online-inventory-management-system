/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.BrandRepository;
import com.inventory.deva_inventory.dao.CategoryRepository;
import com.inventory.deva_inventory.dao.InventoryRepository;
import com.inventory.deva_inventory.dao.OrderRepository;
import com.inventory.deva_inventory.dao.ProductRepository;
import com.inventory.deva_inventory.dao.SuppliedProductRepository;
import com.inventory.deva_inventory.dao.SupplierRepository;
import com.inventory.deva_inventory.model.Brand;
import com.inventory.deva_inventory.model.Category;
import com.inventory.deva_inventory.model.Inventory;
import com.inventory.deva_inventory.model.Order;
import com.inventory.deva_inventory.model.Product;
import com.inventory.deva_inventory.model.SuppliedProduct;
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
    @Autowired
    private SuppliedProductRepository supProductRepository;
    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private BrandRepository brandRepo;
    @Autowired
    private InventoryRepository invRepo;
    
    @Override
    public Product saveProduct(Integer supplierId, Integer suppliedProductId,
            Integer categoryId, Integer brandId,Product  product) {
        
    
          Product prod =null;
         Supplier sup =null;
         SuppliedProduct suppliedProduct=null;
         Category cat =null;
         Brand brand =null;
        
        try {
            Date date = new Date();
            suppliedProduct = supProductRepository.getById(suppliedProductId);
            suppliedProduct.setSuppliedProductStatus("recieved");
            suppliedProduct = supProductRepository.save(suppliedProduct);
            cat = catRepo.getById(categoryId);
            brand = brandRepo.getById(brandId);
            sup = supplierRepo.getById(supplierId);
            product.setSupProduct(suppliedProduct);
            product.setRecievedDate(date);
            product.setSupplier(sup);
            product.setCategory(cat);
            product.setBrand(brand);
            product.setStockStatus("un-stocked");
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

    @Override
    public List<Product> listAllProductByCategoryId(Integer categoryId) {
     List<Product> listPro =null;
        try {
            listPro = productRepo.getAllProductByCategory(categoryId);
        } catch (Exception e) {
            listPro =null;
        }
        return listPro;
    }

    @Override
    public List<Product> listAllProductByBrandId(Integer brandId) {
         List<Product> listPro =null;
        try {
            listPro = productRepo.getAllProductByBrand(brandId);
        } catch (Exception e) {
            listPro =null;
        }
        return listPro;    }

    @Override
    public Product getProductByProductNumber(String productNumber) {
         Product pro =null;
        try {
            pro = productRepo.getProductbyProductNumner(productNumber);
        } catch (Exception e) {
            pro =null;
        }
        return pro; 
    }

    @Override
    public List<Product> listAllProductByProductStockStatus(String stockStatus) {
     List<Product> listPro =null;
        try {
            listPro = productRepo.getAllProductByStockStatus(stockStatus);
        } catch (Exception e) {
            listPro =null;
        }
        return listPro;  
    
    }

    @Override
    public Product addProductToInventory(Integer productId, String inventoryCode) {
            Product pro =null;
            Inventory inv =null;
        try {
            inv = invRepo.getInventoryByInventoryCode(inventoryCode);
            pro = productRepo.getById(productId);
            pro.setInventory(inv);
            pro.setStockStatus("stocked");
            pro = productRepo.save(pro);
        } catch (Exception e) {
            pro =null;
        }
        return pro; 

    }

    @Override
    public List<Product> listProductByInventory(Integer inventoryId) {
       List<Product> listPro =null;
        try {
            listPro = productRepo.getAllProductByInventory(inventoryId);
        } catch (Exception e) {
            listPro =null;
        }
        return listPro;      
    
    }
    
}
