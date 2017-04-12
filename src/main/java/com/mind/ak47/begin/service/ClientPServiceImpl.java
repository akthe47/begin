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

import com.mind.ak47.begin.dao.ClientPDao;
import com.mind.ak47.begin.model.ClientP;

/**
 *
 * @author ak47@minduos
 */
@Service("ClientPService")
@Transactional
public class ClientPServiceImpl implements ClientPService{
        @Autowired
	ClientPDao dao;
        
        public ClientP findById(int id){return dao.findById(id);}
	
	public void save(ClientP client){dao.save(client);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<ClientP> findAllClient(){return dao.findAllClient();}
    
}
