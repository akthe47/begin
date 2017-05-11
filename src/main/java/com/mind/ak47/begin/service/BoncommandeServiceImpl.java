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

import com.mind.ak47.begin.dao.BonCommandeDao;
import com.mind.ak47.begin.model.Boncommande;
import java.util.List;

@Service("BoncommandeService")
@Transactional
public class BoncommandeServiceImpl implements BoncommandeService{
        @Autowired
	BonCommandeDao dao;
    public Boncommande findById(int id){return dao.findById(id);}
	
	public void save(Boncommande bon){dao.save(bon);}
        public List<Boncommande> findBypr(int p){return dao.findBypr(p);}
	public void update(Boncommande client) {
		Boncommande entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setDatedesignation(client.getDatedesignation());
			entity.setTimbre(client.getTimbre());
			entity.setMthtva(client.getMthtva());
                        entity.setMttva(client.getMtttc()-client.getMthtva());
                        entity.setPtva(client.getPtva());
                        entity.setMtttc(client.getMtttc());
                        entity.setObservation(client.getObservation());
                        
                        
		}
	}
        public void updatepath(Boncommande client) {
		Boncommande entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setLiendoc(client.getLiendoc());
			
                        
		}
	}
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Boncommande> findAllBoncommande(){return dao.findAllBoncommande();}
}
