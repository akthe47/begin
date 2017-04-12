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

import com.mind.ak47.begin.dao.VilleDao;
import com.mind.ak47.begin.model.Ville;
/**
 *
 * @author ak47@minduos
 */
public class VilleServiceImpl implements VilleService{
        @Autowired
	VilleDao dao;
        
        public Ville findById(int id){return dao.findById(id);}
	
	public void save(Ville ville){dao.save(ville);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Ville> findAllVille(){return dao.findAllVille();}
    
}
