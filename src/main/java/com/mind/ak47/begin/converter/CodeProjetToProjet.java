/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;

//import com.mind.ak47.begin.model.Client;
//import com.mind.ak47.begin.service.ClientService;
import com.mind.ak47.begin.model.ClientP;
import com.mind.ak47.begin.model.Projet;
import com.mind.ak47.begin.service.ProjetService;
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
public class CodeProjetToProjet implements Converter <Object, Projet>{
            static final Logger logger = LoggerFactory.getLogger(CodeProjetToProjet.class);
        @Autowired
        ProjetService cs;
        public Projet convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Projet ville= cs.findById(id);
		logger.info("Projet : {}",ville);
		return ville;
	}
    
}
