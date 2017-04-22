/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mind.ak47.begin.dao.TelDao;
import com.mind.ak47.begin.model.Tel;
import java.util.List;
/**
 *
 * @author ak47@minduos
 */
@Service("TelService")
@Transactional
public class TelServiceImpl implements TelService{
    @Autowired
    TelDao dao;
    public Tel findById(int id){return dao.findById(id);}
	
	public void save(Tel tel){dao.save(tel);}
	
	public void deleteById(int id){dao.deleteById(id);}
	
	public List<Tel> findAllTel(){return dao.findAllTel();}
    
}
