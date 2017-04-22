/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Document;
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

@Repository("documentDao")
public class DocumentDaoImpl extends AbstractDao<Integer, Document> implements  DocumentDao{
    
    static final Logger logger = LoggerFactory.getLogger(DocumentDaoImpl.class);
    
    public Document findById(int id) {
		Document document = getByKey(id);
                /*if(documenta!=null){
			Hibernate.initialize(documenta.getCodeville());
		}*/
		
		return document;
	}
    public void save(Document document) {
		persist(document);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Document document = (Document)crit.uniqueResult();
		delete(document);
	}
    public List<Document> findAllDocument() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Document> documents = (List<Document>) criteria.list();
		
		
		/*for(Document documenta : documentas){
			Hibernate.initialize(documenta.getCodeville());
		}*/
		return documents;
	}
    
}
