/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.model.Document;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
public interface DocumentService {
    
    Document findById(int id);
	
	List<Document> findBypr(int p);
	
	void save(Document document);
	
        public void update(Document client);
        
	void deleteById(int id);
	
	List<Document> findAll();
    
}
