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

import com.mind.ak47.begin.dao.ClientPublicDao;
import com.mind.ak47.begin.model.ClientPublic;

/**
 *
 * @author ak47@minduos
 */
@Service("ClientPublicService")
@Transactional
public class ClientPublicServiceImpl implements ClientPublicService{
        @Autowired
	ClientPublicDao dao;
        
        public ClientPublic findById(int id){return dao.findById(id);}
	
	public void save(ClientPublic client){dao.save(client);}
	public void update(ClientPublic client) {
		ClientPublic entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setAdresse(client.getAdresse());
			
			entity.setCodeville(client.getCodeville());
                        entity.setMail(client.getMail());
                        entity.setNom(client.getNom());
                        
		}
	}
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<ClientPublic> findAllClient(){return dao.findAllClient();}
    
}
