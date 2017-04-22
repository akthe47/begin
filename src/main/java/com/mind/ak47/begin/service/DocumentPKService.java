/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import java.util.List;
import com.mind.ak47.begin.model.DocumentPK;
/**
 *
 * @author ak47@minduos
 */
public interface DocumentPKService {
    
    DocumentPK findById(int id);
	
	void save(DocumentPK documentPK);
	
	void deleteById(int id);
	
	List<DocumentPK> findAllDocumentPK();
}
