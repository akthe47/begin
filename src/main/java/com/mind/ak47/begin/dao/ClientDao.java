/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import java.util.List;

import com.mind.ak47.begin.model.Client;

/**
 *
 * @author ak47@minduos
 */
public interface ClientDao {
    
        Client findById(int id);
	
	void save(Client client);
	
	void deleteById(int id);
	
	List<Client> findAllClient();

    
    
}
