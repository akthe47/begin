/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Paiement;
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
@Repository("PaiementDao")
public class PaiementDaoImpl extends AbstractDao<Integer, Paiement> implements PaiementDao{
    static final Logger logger = LoggerFactory.getLogger(PaiementDaoImpl.class);
    public Paiement findById(int id) {
		Paiement paiement = getByKey(id);
                if(paiement!=null){
			Hibernate.initialize(paiement.getMode());
                        Hibernate.initialize(paiement.getCodemem());
                        Hibernate.initialize(paiement.getCodefact());
		}
		
		return paiement;
	}
    public void save(Paiement paiement) {
		persist(paiement);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Paiement paiement = (Paiement)crit.uniqueResult();
		delete(paiement);
	}
    public List<Paiement> findByfacture(int p){
                logger.info("facture : {}", p);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codefact.code", p));
		List<Paiement> docs = (List<Paiement>) crit.list();
		 for(Paiement doc : docs){
			Hibernate.initialize(doc.getMode());
                        //Hibernate.initialize(doc.getCodemem());
                        Hibernate.initialize(doc.getCodefact());
		}
		return docs;
        
        }
    public List<Paiement> findBymemoire(int p){
                logger.info("facture : {}", p);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codemem.code", p));
		List<Paiement> docs = (List<Paiement>) crit.list();
		 for(Paiement doc : docs){
			Hibernate.initialize(doc.getMode());
                        Hibernate.initialize(doc.getCodemem());
		}
		return docs;
        
        }
    public List<Paiement> findAllPaiement() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Paiement> paiements = (List<Paiement>) criteria.list();
		
		for(Paiement doc : paiements){
			Hibernate.initialize(doc.getMode());
                        Hibernate.initialize(doc.getCodefact());
                        Hibernate.initialize(doc.getCodemem());
		}
		return paiements;
	}
    
}
