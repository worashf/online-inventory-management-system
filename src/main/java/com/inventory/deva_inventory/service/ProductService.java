/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Product;
import java.util.List;

/**
 *
 * @author best
 */
public interface ProductService {
     public Product   saveProduct(Integer supplierId, String orderNUmber, Product  product);
     public void deleteProduct  ( Integer orderProductId);
     public Product   editProduct  (Integer productId,Product   product);
     public List<Product > listAllProduct  ();
      public List<Product > listAllProductById  (Integer orderId);
     
}
