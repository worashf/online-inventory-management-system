
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Product;
import com.inventory.deva_inventory.model.SaleOrder;
import com.inventory.deva_inventory.model.Supplier;
import com.inventory.deva_inventory.service.SaleOrderService;
import com.inventory.deva_inventory.service.SupplierService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaleOrderController {
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SupplierService  supService;
     
         @PostMapping("/sale-orders/{orderId}")
   public ResponseEntity<SaleOrder> saveSaleOrder(@PathVariable Integer orderId,@RequestBody SaleOrder saleOrder){ 
         SaleOrder saleO = saleOrderService.saveSaleOrder(orderId, saleOrder);
         return  ResponseEntity.ok().body(saleO);
    }
    @PutMapping("/sale-orders/{saleOrderId}")
    public ResponseEntity<SaleOrder> updateSaleOrder(@PathVariable Integer saleOrderId,
            @RequestBody SaleOrder saleOrder){
        
            SaleOrder  saleO = saleOrderService.updateSaleOrder(saleOrderId, saleOrder);
          return ResponseEntity.ok().body(saleO);
    }
    @GetMapping("/sale-orders")
    public ResponseEntity<List<SaleOrder>> getAllSaleOrders(){
       
         List<SaleOrder> listSaleO = saleOrderService.listSaleOrder();
        return ResponseEntity.ok().body(listSaleO);
    }
       @GetMapping("/sale-orders/{orderId}")
    public ResponseEntity<SaleOrder> getSaleOrderByOrderId(@PathVariable Integer orderId){
       
         SaleOrder listSaleOrder = saleOrderService.listSaleOrderByOrder(orderId);
        return ResponseEntity.ok().body(listSaleOrder);
    }
           @GetMapping("/sale-orders/supplier/{userName}")
    public ResponseEntity<List<SaleOrder>> getSaleOrderBySupplierId(@PathVariable String userName){
         Supplier sup = supService.findSupplierByUser(userName);
         List<SaleOrder> listSaleOrder = saleOrderService.listAllSaleOrderBySupplier(sup.getSupplierId());
        return ResponseEntity.ok().body(listSaleOrder);
    }
    @DeleteMapping("/sale-orders/{saleOrderId}")
    public ResponseEntity<Map<String,Boolean>> deleteSaleOrder(@PathVariable Integer saleOrderId){
            saleOrderService.deleteSaleOrder(saleOrderId);
           Map<String,Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return ResponseEntity.ok(response);
    }


    
    
}
