/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Boncommande;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface BonCommandeDao {
     Boncommande findById(int id);
	
	void save(Boncommande bon);
	
	void deleteById(int id);
	public List<Boncommande> findBypr(int p);
	List<Boncommande> findAllBoncommande();
    
}
