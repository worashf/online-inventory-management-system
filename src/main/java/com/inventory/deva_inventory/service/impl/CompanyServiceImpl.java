/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.CompanyRepository;
import com.inventory.deva_inventory.model.Company;
import com.inventory.deva_inventory.service.CompanyService;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author best
 */
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
 private CompanyRepository compRepo;
    @Override
    public Company saveCompany(Company com) {
         Company comp =null;
        try {
         comp= compRepo.save(com);     
        } catch (NoResultException e) {
            comp =null;
        }
        return comp;
    }

    @Override
    public Company editCompany(Company com) {
             Company comp =null;
             
        try {
         comp= compRepo.updateCategory(com.getCompanyId(), com.getCompanyName()
                 ,com.getEmail(),com.getPhone1(), com.getPhone2());
        } catch (NoResultException e) {
            comp =null;
        }
        return comp;
    } 
    }
    

