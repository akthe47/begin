/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import com.mind.ak47.begin.model.Modepaiement;
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
@Repository("ModepaiementDao")
public class ModepaiementDaoImpl extends AbstractDao<Integer, Modepaiement> implements ModepaiementDao{
    
    public Modepaiement findById(int id) {
		Modepaiement mode = getByKey(id);
                /*if(mode!=null){
			Hibernate.initialize(mode.getCodeville());
		}*/
		
		return mode;
	}
    public void save(Modepaiement mode) {
		persist(mode);
	}
    public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", id));
		Modepaiement mode = (Modepaiement)crit.uniqueResult();
		delete(mode);
	}
    public List<Modepaiement> findAllModepaiement() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Modepaiement> modes = (List<Modepaiement>) criteria.list();
		
		
		/*for(Modepaiement mode : modes){
			Hibernate.initialize(mode.getCodeville());
		}*/
		return modes;
	}
    
}
