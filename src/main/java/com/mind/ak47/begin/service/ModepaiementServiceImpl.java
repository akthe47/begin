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

import com.mind.ak47.begin.dao.ModepaiementDao;
import com.mind.ak47.begin.model.Modepaiement;
import java.util.List;


 
@Service("ModepaiementService")
@Transactional
public class ModepaiementServiceImpl implements ModepaiementService{
    @Autowired
    ModepaiementDao dao;


public Modepaiement findById(int id){return dao.findById(id);}
	
	public void save(Modepaiement mode){dao.save(mode);}
	
	public void deleteById(int id){dao.deleteById(id);}
	public void update(Modepaiement client) {
		Modepaiement entity = dao.findById(client.getCode());
		if(entity!=null){
			
		}}
	public List<Modepaiement> findAllModepaiement(){return dao.findAllModepaiement();}
}
