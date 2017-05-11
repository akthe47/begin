/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Facture;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface FactureService {
    Facture findById(int id);
	
	void save(Facture facture);
         public List<Facture> findBypr(int p);
	public void update(Facture client);
	void deleteById(int id);
	public void updatepath(Facture client);
	List<Facture> findAllFacture();

}
