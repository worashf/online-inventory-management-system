/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public class TokenResponse {
  private String userName ;
    private List<String>  roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
     public void addRole(String role){
		
		if (roles == null){
			roles = new ArrayList<>();
		}
		
		roles.add(role);
	}
    
    
}
