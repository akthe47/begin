/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;

import com.mind.ak47.begin.model.Facture;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface FactureDao {
     Facture findById(int id);
	
	void save(Facture facture);
	
	void deleteById(int id);
	public List<Facture> findBypr(int p);
	List<Facture> findAllFacture();
    
}
