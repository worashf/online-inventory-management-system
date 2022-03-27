/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.controller;

import com.inventory.deva_inventory.model.Company;
import com.inventory.deva_inventory.model.Store;
import com.inventory.deva_inventory.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author best
 */
@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyService compService;
       
  @PostMapping("/company")
    public ResponseEntity<Company> saveCompany(@RequestBody Company companyData){
    Company comp = compService.saveCompany(companyData);
        return  ResponseEntity.ok(comp);
    }
    @PutMapping("/company/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable Integer companyId,@RequestBody Company companyData){
        Company comp = compService.editCompany(companyId, companyData);
 
        return ResponseEntity.ok(comp);
    }
    @GetMapping("/company")
    public ResponseEntity<Company> getAllCompany(){
         Company listCompany = compService.getCompany();
        return ResponseEntity.ok(listCompany);
    }
    
}
