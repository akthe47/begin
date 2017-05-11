/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Document;
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
@Repository("DocumentDao")
public class DocumentDaoImpl extends AbstractDao<Integer, Document> implements DocumentDao{
    
    static final Logger logger = LoggerFactory.getLogger(ProjetpriveDaoImpl.class);
    public List<Document> findBypr(int p){
                logger.info("codeprojet : {}", p);
		Criteria crit = createEntityCriteria().addOrder(Order.asc("code"));
		crit.add(Restrictions.eq("codeprojet.code", p));
		List<Document> docs = (List<Document>)crit.list();
		 for(Document doc : docs){
			Hibernate.initialize(doc.getType());
                         Hibernate.initialize(doc.getProjet());
		}
		return docs;
        
        }
       public Document findById(int id){
        Document doc= getByKey(id);
		if(doc!=null){
			Hibernate.initialize(doc.getType());
                        Hibernate.initialize(doc.getProjet());
		}
		return doc;}
	
	
	
	public void save(Document document){
        persist(document);
        }
	
	public void deleteById(int id){}
	
	public List<Document> findAll(){
        
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Document> docs = (List<Document>) criteria.list();
        for(Document doc : docs){
			Hibernate.initialize(doc.getType());
                         Hibernate.initialize(doc.getProjet());
		}
		return docs;
        }
    
}
