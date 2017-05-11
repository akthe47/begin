/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Boncommande;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */

public interface BoncommandeService {
    Boncommande findById(int id);
	
	void save(Boncommande bon);
        public List<Boncommande> findBypr(int p);
	public void update(Boncommande client);
	void deleteById(int id);
	public void updatepath(Boncommande client);
	List<Boncommande> findAllBoncommande();

}
