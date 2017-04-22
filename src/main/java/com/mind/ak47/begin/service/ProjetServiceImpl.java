/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.ProjetDao;
import com.mind.ak47.begin.model.Projet;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
@Service("ProjetService")
@Transactional
public class ProjetServiceImpl implements ProjetService{
    @Autowired
    ProjetDao dao;
    public Projet findById(int id){return dao.findById(id);}
	
	public void save(Projet projet){dao.save(projet);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Projet> findAllProjet(){return dao.findAllProjet();}
    
}
