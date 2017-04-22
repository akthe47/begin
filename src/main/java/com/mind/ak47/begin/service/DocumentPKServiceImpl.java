/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.DocumentPKDao;
import com.mind.ak47.begin.model.DocumentPK;
import java.util.List;

/**
 *
 * @author ak47@minduos
 */
@Service("DocumentPKService")
@Transactional
public class DocumentPKServiceImpl implements DocumentPKService{
    @Autowired
    DocumentPKDao dao;
    
    public DocumentPK findById(int id){return dao.findById(id);}
	
	public void save(DocumentPK documentPK){dao.save(documentPK);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<DocumentPK> findAllDocumentPK(){return dao.findAllDocumentPK();}
}
