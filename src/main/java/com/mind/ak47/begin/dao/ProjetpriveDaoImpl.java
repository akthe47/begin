/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Client;
import com.mind.ak47.begin.model.ClientP;
import com.mind.ak47.begin.model.ClientSociete;
import com.mind.ak47.begin.model.Projetprive;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ak47@minduos
 */
@Repository("projetpriveDao")
public class ProjetpriveDaoImpl extends AbstractDao<Integer, Projetprive> implements ProjetpriveDao{
    
    static final Logger logger = LoggerFactory.getLogger(ProjetpriveDaoImpl.class);
    public Projetprive findById(int id) {
                
		Projetprive projetprive = getByKey(id);
                if(projetprive!=null){
                    Client c=projetprive.getCodeclient();
                    if (c instanceof ClientP) {
                        ClientP ci=(ClientP)c;
			Hibernate.initialize(ci);}else
                    {
                    ClientSociete ci=(ClientSociete)c;
			Hibernate.initialize(ci);
                    }
		}
		
		return projetprive;
	}
    public void save(Projetprive projetprive) {
		persist(projetprive);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Projetprive projetprive = (Projetprive)crit.uniqueResult();
		delete(projetprive);
	}
    //static final Logger logger = LoggerFactory.getLogger(MemoireDaoImpl.class);
    public List<Projetprive> findBypr(int p){
                logger.info("codeprojet : {}", p);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codeclient.code", p));
		List<Projetprive> docs = (List<Projetprive>)crit.list();
		 /*for(Memoire doc : docs){
			Hibernate.initialize(doc.getType());
		}*/
		return docs;
        
        }
    public List<Projetprive> findAllProjetprive() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Projetprive> projetprives = (List<Projetprive>) criteria.list();
		
		
		for(Projetprive projetprive : projetprives){
			if(projetprive!=null){
                    Client c=projetprive.getCodeclient();
                    if (c instanceof ClientP) {
                        ClientP ci=(ClientP)c;
			Hibernate.initialize(ci);}else
                    {
                    ClientSociete ci=(ClientSociete)c;
			Hibernate.initialize(ci);
                    }
		}
		}
		return projetprives;
	}
    
}
