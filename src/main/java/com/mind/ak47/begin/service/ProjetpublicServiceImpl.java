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
import com.mind.ak47.begin.model.Client;
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
    public Projetpublic findById(int id){return dao.findById(id);}
	
	public void save(Projetpublic projetpublic){dao.save(projetpublic);}
	public List<Projetpublic> findBypr(int p){return dao.findBypr(p);}
	public void deleteById(int id){dao.deleteById(id);}
        public void update(Projetpublic client) {
		Projetpublic entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setAdresse(client.getAdresse());
			entity.setDescription(client.getDescription());
			entity.setDatedebut(client.getDatedebut());
                        entity.setDatefin(client.getDatefin());
                        entity.setPersonneacontacter(client.getPersonneacontacter());
                        entity.setNumtel(client.getNumtel());
                        entity.setMaitreouvrage(client.getMaitreouvrage());
                        entity.setMontanttravaux(client.getMontanttravaux());
                        //entity.setCodeclient(client.getCodeclient());
		}
	}
	
	public List<Projetpublic> findAllProjetpublic(){return dao.findAllProjetpublic();}
    
}
