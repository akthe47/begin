/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.ClientDao;
import com.mind.ak47.begin.model.Client;

/**
 *
 * @author ak47@minduos
 */
@Service("ClientService")
@Transactional
public class ClientServiceImpl implements ClientService{
        @Autowired
	ClientDao dao;
        
        public Client findById(int id){return dao.findById(id);}
	
	public void save(Client client){dao.save(client);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Client> findAllClient(){return dao.findAllClient();}
    
}
