/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Client;
import java.util.List;
import com.mind.ak47.begin.model.Projetpublic;

/**
 *
 * @author ak47@minduos
 */
public interface ProjetpublicService {
    Projetpublic findById(int id);
	
	void save(Projetpublic projetpublic);
	public List<Projetpublic> findBypr(int p);
	void deleteById(int id);
        public void update(Projetpublic client);
	
	List<Projetpublic> findAllProjetpublic();
    
}
