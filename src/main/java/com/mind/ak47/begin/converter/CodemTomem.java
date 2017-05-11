/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;

import com.mind.ak47.begin.model.Memoire;
import com.mind.ak47.begin.model.Ville;
import com.mind.ak47.begin.service.MemoireService;
import com.mind.ak47.begin.service.VilleService;
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
public class CodemTomem implements Converter<Object, Memoire>{
    static final Logger logger = LoggerFactory.getLogger(CodemTomem.class);
	
	@Autowired
	MemoireService villeService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Memoire convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Memoire ville= villeService.findById(id);
		logger.info("Profile : {}",ville);
		return ville;
	}
}
