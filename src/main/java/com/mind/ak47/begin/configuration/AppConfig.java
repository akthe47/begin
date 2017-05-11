/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mind.ak47.begin.configuration;

/**
 *
 * @author ak47@minduos
 */


import com.mind.ak47.begin.converter.CodeClientToClient;
import com.mind.ak47.begin.converter.CodeClientToClientP;
import com.mind.ak47.begin.converter.CodeClientToClientPu;
import com.mind.ak47.begin.converter.CodeClientToClientSociete;
import com.mind.ak47.begin.converter.CodeProjetToProjet;
import com.mind.ak47.begin.converter.CodeProjetToProjetPrive;
import com.mind.ak47.begin.converter.CodeProjetToProjetPublic;
import com.mind.ak47.begin.converter.CodeTypedocToTypedoc;
import com.mind.ak47.begin.converter.CodeVilleToVille;
import com.mind.ak47.begin.converter.CodefactTofact;
import com.mind.ak47.begin.converter.CodemTomem;
import com.mind.ak47.begin.converter.ModeToModePaiement;
import com.mind.ak47.begin.converter.RoleToUserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mind.ak47.begin.converter.RoleToUserProfileConverter;
import java.io.IOException;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mind.ak47.begin")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	
	@Autowired
	RoleToUserProfileConverter roleToUserProfileConverter;
	@Autowired
	       CodeVilleToVille codevtov;
        @Autowired
        CodeClientToClientP codecltoclp;
        @Autowired
        CodeClientToClientSociete codecltocls;
        @Autowired
        CodeClientToClientPu codecltoclpu;
        @Autowired
        CodeClientToClient codecltocl;
        @Autowired
        CodeProjetToProjet codeprtopr;
        @Autowired
        CodeTypedocToTypedoc codettot;
        @Autowired
        CodeProjetToProjetPublic codeptopu;
        @Autowired
        CodeProjetToProjetPrive codeptopr;
        @Autowired
        ModeToModePaiement modetomodep;
        @Autowired
        CodemTomem cmemtomem;
        @Autowired
        CodefactTofact cftof;
        
	/**
     * Configure ViewResolvers to deliver preferred views.
     */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	/**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }
    
    /**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
        registry.addConverter(codevtov);
        registry.addConverter(codettot);
        registry.addConverter(modetomodep);
        
        
        //registry.addConverter(codecltoclp);
        //registry.addConverter(codecltocls);
        //registry.addConverter(codecltoclpu);
        
        
        registry.addConverter(codecltocl);
        registry.addConverter(codeprtopr);
        
        /*documet*/
        
        
        /*si j'élimne ca les factures les bons de commandes et les contrats ne fonctionnent pas et si je les laisse les projets public et privé ne fonctionnent pas*/
        /*registry.addConverter(codeptopu);    
        registry.addConverter(codeptopr);*/
        /*memcontfactbc*/
        
        /* si j'elimine ca les paiements ne fonctionnent pas et je les laisse les factures et les memoires ne fonctionnent pas*/
        registry.addConverter(cmemtomem);
        registry.addConverter(cftof);
        
    }
    /*public void addFormatters1(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
        registry.addConverter(codevtov);
        registry.addConverter(codettot);
        registry.addConverter(modetomodep);
        
        
        //registry.addConverter(codecltoclp);
        //registry.addConverter(codecltocls);
        //registry.addConverter(codecltoclpu);
        
        
        registry.addConverter(codecltocl);
        registry.addConverter(codeprtopr);
        
        //documet
        
        
        //si j'élimne ca les factures les bons de commandes et les contrats ne fonctionnent pas et si je les laisse les projets public et privé ne fonctionnent pas
        registry.addConverter(codeptopu);    
        registry.addConverter(codeptopr);
        //memcontfactbc
        
        // si j'elimine ca les paiements ne fonctionnent pas et je les laisse les factures et les memoires ne fonctionnent pas
        registry.addConverter(cmemtomem);
        registry.addConverter(cftof);
        
    }*/
	

    /**
     * Configure MessageSource to lookup any validation/error message in internationalized property files
     */
    @Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
    
    @Bean(name="multipartResolver") 
    public CommonsMultipartResolver getResolver() throws IOException{
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
         
        //Set the maximum allowed size (in bytes) for each individual file.
        resolver.setMaxUploadSizePerFile(5242880);//5MB
         
        //You may also set other available properties.
         
        return resolver;
    
    }
    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
     * This is a workaround for this issue.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}

