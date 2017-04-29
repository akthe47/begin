/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.ProjetpublicDao;
import com.mind.ak47.begin.model.Projetpublic;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
@Service("ProjetpublicService")
@Transactional
public class ProjetpublicServiceImpl implements ProjetpublicService{
    @Autowired
    ProjetpublicDao dao;
    public Projetpublic findById(short ida,int id){return dao.findById(id,ida);}
	
	public void save(Projetpublic projetpublic){dao.save(projetpublic);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Projetpublic> findAllProjetpublic(){return dao.findAllProjetpublic();}
    
}
