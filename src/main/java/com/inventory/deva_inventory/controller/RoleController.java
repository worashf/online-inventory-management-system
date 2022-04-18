/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Role;
import com.inventory.deva_inventory.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mntemnte
 */
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;
      @PostMapping("/roles")
 public ResponseEntity<Role>  saveRole(@RequestBody Role role){
        Role rol = roleService.saveRole(role);
        HttpHeaders headers = new HttpHeaders();
          System.out.println(role);
        headers.add("Responded", "CategoryController");
        return ResponseEntity.accepted().headers(headers).body(rol);
 }
          @GetMapping("/roles")
 public  ResponseEntity<List<Role>> ListAllroles(){
   List<Role> listRole = roleService.listRoles();
   return  ResponseEntity.ok().body(listRole);
 }
}
