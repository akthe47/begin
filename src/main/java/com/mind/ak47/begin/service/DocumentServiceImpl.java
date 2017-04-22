/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.DocumentDao;
import com.mind.ak47.begin.model.Document;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
@Service("DocumentService")
@Transactional
public class DocumentServiceImpl implements DocumentService{
    @Autowired
    DocumentDao dao;
    public Document findById(int id){return dao.findById(id);}
	
	public void save(Document document){dao.save(document);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Document> findAllDocument(){return dao.findAllDocument();}
    
}
