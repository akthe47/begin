/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import com.mind.ak47.begin.model.Projetpublic;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
public interface ProjetpublicDao {
     Projetpublic findById(int id,short ida);
	
	void save(Projetpublic projetpublic);
	
	void deleteById(int id);
	
	List<Projetpublic> findAllProjetpublic();
    
}
