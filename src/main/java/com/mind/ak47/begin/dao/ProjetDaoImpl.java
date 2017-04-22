/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Projet;
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


@Repository("projetDao")
public class ProjetDaoImpl extends AbstractDao<Integer, Projet> implements ProjetDao{
    
    static final Logger logger = LoggerFactory.getLogger(ProjetDaoImpl.class);
    public Projet findById(int id) {
		Projet projet = getByKey(id);
                /*if(projet!=null){
			Hibernate.initialize(projet.getCodeville());
		}*/
		
		return projet;
	}
    public void save(Projet projet) {
		persist(projet);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Projet projet = (Projet)crit.uniqueResult();
		delete(projet);
	}
    public List<Projet> findAllProjet() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Projet> projets = (List<Projet>) criteria.list();
		
		/*
		for(Projet projet : projets){
			Hibernate.initialize(projet.getCodeville());
		}*/
		return projets;
	}
}
