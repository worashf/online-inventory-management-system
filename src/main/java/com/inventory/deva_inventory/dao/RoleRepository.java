/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;

import com.inventory.deva_inventory.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author best
 */
@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer>{
    public Role  findByRoleName(String roleName); 
}
