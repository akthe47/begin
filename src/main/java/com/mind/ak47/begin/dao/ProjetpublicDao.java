/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import com.mind.ak47.begin.model.Client;
import com.mind.ak47.begin.model.Projetpublic;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
public interface ProjetpublicDao {
     Projetpublic findById(int id);
	
	void save(Projetpublic projetpublic);
	public List<Projetpublic> findBypr(int p);
	void deleteById(int id);
	
	List<Projetpublic> findAllProjetpublic();
    
}
