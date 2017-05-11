/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.PaiementDao;
import com.mind.ak47.begin.model.Contrat;
import com.mind.ak47.begin.model.Paiement;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */

@Service("PaiementService")
@Transactional
public class PaiementServiceImpl implements PaiementService{
    @Autowired
PaiementDao dao;


public Paiement findById(int id){return dao.findById(id);}
	
	public void save(Paiement paiement){dao.save(paiement);}
	 public List<Paiement> findBymemoire(int p){return dao.findBymemoire(p);}
         public List<Paiement> findByfacture(int p){return dao.findByfacture(p);}
	public void deleteById(int id){dao.deleteById(id);}
	public void update(Paiement client) {
		Paiement entity = dao.findById(client.getNumpaiement());
		if(entity!=null){
                    entity.setCodefact(client.getCodefact());
                    entity.setCodemem(client.getCodemem());
			entity.setDatereception(client.getDatereception());
                        entity.setMode(client.getMode());
                        entity.setObservation(client.getObservation());
		}}
        public void updatepath(Paiement client) {
		Paiement entity = dao.findById(client.getNumpaiement());
		if(entity!=null){
			entity.setLiendoc(client.getLiendoc());
			
                        
		}
	}
	public List<Paiement> findAllPaiement(){return dao.findAllPaiement();}
}
