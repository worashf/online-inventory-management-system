
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.OrderRepository;
import com.inventory.deva_inventory.dao.SaleOrderRepository;
import com.inventory.deva_inventory.model.Order;
import com.inventory.deva_inventory.model.SaleOrder;
import com.inventory.deva_inventory.service.SaleOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SaleOrderServiceImpl implements SaleOrderService{

    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired 
    private  OrderRepository   orderRepository;
    @Override
    public SaleOrder saveSaleOrder(Integer orderId, SaleOrder saleOrder) {
          Order order = null;
        try {
             order = orderRepository.getById(orderId);
             order.setOrderStatus("supplier_spproved");
             order = orderRepository.save(order);
             saleOrder.setOrder(order);
             saleOrder.setSaleOrderStatus("supplier_created");
             saleOrder = saleOrderRepository.save(saleOrder);
        } catch (Exception e) {
            saleOrder =null;
        }
   return  saleOrder;
    
    }

    @Override
    public SaleOrder updateSaleOrder(Integer saleOrderId, SaleOrder sOrder) {
        try {
            
        } catch (Exception e) {
        }
    return null;
    
    }

    @Override
    public void deleteSaleOrder(Integer slaeOrder) {
        
       saleOrderRepository.deleteById(slaeOrder);
    }

    @Override
    public List<SaleOrder> listSaleOrder() {
       List<SaleOrder> listSaleOrder =null;
        try {
            listSaleOrder = saleOrderRepository.findAll();
        } catch (Exception e) {
            listSaleOrder =null;
        }
  return null;
    
    }

    @Override
    public SaleOrder listSaleOrderByOrder(Integer orderId) {
       SaleOrder saleOrder = null;
        try {
             saleOrder = saleOrderRepository.getAllSaleOrderByOrderId(orderId);
        } catch (Exception e) {
            saleOrder =null;
        }
       return saleOrder; 
    }

    @Override
    public List<SaleOrder> listAllSaleOrderBySupplier(Integer supplierId) {
        
        List<SaleOrder> listSaleOrder =null;
        try {
            listSaleOrder = saleOrderRepository.getSaleOrderBySupplierId(supplierId);
            
        } catch (Exception e) {
            listSaleOrder =null;
        }
       
return listSaleOrder;
    }
    
}
