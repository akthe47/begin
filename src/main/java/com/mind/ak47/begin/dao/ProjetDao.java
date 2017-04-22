/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import com.mind.ak47.begin.model.Projet;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
public interface ProjetDao {
     Projet findById(int id);
	
	void save(Projet projet);
	
	void deleteById(int id);
	
	List<Projet> findAllProjet();
    
}
