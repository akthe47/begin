/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;

import com.mind.ak47.begin.model.ClientPublic;
import com.mind.ak47.begin.model.ClientSociete;

import com.mind.ak47.begin.service.ClientSocieteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author ak47@minduos
 */
@Component
public class CodeClientToClientSociete implements Converter <Object, ClientSociete>{
    static final Logger logger = LoggerFactory.getLogger(CodeClientToClientSociete.class);
    
        @Autowired
        ClientSocieteService cs;
        public ClientSociete convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		ClientSociete ville= cs.findById(id);
		logger.info("Profile : {}",ville);
		return ville;
	}
}
