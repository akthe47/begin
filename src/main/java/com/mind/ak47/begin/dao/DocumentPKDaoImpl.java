/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.DocumentPK;
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
@Repository("documentPKDao")
public class DocumentPKDaoImpl extends AbstractDao<Integer, DocumentPK> implements DocumentPKDao{
    
    static final Logger logger = LoggerFactory.getLogger(DocumentPKDaoImpl.class);
    public DocumentPK findById(int id) {
		DocumentPK document = getByKey(id);
                /*if(document!=null){
			Hibernate.initialize(document.getCodeville());
		}*/
		
		return document;
	}
    public void save(DocumentPK document) {
		persist(document);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		DocumentPK document = (DocumentPK)crit.uniqueResult();
		delete(document);
	}
    public List<DocumentPK> findAllDocumentPK() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<DocumentPK> documents = (List<DocumentPK>) criteria.list();
		
		
		/*for(DocumentPK document : documents){
			Hibernate.initialize(document.getCodeville());
		}*/
		return documents;
	}
    
}
