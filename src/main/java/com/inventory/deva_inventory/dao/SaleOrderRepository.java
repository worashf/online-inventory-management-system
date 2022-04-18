
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.Product;
import com.inventory.deva_inventory.model.SaleOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository 
public interface SaleOrderRepository  extends JpaRepository<SaleOrder, Integer>{
    public  SaleOrder findSaleOrderBySaleOrderNumber(String saleOrderNumber);
   @Query("SELECT so FROM SaleOrder so   JOIN  so.order o  WHERE o.orderId =:orderId")
     SaleOrder getAllSaleOrderByOrderId(@Param (value ="orderId") Integer orderId);
            @Query("SELECT so FROM SaleOrder so LEFT OUTER JOIN  so.order o "
                    + "LEFT OUTER JOIN o.supplier s  WHERE"
                    + " s.supplierId =:supplierId")
 List<SaleOrder> getSaleOrderBySupplierId(@Param (value ="supplierId") Integer supplierId); 
}
