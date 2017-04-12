/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import java.util.List;

import com.mind.ak47.begin.model.ClientPublic;

/**
 *
 * @author ak47@minduos
 */
public interface ClientPublicDao {
    ClientPublic findById(int id);
	
	void save(ClientPublic client);
	
	void deleteById(int id);
	
	List<ClientPublic> findAllClient();
    
    
}
