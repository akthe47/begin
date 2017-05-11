/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Modepaiement;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface ModepaiementService {
    
    
    Modepaiement findById(int id);
	
	void save(Modepaiement mode);
	
	void deleteById(int id);
	
	List<Modepaiement> findAllModepaiement();

    
}
