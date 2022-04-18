/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.User;
import java.util.List;

/**
 *
 * @author best
 */
public interface UserService {
         public User saveUser ( Integer roleId ,User user);
    public User updatUser(Integer userId,User user);
    public  void    deleteUser(Integer userId);
    public  List<User> listUsers();
}
