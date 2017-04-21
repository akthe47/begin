/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.ClientPublic;
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
@Repository("clientPublicDao")
public class ClientPublicDaoImpl extends AbstractDao<Integer, ClientPublic> implements ClientPublicDao {
    static final Logger logger = LoggerFactory.getLogger(ClientPublicDaoImpl.class);
    
    public ClientPublic findById(int id) {
		ClientPublic client = getByKey(id);
                Hibernate.initialize(client.getCodeville());
		return client;
	}
    public void save(ClientPublic client) {
		persist(client);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		ClientPublic client = (ClientPublic)crit.uniqueResult();
		delete(client);
	}
    public List<ClientPublic> findAllClient() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<ClientPublic> clients = (List<ClientPublic>) criteria.list();
		
		
		for(ClientPublic client : clients){
			Hibernate.initialize(client.getCodeville());
		}
		return clients;
	}
    
}
