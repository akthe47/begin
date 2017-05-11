/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;

import com.mind.ak47.begin.model.ClientP;
import com.mind.ak47.begin.model.ClientPublic;
import com.mind.ak47.begin.service.ClientPublicService;
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
public class CodeClientToClientPu implements Converter <Object, ClientPublic>{
    static final Logger logger = LoggerFactory.getLogger(CodeClientToClientPu.class);
    
        @Autowired
        ClientPublicService cs;
        public ClientPublic convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		ClientPublic ville= cs.findById(id);
		logger.info("Profile : {}",ville);
		return ville;
	}
}
