/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import com.mind.ak47.begin.model.Memoire;
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
@Repository("MemoireDao")
public class MemoireDaoImpl extends AbstractDao<Integer, Memoire> implements MemoireDao{
    //static final Logger logger = LoggerFactory.getLogger(ProjetpriveDaoImpl.class);
    public Memoire findById(int id) {
        
		Memoire memoire = getByKey(id);
                /*if(memoire!=null){
			Hibernate.initialize(memoire.getCodeville());
		}*/
		
		return memoire;
	}
    public void save(Memoire memoire) {
		persist(memoire);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Memoire memoire = (Memoire)crit.uniqueResult();
		delete(memoire);
	}
    static final Logger logger = LoggerFactory.getLogger(MemoireDaoImpl.class);
    public List<Memoire> findBypr(int p){
                logger.info("codeprojet : {}", p);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codeprojet.code", p));
		List<Memoire> docs = (List<Memoire>)crit.list();
		 /*for(Memoire doc : docs){
			Hibernate.initialize(doc.getType());
		}*/
		return docs;
        
        }
    public List<Memoire> findAllMemoire() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Memoire> memoires = (List<Memoire>) criteria.list();
		
		
		/*for(Memoire memoire : memoires){
			Hibernate.initialize(memoire.getCodeville());
		}*/
		return memoires;
	}
}
