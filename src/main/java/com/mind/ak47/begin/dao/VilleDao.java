/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.dao;
import java.util.List;

import com.mind.ak47.begin.model.Ville;

/**
 *
 * @author ak47@minduos
 */
public interface VilleDao {
        Ville findById(int id);
	
	
	
	void save(Ville ville);
	
	void deleteById(int id);
	
	List<Ville> findAllVille();
    
}
