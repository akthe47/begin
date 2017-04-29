/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;
import java.util.List;

import com.mind.ak47.begin.model.ClientSociete;
/**
 *
 * @author ak47@minduos
 */
public interface ClientSocieteService {
        ClientSociete findById(int id);
	
	void save(ClientSociete client);
	public void update(ClientSociete client);
	void deleteById(int id);
	
	List<ClientSociete> findAllClient();
    
}
