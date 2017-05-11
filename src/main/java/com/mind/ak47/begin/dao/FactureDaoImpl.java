/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Facture;
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
@Repository("FactureDao")
public class FactureDaoImpl extends AbstractDao<Integer, Facture> implements FactureDao{
    public Facture findById(int id) {
		Facture facture = getByKey(id);
                /*if(facture!=null){
			Hibernate.initialize(facture.getCodeville());
		}*/
		
		return facture;
	}
    public void save(Facture facture) {
		persist(facture);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Facture facture = (Facture)crit.uniqueResult();
		delete(facture);
	}
    static final Logger logger = LoggerFactory.getLogger(FactureDaoImpl.class);
    public List<Facture> findBypr(int p){
                logger.info("codeprojet : {}", p);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codeprojet.code", p));
		List<Facture> docs = (List<Facture>)crit.list();
		 /*for(Facture doc : docs){
			Hibernate.initialize(doc.getType());
		}*/
		return docs;
        
        }
    public List<Facture> findAllFacture() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Facture> factures = (List<Facture>) criteria.list();
		
		
		/*for(Facture facture : factures){
			Hibernate.initialize(facture.getCodeville());
		}*/
		return factures;
	}
    
}
