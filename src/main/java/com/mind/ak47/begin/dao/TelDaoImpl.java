/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Tel;
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
@Repository("telDao")
public class TelDaoImpl extends AbstractDao<Integer, Tel> implements TelDao{
    
    static final Logger logger = LoggerFactory.getLogger(TelDaoImpl.class);
    public Tel findById(int id) {
		Tel tel = getByKey(id);
                /*if(tel!=null){
			Hibernate.initialize(tel.getCodeville());
		}*/
		
		return tel;
	}
    public void save(Tel tel) {
		persist(tel);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Tel tel = (Tel)crit.uniqueResult();
		delete(tel);
	}
    public List<Tel> findAllTel() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Tel> tels = (List<Tel>) criteria.list();
		
		
		for(Tel tel : tels){
			Hibernate.initialize(tel.getCodeclient());
		}
		return tels;
	}
    
}
