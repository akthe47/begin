/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Contrat;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ak47@minduos
 */
@Repository("ContratDao")
public class ContratDaoImpl extends AbstractDao<Integer, Contrat> implements ContratDao{
    public Contrat findById(int id) {
		Contrat contrat = getByKey(id);
                /*if(contrat!=null){
			Hibernate.initialize(contrat.getCodeville());
		}*/
		
		return contrat;
	}
    public void save(Contrat contrat) {
		persist(contrat);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Contrat contrat = (Contrat)crit.uniqueResult();
		delete(contrat);
	}
    static final Logger logger = LoggerFactory.getLogger(ContratDaoImpl.class);
    public List<Contrat> findBypr(int p){
                logger.info("codeprojet : {}", p);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codeprojet.code", p));
		List<Contrat> docs = (List<Contrat>)crit.list();
		 /*for(Document doc : docs){
			Hibernate.initialize(doc.getType());
		}*/
		return docs;
        
        }
    public List<Contrat> findAllContrat() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Contrat> contrats = (List<Contrat>) criteria.list();
		
		
		/*for(Contrat contrat : contrats){
			Hibernate.initialize(contrat.getCodeville());
		}*/
		return contrats;
	}
}
