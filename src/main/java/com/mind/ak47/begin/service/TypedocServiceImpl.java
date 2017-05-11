/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.TypedocDao;
import com.mind.ak47.begin.model.Typedoc;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
@Service("TypedocService")
@Transactional
public class TypedocServiceImpl implements TypedocService{
        @Autowired
	TypedocDao dao;
        
        public Typedoc findById(int id){return dao.findById(id);}
	
	public void save(Typedoc client){dao.save(client);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Typedoc> findAll(){return dao.findAll();}
    
}
