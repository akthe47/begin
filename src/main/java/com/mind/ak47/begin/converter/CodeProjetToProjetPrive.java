/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;

import com.mind.ak47.begin.model.Projetprive;
//import com.mind.ak47.begin.model.Projetpublic;
import com.mind.ak47.begin.service.ProjetpriveService;
//import com.mind.ak47.begin.service.ProjetpublicService;
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
public class CodeProjetToProjetPrive implements Converter <Object, Projetprive>{
     static final Logger logger = LoggerFactory.getLogger(CodeProjetToProjetPrive.class);
        @Autowired
        ProjetpriveService cs;
        public Projetprive convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Projetprive ville= cs.findById(id);
		logger.info("Projet : {}",ville);
		return ville;
	}

}