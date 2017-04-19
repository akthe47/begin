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

import com.mind.ak47.begin.model.ClientP;

/**
 *
 * @author ak47@minduos
 */
@Repository("clientPDao")
public class ClientPDaoImpl extends AbstractDao<Integer, ClientP> implements ClientPDao {

static final Logger logger = LoggerFactory.getLogger(ClientPDaoImpl.class);
    
    public ClientP findById(int id) {
		ClientP client = getByKey(id);
                Hibernate.initialize(client.getCodeville());
		return client;
	}
    public void save(ClientP client) {
		persist(client);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		ClientP client = (ClientP)crit.uniqueResult();
		delete(client);
	}
    public List<ClientP> findAllClient() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<ClientP> clients = (List<ClientP>) criteria.list();
                for(ClientP client : clients){
			Hibernate.initialize(client.getCodeville());
		}
		
		return clients;
		
	}

    
    
}
