
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.Inventory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("SELECT inv FROM Inventory inv  JOIN  inv.store s  WHERE s.storeId =:storeId")
    List<Inventory> getAllInventoryByStoreId(@Param(value = "storeId") Integer storeId);

    @Query("SELECT inv FROM Inventory inv   WHERE inv.inventoryCode=:inventoryCode")
    Inventory getInventoryByInventoryCode(@Param(value = "inventoryCode") String InventoryCode);

    @Query("SELECT inv FROM Inventory inv   WHERE inv.reorderLevel=:reorderLevel")
    List<Inventory> getInventoryByReorderLevel(@Param(value = "reorderLevel") Integer reorderLevel);

    @Query("SELECT inv FROM Inventory inv   WHERE inv.alertLevel=:alertLevel")
    List<Inventory> getInventoryByAlertLevel(@Param(value = "alertLevel") Integer alertLevel);
    
    
    

}
