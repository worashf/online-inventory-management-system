/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Role;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface RoleService {
        public Role saveRole(Role role);

    public Role updateRole(Integer roleId, Role role);

    public void deleteRole(Integer roleId);

    public List<Role> listRoles();
}
