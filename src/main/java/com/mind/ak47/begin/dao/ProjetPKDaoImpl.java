/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.ProjetPK;
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

@Repository("projetPKDao")
public class ProjetPKDaoImpl extends AbstractDao<Integer, ProjetPK> implements ProjetPKDao{
    
    static final Logger logger = LoggerFactory.getLogger(ProjetPKDaoImpl.class);
    public ProjetPK findById(int id) {
		ProjetPK projetPK = getByKey(id);
                /*if(projetPK!=null){
			Hibernate.initialize(projetPK.getCodeville());
		}*/
		
		return projetPK;
	}
    public void save(ProjetPK projetPK) {
		persist(projetPK);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		ProjetPK projetPK = (ProjetPK)crit.uniqueResult();
		delete(projetPK);
	}
    public List<ProjetPK> findAllProjetPK() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<ProjetPK> projetPKs = (List<ProjetPK>) criteria.list();
		
		/*
		for(ProjetPK projetPK : projetPKs){
			Hibernate.initialize(projetPK.getCodeville());
		}*/
		return projetPKs;
	}
    
}
