/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mind.ak47.begin.model.Ville;

/**
 *
 * @author ak47@minduos
 */
@Repository("villeDao")
public class VilleDaoImpl extends AbstractDao<Integer, Ville> implements VilleDao{
    
    static final Logger logger = LoggerFactory.getLogger(VilleDaoImpl.class);
    
    public Ville findById(int id) {
		Ville ville = getByKey(id);
		
		return ville;
	}
    public void save(Ville ville) {
		persist(ville);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Ville ville = (Ville)crit.uniqueResult();
		delete(ville);
	}
    public List<Ville> findAllVille() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Ville> villes = (List<Ville>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return villes;
	}
}
