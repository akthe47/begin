/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Paiement;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface PaiementService {
    Paiement findById(int id);
	
	void save(Paiement paiement);
	 public List<Paiement> findBymemoire(int p);
         public List<Paiement> findByfacture(int p);
	void deleteById(int id);
	public void update(Paiement client);
	List<Paiement> findAllPaiement();
        public void updatepath(Paiement client);
    
}
