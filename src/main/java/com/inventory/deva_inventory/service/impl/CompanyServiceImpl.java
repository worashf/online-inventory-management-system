/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service.impl;

import com.inventory.deva_inventory.dao.CompanyRepository;
import com.inventory.deva_inventory.model.Company;
import com.inventory.deva_inventory.service.CompanyService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author best
 */
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
 private CompanyRepository compRepo;

    @Override
    public Company saveCompany(Company comData) {
        Company comp =null;
        try {
             comp = compRepo.save(comData);
        } catch (Exception e) {
            comp =null;
        }
        return  comp;
    }

    @Override
    public Company editCompany(Integer companyId, Company compData) {
       Company comp = null;
        try {
          Company  comp1 =null;
                  comp1= compRepo.getById(companyId);
              comp1.setCompanyName(compData.getCompanyName());
              comp1.setEmail(compData.getEmail());
              comp1.setPhone1(compData.getPhone1());
              comp1.setPhone2(compData.getPhone2());
       comp=     compRepo.save(comp1);
            System.out.println(comp.getCompanyName());
        } catch (Exception e) {
            comp= null;
        }
        return comp;
    }

    @Transactional
    @Override
    public  Company  findCompany() {
       Company   listComp =null;
        try {
            listComp = compRepo.getcompany();
        } catch (Exception e) {
            listComp =null;
        }
        return  listComp;
    }
    
    }
    

