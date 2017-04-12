/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.ClientSociete;
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
@Repository("clientSocieteDao")
public class ClientSocieteDaoImpl extends AbstractDao<Integer, ClientSociete> implements ClientSocieteDao{
    
    static final Logger logger = LoggerFactory.getLogger(ClientSocieteDaoImpl.class);
    
    public ClientSociete findById(int id) {
		ClientSociete client = getByKey(id);
                if(client!=null){
			Hibernate.initialize(client.getClient());
		}
		
		return client;
	}
    public void save(ClientSociete client) {
		persist(client);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		ClientSociete client = (ClientSociete)crit.uniqueResult();
		delete(client);
	}
    public List<ClientSociete> findAllClient() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<ClientSociete> clients = (List<ClientSociete>) criteria.list();
		
		
		for(ClientSociete client : clients){
			Hibernate.initialize(client.getClient());
		}
		return clients;
	}
    
}
