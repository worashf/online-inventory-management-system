/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mntemnte
 */
@Repository
public interface OrderProductRepository  extends JpaRepository<OrderProduct, Integer>{
    
}
