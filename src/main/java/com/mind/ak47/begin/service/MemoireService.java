/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Memoire;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface MemoireService {
    Memoire findById(int id);
	
	void save(Memoire memoire);
	public List<Memoire> findBypr(int p);
	void deleteById(int id);
        public void update(Memoire client);
	public void updatepath(Memoire client);
	List<Memoire> findAllMemoire();

    
}
