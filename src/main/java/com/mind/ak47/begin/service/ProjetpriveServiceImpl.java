/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.ProjetpriveDao;
import com.mind.ak47.begin.model.Projetprive;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
@Service("ProjetpriveService")
@Transactional
public class ProjetpriveServiceImpl implements ProjetpriveService{
    @Autowired
    ProjetpriveDao dao;
    public Projetprive findById(int id){return dao.findById(id);}
	
	public void save(Projetprive projetprive){dao.save(projetprive);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Projetprive> findAllProjetprive(){return dao.findAllProjetprive();}
    
}
