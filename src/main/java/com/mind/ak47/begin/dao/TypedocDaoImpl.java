/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Typedoc;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ak47@minduos
 */
@Repository("TypedocDao")
public class TypedocDaoImpl extends AbstractDao<Integer, Typedoc> implements TypedocDao{
    public Typedoc findById(int id) {
		Typedoc typedoc = getByKey(id);
                /*if(typedoc!=null){
			Hibernate.initialize(typedoc.getCodeville());
		}*/
		
		return typedoc;
	}
    public void save(Typedoc typedoc) {
		persist(typedoc);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Typedoc typedoc = (Typedoc)crit.uniqueResult();
		delete(typedoc);
	}
    public List<Typedoc> findAll() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Typedoc> typedocs = (List<Typedoc>) criteria.list();
		
		
		/*for(Typedoc typedoc : typedocs){
			Hibernate.initialize(typedoc.getCodeville());
		}*/
		return typedocs;
	}
    
}
