/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import java.util.List;
import com.mind.ak47.begin.model.Document;
/**
 *
 * @author ak47@minduos
 */
public interface DocumentService {
    Document findById(int id);
	
	void save(Document document);
	
	void deleteById(int id);
	
	List<Document> findAllDocument();
    
}
