/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Contrat;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface ContratService {
    Contrat findById(int id);
	
	void save(Contrat contrat);
	
	void deleteById(int id);
        public void update(Contrat client);
        public void updatepath(Contrat client);
	public List<Contrat> findbyContrat(int p);
	List<Contrat> findAllContrat();

}
