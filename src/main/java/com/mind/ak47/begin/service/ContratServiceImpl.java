/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

/**
 *
 * @author ak47@minduos
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.ContratDao;
import com.mind.ak47.begin.model.Contrat;
import java.util.List;


 
@Service("ContratService")
@Transactional
public class ContratServiceImpl implements ContratService{
    @Autowired
ContratDao dao;
    public Contrat findById(int id){return dao.findById(id);}
	
	public void save(Contrat contrat){dao.save(contrat);}
	public void update(Contrat client) {
		Contrat entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setDatedesignation(client.getDatedesignation());
			entity.setDatesignature(client.getDatesignature());
			entity.setMthtva(client.getMthtva());
                        entity.setMttva(client.getMtttc()-client.getMthtva());
                        entity.setPtva(client.getPtva());
                        entity.setMtttc(client.getMtttc());
                        entity.setObservation(client.getObservation());
                        
                        
		}
	}
        public void updatepath(Contrat client) {
		Contrat entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setLiendoc(client.getLiendoc());
			
                        
		}
	}
	public void deleteById(int id){dao.deleteById(id);}
	public List<Contrat> findbyContrat(int p){return dao.findBypr(p);}
	public List<Contrat> findAllContrat(){return dao.findAllContrat();}
}
