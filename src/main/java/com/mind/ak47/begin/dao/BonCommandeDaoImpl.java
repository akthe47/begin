/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

//import com.mind.ak47.begin.configuration.HibernateConfiguration;
import com.mind.ak47.begin.model.Boncommande;
import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
import org.hibernate.Criteria;
//import org.hibernate.Hibernate;
//import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ak47@minduos
 */
@Repository("BonCommandeDao")
public class BonCommandeDaoImpl extends AbstractDao<Integer, Boncommande> implements BonCommandeDao{
    
    public Boncommande findById(int id) {
		Boncommande bon = getByKey(id);
                /*if(bon!=null){
			Hibernate.initialize(bon.getCodeville());
		}*/
		
		return bon;
	}
    public void save(Boncommande bon) {
		persist(bon);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Boncommande bon = (Boncommande)crit.uniqueResult();
		delete(bon);
                /*HibernateConfiguration hq;
                 HibernateTransactionManager tx=  hq.transactionManager();
                tx =getSession().beginTransaction();
                SQLQuery query=getSession().createSQLQuery("ALTER TABLE ZeeCallSp AUTO_INCREMENT = 1");
                query.executeUpdate();
                tx.commit();*/
                //session.close();
                //getSession().
                // entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
                //EntityManager entityManager = entityManagerFactory.createEntityManager();
	}
    static final Logger logger = LoggerFactory.getLogger(BonCommandeDaoImpl.class);
    public List<Boncommande> findBypr(int p){
                logger.info("codeprojet : {}", p);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codeprojet.code", p));
		List<Boncommande> docs = (List<Boncommande>)crit.list();
		 /*for(Document doc : docs){
			Hibernate.initialize(doc.getType());
		}*/
		return docs;
        
        }
    public List<Boncommande> findAllBoncommande() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Boncommande> bons = (List<Boncommande>) criteria.list();
		
		
		/*for(Boncommande bon : bons){
			Hibernate.initialize(bon.getCodeville());
		}*/
		return bons;
	}
    
}
