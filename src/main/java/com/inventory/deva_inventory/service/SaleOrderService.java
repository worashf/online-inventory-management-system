
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.SaleOrder;
import java.util.List;


public interface SaleOrderService {
    public SaleOrder saveSaleOrder(Integer  orderId, SaleOrder saleOrder);
    public  SaleOrder updateSaleOrder(Integer saleOrderId, SaleOrder sOrder);
     public void  deleteSaleOrder(Integer slaeOrder);
      public List<SaleOrder> listSaleOrder();
      public SaleOrder listSaleOrderByOrder(Integer orderId);
      public List<SaleOrder> listAllSaleOrderBySupplier(Integer supplierId);
      
    
}