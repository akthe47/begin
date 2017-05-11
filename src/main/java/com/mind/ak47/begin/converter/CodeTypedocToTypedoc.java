/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;

import com.mind.ak47.begin.model.Projet;
import com.mind.ak47.begin.model.Typedoc;
import com.mind.ak47.begin.service.ProjetService;
import com.mind.ak47.begin.service.TypedocService;
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
public class CodeTypedocToTypedoc implements Converter <Object, Typedoc>{
      static final Logger logger = LoggerFactory.getLogger(CodeTypedocToTypedoc.class);
        @Autowired
        TypedocService cs;
        public Typedoc convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Typedoc ville= cs.findById(id);
		logger.info("Typedoc : {}",ville);
		return ville;
	}
}
