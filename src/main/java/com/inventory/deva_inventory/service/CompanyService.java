/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.service;

import com.inventory.deva_inventory.model.Company;
import java.util.List;

/**
 *
 * @author best
 */
public interface CompanyService {
    public Company saveCompany(Company com);
    public Company editCompany(Integer companyId,Company com);
    public  Company getCompany();
    
    

}
