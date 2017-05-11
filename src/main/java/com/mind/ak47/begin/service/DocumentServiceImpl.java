/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import com.mind.ak47.begin.dao.DocumentDao;
import com.mind.ak47.begin.model.Document;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Document> findBypr(int p) {return dao.findBypr( p);}
	
	public void save(Document document){dao.save(document);}
        
        public void update(Document client) {
		Document entity = dao.findById(client.getCode());
		if(entity!=null){
			entity.setDescription(client.getDescription());
                        entity.setExt(client.getExt());
                        entity.setType(client.getType());
                        
		}
	}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Document> findAll(){return dao.findAll();}
    
}
