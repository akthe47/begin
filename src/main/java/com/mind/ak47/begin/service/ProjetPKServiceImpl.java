/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.ProjetPKDao;
import com.mind.ak47.begin.model.ProjetPK;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
@Service("ProjetPKService")
@Transactional
public class ProjetPKServiceImpl implements ProjetPKService{
    @Autowired
    ProjetPKDao dao;
    public ProjetPK findById(int id){return dao.findById(id);}
	
	public void save(ProjetPK projetPK){dao.save(projetPK);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<ProjetPK> findAllProjetPK(){return dao.findAllProjetPK();}
    
}
