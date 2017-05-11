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

import com.mind.ak47.begin.dao.MemoireDao;
import com.mind.ak47.begin.model.Memoire;
import java.util.List;


 
@Service("MemoireService")
@Transactional
public class MemoireServiceImpl implements MemoireService{
    @Autowired
    MemoireDao dao;
    
    public Memoire findById(int id){return dao.findById(id);}
	
	public void save(Memoire memoire){dao.save(memoire);}
        public List<Memoire> findBypr(int p){return dao.findBypr(p);}
	public void update(Memoire client) {
		Memoire entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setDatedesignation(client.getDatedesignation());
			
			entity.setMthtva(client.getMthtva());
                        entity.setMttva(client.getMtttc()-client.getMthtva());
                        entity.setPtva(client.getPtva());
                        entity.setMtttc(client.getMtttc());
                        entity.setObservation(client.getObservation());
		}
	}
        public void updatepath(Memoire client) {
		Memoire entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setLiendoc(client.getLiendoc());
			
                        
		}
	}
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Memoire> findAllMemoire(){return dao.findAllMemoire();}
}
