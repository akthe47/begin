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

import com.mind.ak47.begin.dao.ClientSocieteDao;
import com.mind.ak47.begin.model.ClientSociete;

/**
 *
 * @author ak47@minduos
 */
@Service("ClientSocieteService")
@Transactional
public class ClientSocieteServiceImpl implements ClientSocieteService{
        @Autowired
	ClientSocieteDao dao;
        
        public ClientSociete findById(int id){return dao.findById(id);}
	
	public void save(ClientSociete client){dao.save(client);}
	public void update(ClientSociete client) {
		ClientSociete entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setAdresse(client.getAdresse());
			entity.setMatricule(client.getMatricule());
			entity.setCodeville(client.getCodeville());
                        entity.setMail(client.getMail());
                        entity.setRaisonSociale(client.getRaisonSociale());
                        
		}
	}
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<ClientSociete> findAllClient(){return dao.findAllClient();}
    
}
