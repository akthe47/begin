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

import com.mind.ak47.begin.dao.FactureDao;
import com.mind.ak47.begin.model.Facture;
import java.util.List;


 
@Service("FactureService")
@Transactional
public class FactureServiceImpl implements FactureService{
    
    @Autowired
    FactureDao dao;
    
    public Facture findById(int id){return dao.findById(id);}
	
	public void save(Facture facture){dao.save(facture);}
         public void update(Facture client) {
		Facture entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setDatedesignation(client.getDatedesignation());
			
			entity.setMthtva(client.getMthtva());
                        entity.setMttva(client.getMtttc()-client.getMthtva());
                        entity.setPtva(client.getPtva());
                        entity.setMtttc(client.getMtttc());
                        entity.setObservation(client.getObservation());
		}
	}
         public void updatepath(Facture client) {
		Facture entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setLiendoc(client.getLiendoc());
			
                        
		}
	}
	 public List<Facture> findBypr(int p){return dao.findBypr(p);}
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Facture> findAllFacture(){return dao.findAllFacture();}
}
