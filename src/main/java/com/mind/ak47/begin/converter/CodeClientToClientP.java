/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;

import com.mind.ak47.begin.model.Client;
import com.mind.ak47.begin.model.ClientP;
import com.mind.ak47.begin.service.ClientPService;
import com.mind.ak47.begin.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ak47@minduos
 */
@Component
public class CodeClientToClientP implements Converter <Object, ClientP>{
    static final Logger logger = LoggerFactory.getLogger(CodeClientToClientP.class);
    
        @Autowired
        ClientPService cs;
        public ClientP convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		ClientP ville= cs.findById(id);
		logger.info("Profile : {}",ville);
		return ville;
	}
}
