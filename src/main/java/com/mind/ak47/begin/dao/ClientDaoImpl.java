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

import com.mind.ak47.begin.model.Client;

/**
 *
 * @author ak47@minduos
 */
@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao{
     
    static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);
    
    public Client findById(int id) {
		Client client = getByKey(id);
                /*if(client!=null){
			Hibernate.initialize(client.getCodeville());
		}*/
		
		return client;
	}
    public void save(Client client) {
		persist(client);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Client client = (Client)crit.uniqueResult();
		delete(client);
	}
    public List<Client> findAllClient() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Client> clients = (List<Client>) criteria.list();
		
		
		for(Client client : clients){
			Hibernate.initialize(client.getCodeville());
		}
		return clients;
	}
    
    
    
}
