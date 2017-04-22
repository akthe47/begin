/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Projetpublic;
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
@Repository("projetpublicDao")
public class ProjetpublicDaoImpl extends AbstractDao<Integer, Projetpublic> implements ProjetpublicDao{
    
    
    static final Logger logger = LoggerFactory.getLogger(ProjetpublicDaoImpl.class);
    public Projetpublic findById(int id) {
		Projetpublic projetpublic = getByKey(id);
                /*if(projetpublic!=null){
			Hibernate.initialize(projetpublic.getCodeville());
		}*/
		
		return projetpublic;
	}
    public void save(Projetpublic projetpublic) {
		persist(projetpublic);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Projetpublic projetpublic = (Projetpublic)crit.uniqueResult();
		delete(projetpublic);
	}
    public List<Projetpublic> findAllProjetpublic() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Projetpublic> projetpublics = (List<Projetpublic>) criteria.list();
		
		
		/*for(Projetpublic projetpublic : projetpublics){
			Hibernate.initialize(projetpublic.getCodeville());
		}*/
		return projetpublics;
	}
    
}
