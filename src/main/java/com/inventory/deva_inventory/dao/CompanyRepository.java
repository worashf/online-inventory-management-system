/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.deva_inventory.dao;


import com.inventory.deva_inventory.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author best
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
    
        @Query("Update Company c set c.companyName= :companyName, c.email = :email, c.phone1 =:phone1, c.phone2 =:phone2 "
             + "WHERE c.companyId = :companyId")
     public Company updateCategory(@Param("companyId") Long compId, 
             @Param("companyName") String name, @Param("email") String email,
              @Param("phone1") String phone1, @Param("phone2") String phone2);

}
