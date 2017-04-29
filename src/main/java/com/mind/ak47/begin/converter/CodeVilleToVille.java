/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.converter;
import com.mind.ak47.begin.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mind.ak47.begin.model.UserProfile;
import com.mind.ak47.begin.model.Ville;
import com.mind.ak47.begin.service.UserProfileService;
import com.mind.ak47.begin.service.VilleService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component

public class CodeVilleToVille implements Converter<Object, Ville>{
    static final Logger logger = LoggerFactory.getLogger(CodeVilleToVille.class);
	
	@Autowired
	VilleService villeService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Ville convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Ville ville= villeService.findById(id);
		logger.info("Profile : {}",ville);
		return ville;
	}
}
