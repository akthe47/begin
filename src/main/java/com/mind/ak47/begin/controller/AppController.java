package com.mind.ak47.begin.controller;

import com.mind.ak47.begin.configuration.AppConfig;
import com.mind.ak47.begin.model.Boncommande;
import com.mind.ak47.begin.model.Client;
import com.mind.ak47.begin.model.ClientP;
import com.mind.ak47.begin.model.ClientPublic;
import com.mind.ak47.begin.model.ClientSociete;
import com.mind.ak47.begin.model.Contrat;
import com.mind.ak47.begin.model.Document;
import com.mind.ak47.begin.model.Facture;
import com.mind.ak47.begin.model.Projet;
import com.mind.ak47.begin.model.Projetprive;
import com.mind.ak47.begin.model.Projetpublic;
import com.mind.ak47.begin.model.Modepaiement;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mind.ak47.begin.model.User;
import com.mind.ak47.begin.model.Ville;
import com.mind.ak47.begin.model.UserProfile;
import com.mind.ak47.begin.service.ClientPService;
import com.mind.ak47.begin.service.ClientPublicService;
import com.mind.ak47.begin.service.ClientSocieteService;
import com.mind.ak47.begin.service.DocumentService;
import com.mind.ak47.begin.service.ProjetService;
import com.mind.ak47.begin.service.ProjetpriveService;
import com.mind.ak47.begin.service.ProjetpublicService;
//import com.mind.ak47.begin.service.ClientService;
import com.mind.ak47.begin.service.UserProfileService;
import com.mind.ak47.begin.service.UserService;
import com.mind.ak47.begin.service.VilleService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.ObjectError;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.validation.Valid;
 


import org.springframework.util.FileCopyUtils;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
 
import com.mind.ak47.begin.model.FileBucket;
import com.mind.ak47.begin.model.Memoire;
import com.mind.ak47.begin.model.Paiement;
import com.mind.ak47.begin.model.Typedoc;
import com.mind.ak47.begin.service.BoncommandeService;
import com.mind.ak47.begin.service.ClientService;
import com.mind.ak47.begin.service.ContratService;
import com.mind.ak47.begin.service.FactureService;
import com.mind.ak47.begin.service.MemoireService;
import com.mind.ak47.begin.service.ModepaiementService;
import com.mind.ak47.begin.service.PaiementService;
import com.mind.ak47.begin.service.TypedocService;
import com.mind.ak47.begin.util.FileValidator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.format.FormatterRegistry;




@Controller
@RequestMapping("/")
@SessionAttributes("roles")
//@Configuration
//@ComponentScan("com.bd.service")
public class AppController {
    
        

	@Autowired
	UserService userService;
        //@Autowired
	//ClientService clientService;
         @Autowired
	ClientPService clientPService;
        @Autowired
        BoncommandeService bcService;
        @Autowired
        ContratService cService;
        @Autowired
        FactureService fService;
        @Autowired
        MemoireService mService;
        @Autowired
        ModepaiementService mpService;
        @Autowired
        PaiementService pService;
        @Autowired
        TypedocService tdService;
         @Autowired
	ClientPublicService clientPubService;
         @Autowired
	ClientSocieteService clientSService;
	@Autowired
	ClientService clientService;
	@Autowired
	UserProfileService userProfileService;
	@Autowired
	ProjetpublicService ProjetpuService;
        @Autowired
        ProjetpriveService ProjetpriveService;
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
         @Autowired
	VilleService villeService;
	@Autowired
	DocumentService docService;
         @Autowired
	ProjetService prService;
         @Autowired
         AppConfig a;
         
         
         /**
          * 
          * Imp
          * 
          * */
                @RequestMapping(value = { "/impclients" }, method = RequestMethod.GET)
         public void imprimerloclvendsprovisionnel(HttpServletResponse response,HttpServletRequest request) throws ClassNotFoundException, JRException, IOException {
       
       
 
        String jrxmlFile = request.getServletContext().getRealPath(request.getContextPath())+"/imprim/listeclients.jrxml";
        InputStream input = new FileInputStream(new File(jrxmlFile));
 
        
        JasperReport report = JasperCompileManager.compileReport(input);

        Map<String, Object> param = new HashMap<String, Object>();
        String txtDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        //String heure = new SimpleDateFormat("HH:mm:ss").format(new Date().getTime());
        
        String bla="CNA";
        param.put("societe", "" +bla + "");
        param.put("date", "" + txtDate + "");
        //param.put("heure", "" + heure + "");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, param, new JRBeanCollectionDataSource(clientService.findAllClient()));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        
        //Exporting the report as a PDF
 
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        
 
    }
         
         
         
         /**
          * 
          * Villes
          * 
          */
         @RequestMapping(value = { "/ajVille" }, method = RequestMethod.GET)
	public String AjVille(ModelMap model) {
                Ville ville=new Ville();
                 model.addAttribute("ville",ville);
		return "villelist";
	}
        @RequestMapping(value = { "/ajVille" }, method = RequestMethod.POST)
	public String AjoutVille(@Valid Ville ville,ModelMap model) {
                villeService.save(ville);
		return "villelist";
	}
        /**
         * 
         * 
         * PAIEMENTS
         * 
         */
         @RequestMapping(value = { "/listpay" }, method = RequestMethod.GET)
	public String listPaiements(ModelMap model) {
                List<Paiement> prpr=pService.findAllPaiement();
                
                
                model.addAttribute("pays",prpr);
		model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("mess","test");
		return "paiementsslist";
	}
        @RequestMapping(value = { "/view-p-{id}" }, method = RequestMethod.GET)
	public String viewPay( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Paiement prpr=pService.findById(result);
                model.addAttribute("contrat", prpr);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewpaiements";
	}
        @RequestMapping(value = { "/up-p-{id}" }, method = RequestMethod.GET)
	public String upPay( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Paiement prpr=pService.findById(result);
                List<Modepaiement> mp=mpService.findAllModepaiement();
                if (prpr.getCodefact()==null)
                {
                    List<Memoire> fs=mService.findAllMemoire();
                
                model.addAttribute("mems",fs);
                model.addAttribute("h", 1);
                
                }else{
                
                List<Facture> fs=fService.findAllFacture();
                model.addAttribute("facts",fs);
                model.addAttribute("h", 2);
                }
                model.addAttribute("villes",mp);
                model.addAttribute("contrat", prpr);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewpaiements";
	}
        @RequestMapping(value = { "/add-p-{id}" }, method = RequestMethod.GET)
	public String addPay( @PathVariable String id,ModelMap model) {
		//int result = Integer.parseInt(id);
                //Paiement prpr=pService.findById(result);
                Paiement prpr=new Paiement();
                
                if (id.equals("m"))
                {
                List<Facture> fs=fService.findAllFacture();
                model.addAttribute("facts",fs);
                model.addAttribute("h", 2);
                }else{
                
                List<Memoire> fs=mService.findAllMemoire();
                
                model.addAttribute("mems",fs);
                model.addAttribute("h", 1);
                }
                List<Modepaiement> mp=mpService.findAllModepaiement();
                model.addAttribute("villes",mp);
                model.addAttribute("contrat", prpr);
                model.addAttribute("type", 3);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewpaiements";
	}
        @RequestMapping(value = { "/add-p-{id}" }, method = RequestMethod.POST)
        public String ajPay(@ModelAttribute("contrat") @Valid Paiement pp, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                        
                      /*List<FieldError> errors = result.getFieldErrors();
                      String m="";
                        for (FieldError error : errors ) {
                            m+= error.getObjectName() + " - " + error.getDefaultMessage();
                            }
                      model.addAttribute("sss", m);
                      
                      return "redirect:/tentative";*/
                      
			
		}
                if (pp.getCodefact()==null)
                {
                Memoire fs=mService.findById(pp.getCodemem().getCode());
                List<Paiement> pye=pService.findBymemoire(pp.getCodemem().getCode());
                double tot=0;
                for(Paiement p:pye)
                    if(p.getNumpaiement()!=pp.getNumpaiement())
                        tot+=p.getMttc();
                tot+=pp.getMttc();
                if(fs.getMtttc()<tot)
                {FieldError ssoError =new FieldError("contrat","mttc",messageSource.getMessage("non.valid.mttc", new Object[]{pp.getMttc()}, Locale.getDefault()));
		    result.addError(ssoError);
                    List<Modepaiement> mp=mpService.findAllModepaiement();
                    model.addAttribute("villes",mp);
                
                    return "viewpaiements";
                }
                }else{
                
                Facture fs=fService.findById(pp.getCodefact().getCode());
                List<Paiement> pye=pService.findByfacture(pp.getCodefact().getCode());
                double tot=0;
                for(Paiement p:pye)
                    if(p.getNumpaiement()!=pp.getNumpaiement())
                        tot+=p.getMttc();
                //System.err.println("bla:"+tot);
                tot+=pp.getMttc();
                //System.err.println("bla:"+tot);
                if(fs.getMtttc()<tot)
                {FieldError ssoError =new FieldError("contrat","mttc",messageSource.getMessage("non.valid.mttc", new Object[]{pp.getMttc()}, Locale.getDefault()));
		    result.addError(ssoError);
                    List<Modepaiement> mp=mpService.findAllModepaiement();
                model.addAttribute("villes",mp);
                
                    return "viewpaiements";}
                
                }
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
                

                //System.out.println("com.mind.ak47.begin.controller.AppController.updateprojetpr()");
                //System.err.println("dddddddddddddddddd"+client.toString());
		pService.save(pp);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/listpay?opr";
	}
        @RequestMapping(value = { "/up-p-{id}" }, method = RequestMethod.POST)
        public String updatePay(@ModelAttribute("contrat") @Valid Paiement pp, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                        
                      /*List<FieldError> errors = result.getFieldErrors();
                      String m="";
                        for (FieldError error : errors ) {
                            m+= error.getObjectName() + " - " + error.getDefaultMessage();
                            }
                      model.addAttribute("sss", m);
                      
                      return "redirect:/tentative";*/
                      
			
		}
                if (pp.getCodefact()==null)
                {
                Memoire fs=mService.findById(pp.getCodemem().getCode());
                List<Paiement> pye=pService.findBymemoire(pp.getCodemem().getCode());
                double tot=0;
                for(Paiement p:pye)
                    if(p.getNumpaiement()!=pp.getNumpaiement())
                        tot+=p.getMttc();
                tot+=pp.getMttc();
                if(fs.getMtttc()<tot)
                {FieldError ssoError =new FieldError("contrat","mttc",messageSource.getMessage("non.valid.mttc", new Object[]{pp.getMttc()}, Locale.getDefault()));
		    result.addError(ssoError);
                    List<Modepaiement> mp=mpService.findAllModepaiement();
                    model.addAttribute("villes",mp);
                
                    return "viewpaiements";
                }
                }else{
                
                Facture fs=fService.findById(pp.getCodefact().getCode());
                List<Paiement> pye=pService.findByfacture(pp.getCodefact().getCode());
                double tot=0;
                for(Paiement p:pye)
                    if(p.getNumpaiement()!=pp.getNumpaiement())
                        tot+=p.getMttc();
                //System.err.println("bla:"+tot);
                tot+=pp.getMttc();
                //System.err.println("bla:"+tot);
                if(fs.getMtttc()<tot)
                {FieldError ssoError =new FieldError("contrat","mttc",messageSource.getMessage("non.valid.mttc", new Object[]{pp.getMttc()}, Locale.getDefault()));
		    result.addError(ssoError);
                    List<Modepaiement> mp=mpService.findAllModepaiement();
                model.addAttribute("villes",mp);
                
                    return "viewpaiements";}
                
                }
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
                

                //System.out.println("com.mind.ak47.begin.controller.AppController.updateprojetpr()");
                //System.err.println("dddddddddddddddddd"+client.toString());
		pService.update(pp);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/listpay?opr";
	}
        @RequestMapping(value="/aj-doc-p-{id}", method = RequestMethod.GET)
        public String getpUploadPage(ModelMap model,@PathVariable String id) {
            model.addAttribute("id",id);
        FileBucket fileBucket = new FileBucket();
        model.addAttribute("fileBucket", fileBucket);
        return "SingleFileUploader_1";
        }
        @RequestMapping(value="/aj-doc-p-{id}", method = RequestMethod.POST)
        public String pFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model,@PathVariable String id) throws IOException {
        
            if (result.hasErrors()) {
                System.out.println("validation errors");
                return "SingleFileUploader_1";
            } else {
                int resultat=Integer.parseInt(id);
                Paiement d=pService.findById(resultat);
                //int codepr=d.getCodeprojet().getCode();
                //System.out.println("pr"+codepr);
                d.setLiendoc(fileBucket.getFile().getOriginalFilename().substring(fileBucket.getFile().getOriginalFilename().lastIndexOf('.'), fileBucket.getFile().getOriginalFilename().length()));
                //System.out.println("Fetching file"+d.getExt());
                MultipartFile multipartFile = fileBucket.getFile();
 
                //Now do something with file...
                FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION+"/p"+id+d.getLiendoc()));
                pService.updatepath(d);
                
                                
                String fileName = multipartFile.getOriginalFilename();
                //model.addAttribute("fileName", fileName);
                return "redirect:/listpay";
            }
        }
        @RequestMapping(value="/view-doc-p-{id}-{type}", method = RequestMethod.GET)
        public void downloadp(HttpServletResponse response, @PathVariable("type") String type ,@PathVariable("id") String id) throws IOException {
        
        File file = null;
         
        //if(type.equalsIgnoreCase("internal")){
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            int result = Integer.parseInt(id);
            Paiement ds=pService.findById(result);
            String INTERNAL_FILE="p"+id+ds.getLiendoc();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        //}
         
        if(!file.exists()){
            //FormatterRegistry registry.addCon
            
            String errorMessage = "ooups. le document n'existe pas";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
          /**
          * 
          * Bons de commande
          * 
          */
      
         @RequestMapping(value = { "/viewbcparpr" }, method = RequestMethod.GET)
	public String listBCparprojets( ModelMap model) {
		
		model.addAttribute("loggedinuser", getPrincipal());
		return "BCparPr";
	}
         @RequestMapping(value = { "/viewbcparpr" }, method = RequestMethod.POST)
	public String listBcparprojet(HttpServletRequest request, ModelMap model) {
		String id=(String)request.getParameter("code");
                int result = Integer.parseInt(id);
                Projetprive prpu=ProjetpriveService.findById(result);
                if (prpu!=null)
                {model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/listbc-"+prpu.getCode();}
                else{
                    
                model.addAttribute("loggedinuser", getPrincipal());
		return "BCparPr";
                }
	}
        @RequestMapping(value = { "/listbc-{id}" }, method = RequestMethod.GET)
	public String listBCs( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                List<Boncommande> bcs=bcService.findBypr(result);
                model.addAttribute("p",result);
                model.addAttribute("contrats", bcs);
		model.addAttribute("loggedinuser", getPrincipal());
		return "bcslist";
	}
        @RequestMapping(value = { "/view-bc-{id}" }, method = RequestMethod.GET)
	public String viewBC( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Boncommande bcs=bcService.findById(result);
                model.addAttribute("p", bcs.getCodeprojet().getCode());
                model.addAttribute("contrat", bcs);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewBCs";
	}
        @RequestMapping(value = { "/up-bc-{id}" }, method = RequestMethod.GET)
	public String upBC( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Boncommande bcs=bcService.findById(result);
                model.addAttribute("contrat", bcs);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewBCs";
	}
        @RequestMapping(value = { "/add-bc-{id}" }, method = RequestMethod.GET)
	public String addBC(@PathVariable String id, ModelMap model) {
		Boncommande cl= new Boncommande();
                //cl.setMail("kzaojcfpf");
                int result = Integer.parseInt(id);
                model.addAttribute("p",result);
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("contrat", cl);
		model.addAttribute("h", 3);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewBCs";
	}
        @RequestMapping(value = { "/up-bc-{id}" }, method = RequestMethod.POST)
        public String updateBC(@ModelAttribute("contrat") @Valid Boncommande clientso, BindingResult result,
			ModelMap model,@PathVariable String id) {

		if (result.hasErrors()) {
                    
                      	
			return "viewBCs";
		}
                bcService.update(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listbc-"+id;
	}
        
        @RequestMapping(value = { "/add-bc-{id}" }, method = RequestMethod.POST)
        public String saveBC(@ModelAttribute("contrat") @Valid Boncommande clientso, BindingResult result,
			ModelMap model,@PathVariable String id) {

		if (result.hasErrors()) {
                    
                      	
			return "viewBCs";
		}
                bcService.save(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listbc-"+id;
	}
        @RequestMapping(value="/aj-doc-bc-{id}", method = RequestMethod.GET)
        public String getbcUploadPage(ModelMap model,@PathVariable String id) {
            model.addAttribute("id",id);
        FileBucket fileBucket = new FileBucket();
        model.addAttribute("fileBucket", fileBucket);
        return "SingleFileUploader_b";
        }
        @RequestMapping(value="/aj-doc-bc-{id}", method = RequestMethod.POST)
        public String bcFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model,@PathVariable String id) throws IOException {
        
            if (result.hasErrors()) {
                System.out.println("validation errors");
                return "SingleFileUploader_b";
            } else {
                int resultat=Integer.parseInt(id);
                Boncommande d=bcService.findById(resultat);
                //int codepr=d.getCodeprojet().getCode();
                //System.out.println("pr"+codepr);
                d.setLiendoc(fileBucket.getFile().getOriginalFilename().substring(fileBucket.getFile().getOriginalFilename().lastIndexOf('.'), fileBucket.getFile().getOriginalFilename().length()));
                //System.out.println("Fetching file"+d.getExt());
                MultipartFile multipartFile = fileBucket.getFile();
 
                //Now do something with file...
                FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION+"/bc"+id+d.getLiendoc()));
                bcService.updatepath(d);
                
                                
                String fileName = multipartFile.getOriginalFilename();
                //model.addAttribute("fileName", fileName);
                return "redirect:/listbc-"+d.getCodeprojet().getCode();
            }
        }
        @RequestMapping(value="/aj-doc-bc-{id}-{type}", method = RequestMethod.GET)
        public void downloadbc(HttpServletResponse response, @PathVariable("type") String type ,@PathVariable("id") String id) throws IOException {
        
        File file = null;
         
        //if(type.equalsIgnoreCase("internal")){
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            int result = Integer.parseInt(id);
            Boncommande ds=bcService.findById(result);
            String INTERNAL_FILE="bc"+id+ds.getLiendoc();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        //}
         
        if(!file.exists()){
            String errorMessage = "ooups. le document n'existe pas";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
          /**
          * 
          * Factures
          * 
          */

         @RequestMapping(value = { "/viewfparpr" }, method = RequestMethod.GET)
	public String listFparprojets( ModelMap model) {
		
		model.addAttribute("loggedinuser", getPrincipal());
		return "BCparPr";
	}
         @RequestMapping(value = { "/viewfparpr" }, method = RequestMethod.POST)
	public String listFparprojet(HttpServletRequest request, ModelMap model) {
		String id=(String)request.getParameter("code");
                int result = Integer.parseInt(id);
                model.addAttribute("p",result);
                Projetprive prpu=ProjetpriveService.findById(result);
                if (prpu!=null)
                {model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/listf-"+prpu.getCode();}
                else{
                    
                model.addAttribute("loggedinuser", getPrincipal());
		return "BCparPr";
                }
	}
        @RequestMapping(value = { "/listf-{id}" }, method = RequestMethod.GET)
	public String listFs( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                List<Facture> bcs=fService.findBypr(result);
                model.addAttribute("p",result);
                model.addAttribute("contrats", bcs);
		model.addAttribute("loggedinuser", getPrincipal());
		return "factureslist";
	}
        @RequestMapping(value = { "/view-f-{id}" }, method = RequestMethod.GET)
	public String viewF( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Facture bcs=fService.findById(result);
                model.addAttribute("contrat", bcs);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewfactures";
	}
        @RequestMapping(value = { "/up-f-{id}" }, method = RequestMethod.GET)
	public String upF( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
               Facture bcs=fService.findById(result);
                model.addAttribute("contrat", bcs);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewfactures";
	}
        @RequestMapping(value = { "/add-f-{id}" }, method = RequestMethod.GET)
	public String addF( @PathVariable String id,ModelMap model) {
		Facture cl= new Facture();
                //cl.setMail("kzaojcfpf");
                //List<Ville> villes=villeService.findAllVille();
                int result = Integer.parseInt(id);
                model.addAttribute("p",result);
                //model.addAttribute("villes",villes);
		model.addAttribute("contrat", cl);
		//model.addAttribute("h", 3);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewfactures";
	}
        @RequestMapping(value = { "/up-f-{id}" }, method = RequestMethod.POST)
        public String updateF(@ModelAttribute("contrat") @Valid Facture clientso, BindingResult result,
			ModelMap model,@PathVariable String id) {

		if (result.hasErrors()) {
                    
                      	
			return "viewfactures";
		}
                fService.update(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listf-"+clientso.getCodeprojet().getCode();
	}
        @RequestMapping(value = { "/add-f-{id}" }, method = RequestMethod.POST)
        public String saveF(@ModelAttribute("contrat") @Valid Facture clientso, BindingResult result,
			ModelMap model,@PathVariable String id) {

		if (result.hasErrors()) {
                    
                      	
			return "viewfactures";
		}
                fService.save(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listf-"+id;
	}
        @RequestMapping(value="/aj-doc-f-{id}", method = RequestMethod.GET)
        public String getfUploadPage(ModelMap model,@PathVariable String id) {
            model.addAttribute("id",id);
        FileBucket fileBucket = new FileBucket();
        model.addAttribute("fileBucket", fileBucket);
        return "SingleFileUploader_f";
        }
        @RequestMapping(value="/aj-doc-f-{id}", method = RequestMethod.POST)
        public String fFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model,@PathVariable String id) throws IOException {
        
            if (result.hasErrors()) {
                System.out.println("validation errors");
                return "SingleFileUploader_f";
            } else {
                int resultat=Integer.parseInt(id);
                Facture d=fService.findById(resultat);
                //int codepr=d.getCodeprojet().getCode();
                //System.out.println("pr"+codepr);
                d.setLiendoc(fileBucket.getFile().getOriginalFilename().substring(fileBucket.getFile().getOriginalFilename().lastIndexOf('.'), fileBucket.getFile().getOriginalFilename().length()));
                //System.out.println("Fetching file"+d.getExt());
                MultipartFile multipartFile = fileBucket.getFile();
 
                //Now do something with file...
                FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION+"/f"+id+d.getLiendoc()));
                fService.updatepath(d);
                
                                
                String fileName = multipartFile.getOriginalFilename();
                //model.addAttribute("fileName", fileName);
                return "redirect:/listf-"+d.getCodeprojet().getCode();
            }
        }
        @RequestMapping(value="/view-doc-f-{id}-{type}", method = RequestMethod.GET)
        public void downloadf(HttpServletResponse response, @PathVariable("type") String type ,@PathVariable("id") String id) throws IOException {
        
        File file = null;
         
        //if(type.equalsIgnoreCase("internal")){
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            int result = Integer.parseInt(id);
            Facture ds=fService.findById(result);
            String INTERNAL_FILE="f"+id+ds.getLiendoc();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        //}
         
        if(!file.exists()){
            String errorMessage = "ooups. le document n'existe pas";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
         /**
          * 
          * Contrats
          * 
          */

         @RequestMapping(value = { "/viewcparpr" }, method = RequestMethod.GET)
	public String listContratsparprojet( ModelMap model) {
		
		model.addAttribute("loggedinuser", getPrincipal());
		return "CparPr";
	}
         @RequestMapping(value = { "/viewcparpr" }, method = RequestMethod.POST)
	public String listContratsparprojets(HttpServletRequest request, ModelMap model) {
		String id=(String)request.getParameter("code");
                int result = Integer.parseInt(id);
                Projetpublic prpu=ProjetpuService.findById(result);
                if (prpu!=null)
                {model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/listcontr-"+prpu.getCode();}
                else{
                    
                model.addAttribute("loggedinuser", getPrincipal());
		return "CparPr";
                }
	}
        @RequestMapping(value = { "/listcontr-{id}" }, method = RequestMethod.GET)
	public String listContrats( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                List<Contrat> cs=cService.findbyContrat(result);
                model.addAttribute("p", result);
                model.addAttribute("contrats", cs);
		model.addAttribute("loggedinuser", getPrincipal());
		return "contratslist";
	}
        @RequestMapping(value = { "/view-ch-{id}" }, method = RequestMethod.GET)
	public String viewContrat( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Contrat cs=cService.findById(result);
                model.addAttribute("contrat", cs);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewcontrats";
	}
        @RequestMapping(value = { "/up-ch-{id}" }, method = RequestMethod.GET)
	public String upContrat( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Contrat cs=cService.findById(result);
                model.addAttribute("contrat", cs);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewcontrats";
	}
        @RequestMapping(value = { "/up-ch-{id}" }, method = RequestMethod.POST)
        public String updatech(@Valid Contrat pp, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                        
                      List<FieldError> errors = result.getFieldErrors();
                      String m="";
                        for (FieldError error : errors ) {
                            m+= error.getObjectName() + " - " + error.getDefaultMessage();
                            }
                      model.addAttribute("sss", m);
                      
                      return "redirect:/tentative";
                      
			
		}
                
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/

                System.out.println("com.mind.ak47.begin.controller.AppController.updateprojetpr()");
                //System.err.println("dddddddddddddddddd"+client.toString());
		cService.update(pp);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/view-ch-"+id;
	}
        @RequestMapping(value = { "/add-c-{id}" }, method = RequestMethod.GET)
	public String addCh( ModelMap model ,@PathVariable String id) {
		Contrat cl= new Contrat();
                //cl.setMail("kzaojcfpf");
                int result = Integer.parseInt(id);
                model.addAttribute("p",result);
                //List<Ville> villes=villeService.findAllVille();
                List<Contrat> v=cService.findbyContrat(result);
                model.addAttribute("villes",v.size());
		model.addAttribute("contrat", cl);
		model.addAttribute("h", 3);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewcontrats";
	}
        @RequestMapping(value = { "/add-c-{id}" }, method = RequestMethod.POST)
        public String saveCh(@ModelAttribute("contrat") @Valid Contrat clientso, BindingResult result,
			ModelMap model,@PathVariable String id) {

		if (result.hasErrors()) {
                    List<FieldError> errors = result.getFieldErrors();
                      String m="";
                        for (FieldError error : errors ) {
                            m+= error.getObjectName() + " - " + error.getDefaultMessage();
                            }
                      model.addAttribute("sss", m);
                      	
			return "redirect:/tentative"+m;
		}
                cService.save(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listcontr-"+id;
	}
         @RequestMapping(value="/aj-doc-c-{id}", method = RequestMethod.GET)
        public String getcUploadPage(ModelMap model,@PathVariable String id) {
            model.addAttribute("id",id);
        FileBucket fileBucket = new FileBucket();
        model.addAttribute("fileBucket", fileBucket);
        return "SingleFileUploader_c";
        }
        @RequestMapping(value="/aj-doc-c-{id}", method = RequestMethod.POST)
        public String cFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model,@PathVariable String id) throws IOException {
        
            if (result.hasErrors()) {
                System.out.println("validation errors");
                return "SingleFileUploader_c";
            } else {
                int resultat=Integer.parseInt(id);
                Contrat d=cService.findById(resultat);
                //int codepr=d.getCodeprojet().getCode();
                //System.out.println("pr"+codepr);
                d.setLiendoc(fileBucket.getFile().getOriginalFilename().substring(fileBucket.getFile().getOriginalFilename().lastIndexOf('.'), fileBucket.getFile().getOriginalFilename().length()));
                //System.out.println("Fetching file"+d.getExt());
                MultipartFile multipartFile = fileBucket.getFile();
 
                //Now do something with file...
                FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION+"/c"+id+d.getLiendoc()));
                cService.updatepath(d);
                
                                
                String fileName = multipartFile.getOriginalFilename();
                //model.addAttribute("fileName", fileName);
                return "redirect:/listcontr-"+d.getCodeprojet().getCode();
            }
        }
        @RequestMapping(value="/view-doc-c-{id}-{type}", method = RequestMethod.GET)
        public void downloadc(HttpServletResponse response, @PathVariable("type") String type ,@PathVariable("id") String id) throws IOException {
        
        File file = null;
         
        //if(type.equalsIgnoreCase("internal")){
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            int result = Integer.parseInt(id);
            Contrat ds=cService.findById(result);
            String INTERNAL_FILE="c"+id+ds.getLiendoc();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        //}
         
        if(!file.exists()){
            String errorMessage = "ooups. le document n'existe pas";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
         /**
          * 
          * memoires
          * 
          */
 
         @RequestMapping(value = { "/viewmparpr" }, method = RequestMethod.GET)
	public String listMparprojets( ModelMap model) {
		
		model.addAttribute("loggedinuser", getPrincipal());
		return "BCparPr";
	}
         @RequestMapping(value = { "/viewmparpr" }, method = RequestMethod.POST)
	public String listMparprojet(HttpServletRequest request, ModelMap model) {
		String id=(String)request.getParameter("code");
                int result = Integer.parseInt(id);
                Projetpublic prpu=ProjetpuService.findById(result);
                if (prpu!=null)
                {model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/listm-"+prpu.getCode();}
                else{
                    
                model.addAttribute("loggedinuser", getPrincipal());
		return "BCparPr";
                }
	}
        @RequestMapping(value = { "/listm-{id}" }, method = RequestMethod.GET)
	public String listMs( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                List<Memoire> bcs=mService.findBypr(result);
                model.addAttribute("p",result);
                model.addAttribute("contrats", bcs);
		model.addAttribute("loggedinuser", getPrincipal());
		return "memoireslist";
	}
        @RequestMapping(value = { "/view-mem-{id}" }, method = RequestMethod.GET)
	public String viewM( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
                Memoire bcs=mService.findById(result);
                model.addAttribute("contrat", bcs);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewmemoires";
	}
        @RequestMapping(value = { "/up-m-{id}" }, method = RequestMethod.GET)
	public String upM( @PathVariable String id,ModelMap model) {
		int result = Integer.parseInt(id);
               Memoire bcs=mService.findById(result);
               model.addAttribute("p",bcs.getCodeprojet().getCode());
                model.addAttribute("contrat", bcs);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewmemoires";
	}
        @RequestMapping(value = { "/up-m-{id}" }, method = RequestMethod.POST)
        public String updateMem(@ModelAttribute("contrat") @Valid Memoire clientso, BindingResult result,
			ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
                    
                      	
			return "viewmemoires";
		}
                mService.update(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
                
		return "redirect:/listm-"+clientso.getCodeprojet().getCode();
	}
        @RequestMapping(value = { "/add-m-{id}" }, method = RequestMethod.GET)
	public String addMem( ModelMap model,@PathVariable String id) {
		Memoire cl= new Memoire();
                int result = Integer.parseInt(id);
                model.addAttribute("p", result);
                //cl.setMail("kzaojcfpf");
                //List<Ville> villes=villeService.findAllVille();
                //model.addAttribute("villes",villes);
		model.addAttribute("contrat", cl);
		//model.addAttribute("h", 3);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewmemoires";
	}
        @RequestMapping(value = { "/add-m-{id}" }, method = RequestMethod.POST)
        public String saveMem( @ModelAttribute("contrat") @Valid Memoire clientso, BindingResult result,
			ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
                    
                      	
			return "viewmemoires";
		}
                mService.save(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
                
		return "redirect:/listm-"+id;
	}
        @RequestMapping(value="/aj-doc-m-{id}", method = RequestMethod.GET)
        public String getmUploadPage(ModelMap model,@PathVariable String id) {
            model.addAttribute("id",id);
        FileBucket fileBucket = new FileBucket();
        model.addAttribute("fileBucket", fileBucket);
        return "SingleFileUploader_m";
        }
        @RequestMapping(value="/aj-doc-m-{id}", method = RequestMethod.POST)
        public String mFileUpload( @Valid FileBucket fileBucket, BindingResult result, ModelMap model,@PathVariable String id) throws IOException {
        
            if (result.hasErrors()) {
                System.out.println("validation errors");
                return "SingleFileUploader_m";
            } else {
                int resultat=Integer.parseInt(id);
                Memoire d=mService.findById(resultat);
                //int codepr=d.getCodeprojet().getCode();
                //System.out.println("pr"+codepr);
                d.setLiendoc(fileBucket.getFile().getOriginalFilename().substring(fileBucket.getFile().getOriginalFilename().lastIndexOf('.'), fileBucket.getFile().getOriginalFilename().length()));
                //System.out.println("Fetching file"+d.getExt());
                MultipartFile multipartFile = fileBucket.getFile();
 
                //Now do something with file...
                FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION+"/m"+id+d.getLiendoc()));
                mService.updatepath(d);
                
                                
                String fileName = multipartFile.getOriginalFilename();
                //model.addAttribute("fileName", fileName);
                return "redirect:/listm-"+d.getCodeprojet().getCode();
            }
        }
        @RequestMapping(value="/view-doc-m-{id}-{type}", method = RequestMethod.GET)
        public void downloadm(HttpServletResponse response, @PathVariable("type") String type ,@PathVariable("id") String id) throws IOException {
        
        File file = null;
         
        //if(type.equalsIgnoreCase("internal")){
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            int result = Integer.parseInt(id);
            Memoire ds=mService.findById(result);
            String INTERNAL_FILE="m"+id+ds.getLiendoc();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        //}
         
        if(!file.exists()){
            String errorMessage = "ooups. le document n'existe pas";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
         /**
          * Documents
          */
         
         @Autowired
        FileValidator fileValidator;
        @InitBinder("fileBucket")
        protected void initBinderFileBucket(WebDataBinder binder) {
            binder.setValidator(fileValidator);
        }
         private static String UPLOAD_LOCATION="C:/Users/asus/Documents/NetBeansProjects/Begin/src/main/resources";         
         @RequestMapping(value="/singleUpload-{id}-doc", method = RequestMethod.GET)
        public String getSingleUploadPage(ModelMap model,@PathVariable String id) {
            model.addAttribute("id",id);
        FileBucket fileBucket = new FileBucket();
        model.addAttribute("fileBucket", fileBucket);
        return "SingleFileUploader";
        }
        @RequestMapping(value="/singleUpload-{id}-doc", method = RequestMethod.POST)
        public String singleFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model,@PathVariable String id) throws IOException {
        
            if (result.hasErrors()) {
                System.out.println("validation errors");
                return "SingleFileUploader";
            } else {
                int resultat=Integer.parseInt(id);
                Document d=docService.findById(resultat);
                int codepr=d.getCodeprojet().getCode();
                System.out.println("pr"+codepr);
                d.setExt(fileBucket.getFile().getOriginalFilename().substring(fileBucket.getFile().getOriginalFilename().lastIndexOf('.'), fileBucket.getFile().getOriginalFilename().length()));
                System.out.println("Fetching file"+d.getExt());
                MultipartFile multipartFile = fileBucket.getFile();
 
                //Now do something with file...
                FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION+"/doc"+id+d.getExt()));
                docService.update(d);
                
                                
                String fileName = multipartFile.getOriginalFilename();
                //model.addAttribute("fileName", fileName);
                return "redirect:/viewdoc-"+d.getCodeprojet().getCode();
            }
        }
        @RequestMapping(value = { "/viewdoc-{id}" }, method = RequestMethod.GET)
	public String viewdoc(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                //Projet p=prService.findById(result);
                List<Document> ds=docService.findBypr(result);
                model.addAttribute("docs",ds);
		model.addAttribute("result", result);
		model.addAttribute("h", 1);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "documentslist";
	}
         @RequestMapping(value = { "/add-doc-{id}" }, method = RequestMethod.GET)
	public String ajdoc(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                //Projet p=prService.findById(result);
                List<Document> ds=docService.findBypr(result);
                int numdoc=ds.size();
                model.addAttribute("numdoc", numdoc+1);
                model.addAttribute("codepr", result);
                //model.addAttribute("docs",ds);
		
                List<Typedoc> tys=tdService.findAll();
                model.addAttribute("villes", tys);
		//model.addAttribute("h", 1);
                model.addAttribute("type", 2);
                Document doc=new Document();
                model.addAttribute("document", doc);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewdocument";
	}
         @RequestMapping(value = { "/add-doc-{id}" }, method = RequestMethod.POST)
	public String adddoc(@Valid Document document ,BindingResult result,ModelMap model,@PathVariable String id) {
		System.out.println("doc : "+document);
                //Projet p=prService.findById(result);
                /*List<Document> ds=docService.findBypr(result);
                int numdoc=ds.size();
                model.addAttribute("numdoc", numdoc+1);
                model.addAttribute("codepr", result);
                //model.addAttribute("docs",ds);
		
		//model.addAttribute("h", 1);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewdocument";*/
                if (result.hasErrors()) {
                    
                      	
			List<FieldError> errors = result.getFieldErrors();
                      String m="";
                        for (FieldError error : errors ) {
                            m+= error.getObjectName() + " - " + error.getDefaultMessage();
                            }
                      model.addAttribute("sss", m);
                      
                      return "redirect:/tentative";
		}
                int resultat = Integer.parseInt(id);
                docService.save(document);
                System.out.println("doc : "+resultat);
                List<Document> docs=docService.findBypr(resultat);
                System.out.println("doc : "+docs.size());
                //int numdoc=docs.indexOf();
                Document d=docs.get(docs.size()-1);
		System.out.println("doc : "+d.getCode());
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/singleUpload-"+d.getCode()+"-doc";
                
	}
         @RequestMapping(value="/download/doc/{id}/{type}", method = RequestMethod.GET)
        public void downloadFile(HttpServletResponse response, @PathVariable("type") String type ,@PathVariable("id") String id) throws IOException {
        
        File file = null;
         
        //if(type.equalsIgnoreCase("internal")){
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            int result = Integer.parseInt(id);
            Document ds=docService.findById(result);
            String INTERNAL_FILE="doc"+id+ds.getExt();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        //}
         
        if(!file.exists()){
            String errorMessage = "ooups. le document n'existe pas";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
 
    
         
         /**
         * 
         * PROJETs
         *  
         */
	
        @RequestMapping(value = { "/listpr" }, method = RequestMethod.GET)
	public String listProjets(ModelMap model) {
                List<Projetprive> prpr=ProjetpriveService.findAllProjetprive();
                List<Projetpublic> prpu=ProjetpuService.findAllProjetpublic();
                model.addAttribute("projetpu",prpu);
                model.addAttribute("projetpr",prpr);
		model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("mess","test");
		return "projetslist";
	}
        @RequestMapping(value = { "/viewpr-projet-{id}" }, method = RequestMethod.GET)
	public String viewProjetpr(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                
                Projetprive prpr=ProjetpriveService.findById(result);
                
                model.addAttribute("projet",prpr);
		
		model.addAttribute("h", 1);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewprojets";
	}
        @RequestMapping(value = { "/viewpu-projet-{id}" }, method = RequestMethod.GET)
	public String viewProjetpu(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                
                Projetpublic prpu=ProjetpuService.findById(result);
                
                model.addAttribute("projet",prpu);
		
		model.addAttribute("h", 2);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewprojets";
	}
        @RequestMapping(value = { "/uppr-projet-{id}" }, method = RequestMethod.GET)
	public String upProjetpr(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                
                Projetprive prpr=ProjetpriveService.findById(result);
                
                model.addAttribute("projet",prpr);
		
		model.addAttribute("h", 1);
                model.addAttribute("type", 3);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewprojets";
	}
        @RequestMapping(value = { "/uppu-projet-{id}" }, method = RequestMethod.GET)
	public String upProjetpu(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                
                Projetpublic prpu=ProjetpuService.findById(result);
                
                model.addAttribute("projet",prpu);
		
		model.addAttribute("h", 2);
                model.addAttribute("type", 3);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewprojets";
	}
        @RequestMapping(value = { "/uppr-projet-{id}" }, method = RequestMethod.POST)
        public String updateProjetpr(@Valid Projetprive pp, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                        
                      
                      
                      return "viewprojets";
                      
			
		}
                
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/

                System.out.println("com.mind.ak47.begin.controller.AppController.updateprojetpr()");
                //System.err.println("dddddddddddddddddd"+client.toString());
		ProjetpriveService.update(pp);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/listpr";
	}
        @RequestMapping(value = { "/uppu-projet-{id}" }, method = RequestMethod.POST)
        public String updateProjetpu(@ModelAttribute("projet") @Valid Projetpublic ppu, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                        
                      
                      return "viewprojets";
                      
			
		}
                
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/

                System.out.println("com.mind.ak47.begin.controller.AppController.updateprojetpu()");
                //System.err.println("dddddddddddddddddd"+client.toString());
		ProjetpuService.update(ppu);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/listpr";
	}
        @RequestMapping(value = { "/addpu-projet" }, method = RequestMethod.GET)
	public String addProjetpu( ModelMap model) {
		Projetpublic cl= new Projetpublic();
                //cl.setMail("kzaojcfpf");
                
                List<ClientPublic> villes1=clientPubService.findAllClient();
                model.addAttribute("villes1",villes1);
                
                
                
                
		model.addAttribute("projet", cl);
		model.addAttribute("h", 2);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewprojets";
	}
        @RequestMapping(value = { "/addpu-projet" }, method = RequestMethod.POST)
        public String saveProjetpu(@ModelAttribute("projet") @Valid Projetpublic clientso, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
                    
                      	
			return "viewprojets";
		}
                ProjetpuService.save(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listpr";
	}
        @RequestMapping(value = { "/addp-projet" }, method = RequestMethod.GET)
	public String addProjetpr( ModelMap model) {
		Projetprive cl= new Projetprive();
                //cl.setMail("kzaojcfpf");
                List<ClientP> villes=clientPService.findAllClient();
                model.addAttribute("villes",villes);
                List<ClientSociete> villes2=clientSService.findAllClient();
                model.addAttribute("villes2",villes2);
		model.addAttribute("projet", cl);
		model.addAttribute("h", 1);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewprojets";
	}
        @RequestMapping(value = { "/addp-projet" }, method = RequestMethod.POST)
        public String saveProjetpr(@ModelAttribute("projet") @Valid Projetprive clientso, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
                    
                      	
			return "viewprojets";
		}
                ProjetpriveService.save(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listpr";
	}
        @RequestMapping(value = { "/suppr-projet-{id}" }, method = RequestMethod.GET)
        public String supprojetpr(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                if(bcService.findBypr(result).isEmpty()&&fService.findBypr(result).isEmpty())
                {ProjetpriveService.deleteById(result);
		return "redirect:/listpr?supp";}
                return "redirect:/listpr?opf";
	}
        @RequestMapping(value = { "/suppu-projet-{id}" }, method = RequestMethod.GET)
        public String supprojetpu(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                if(cService.findbyContrat(result).isEmpty()&&mService.findBypr(result).isEmpty())
                {ProjetpuService.deleteById(result);
		return "redirect:/listpr?supp";}
                return "redirect:/listpr?opf";
	}
	/**
         * 
         * CLIENTs
         *  
         */
	
        @RequestMapping(value = { "/listcl" }, method = RequestMethod.GET)
	public String listClients(ModelMap model) {
                List<ClientP> clientsp=clientPService.findAllClient();
                List<ClientPublic> clientspu=clientPubService.findAllClient();
                List<ClientSociete> clientss=clientSService.findAllClient();
		if (!(clientsp.isEmpty()||clientsp==null))
		model.addAttribute("cl", clientsp);
                if (!(clientspu.isEmpty()||clientspu==null))
		model.addAttribute("clp", clientspu);
                if (!(clientss.isEmpty()||clientss==null))
		model.addAttribute("cls", clientss);
                
                
		model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("mess","test");
		return "clientslist";
	}
        
        @RequestMapping(value = { "/viewp-client-{id}" }, method = RequestMethod.GET)
	public String viewClientp(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientP cl = clientPService.findById(result);
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 2);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        @RequestMapping(value = { "/viewpu-client-{id}" }, method = RequestMethod.GET)
	public String viewClientpu(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientPublic cl = clientPubService.findById(result);
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 1);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        @RequestMapping(value = { "/views-client-{id}" }, method = RequestMethod.GET)
	public String viewClients(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientSociete cl = clientSService.findById(result);
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 3);
                model.addAttribute("type", 1);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}

        @RequestMapping(value = { "/upp-client-{id}" }, method = RequestMethod.GET)
	public String upClientp(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientP cl = clientPService.findById(result);
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 2);
                model.addAttribute("type", 3);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}

        @RequestMapping(value = { "/upp-client-{id}" }, method = RequestMethod.POST)
	public String updateclientp(@ModelAttribute("client") @Valid ClientP client, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                        
                      
                      return "viewclients";
                      
			
		}
                /*if(clientPService.findBycin(clientp.getCin())!=null){
			FieldError cinError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.cin", new String[]{clientp.getCin()}, Locale.getDefault()));
		    result.addError(cinError);
			return "viewclients";
		}*/
                
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/

                System.out.println("com.mind.ak47.begin.controller.AppController.updateclientp()");
                //System.err.println("dddddddddddddddddd"+client.toString());
		clientPService.update(client);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/listcl?opsu";
	}

        @RequestMapping(value = { "/uppu-client-{id}" }, method = RequestMethod.GET)
	public String upClientpu(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientPublic cl = clientPubService.findById(result);
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 1);
                model.addAttribute("type", 3);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        
        @RequestMapping(value = { "/uppu-client-{id}" }, method = RequestMethod.POST)
	public String updateclientpu(@ModelAttribute("client") @Valid ClientPublic client, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                        
                      model.addAttribute("h", 1);
                      
                      return "viewclients";
                      
			
		}
                
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
		clientPubService.update(client);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/listcl";
	}

        @RequestMapping(value = { "/ups-client-{id}" }, method = RequestMethod.GET)
	public String upClients(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientSociete cl = clientSService.findById(result);
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 3);
                model.addAttribute("type", 3);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        
        @RequestMapping(value = { "/ups-client-{id}" }, method = RequestMethod.POST)
	public String updateclients(@ModelAttribute("client") @Valid ClientSociete client, BindingResult result,
			ModelMap model, @PathVariable String id) {
                        
		
                if (result.hasErrors()) {
                       
                          model.addAttribute("h", 3); 
                          model.addAttribute("type", 3);
                      return "viewclients";
                      	
		}
                String m=client.getMatricule();
                boolean b=true;
                m=m.toUpperCase();
                if (m==null)
                    {b=false;}
                else if (m.length()!=12)
                    {b=false;}
                else{ 
                try{
                    int v=Integer.parseInt(m.substring(0, 5));}
                    catch(NumberFormatException e ){{b=false; }
                        if(m.charAt(6)<'A' || m.charAt(6)>'Z' || m.charAt(6)=='I' ||m.charAt(6)=='O' || m.charAt(6)=='U')
                        {b=false;}
                        if(m.charAt(7)=='A'||m.charAt(7)=='P'||m.charAt(7)=='B'||m.charAt(7)=='D'||m.charAt(7)=='N')
                            {b=false;}
                        if(m.charAt(8)=='M'||m.charAt(8)=='P'||m.charAt(8)=='C'||m.charAt(8)=='N')
                        {b=false;}
                        try{
                        int v1=Integer.parseInt(m.substring(9, 12));
                        if(m.charAt(8)=='E'&&v1==0)
                        {b=false;}
        
                        }
                        catch(NumberFormatException e1 ){b=false; }
        
                    }}
                
                if(b==false)
                {FieldError ssoError =new FieldError("client","matricule",messageSource.getMessage("non.valid.matricule", new String[]{client.getMatricule()}, Locale.getDefault()));
		    result.addError(ssoError);
                    model.addAttribute("h", 3); 
                          model.addAttribute("type", 3);
			return "viewclients";}

              
		clientSService.update(client);
                model.addAttribute("loggedinuser", getPrincipal());
                
		return "redirect:/listcl";
	}
        
        @RequestMapping(value = { "/addp-client" }, method = RequestMethod.GET)
	public String addClientp( ModelMap model) {
		
                ClientP cl = new ClientP();
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 2);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        @RequestMapping(value = { "/addpu-client" }, method = RequestMethod.GET)
	public String addClientpu( ModelMap model) {
		                
                ClientPublic cl = new ClientPublic();
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 1);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        @RequestMapping(value = { "/adds-client" }, method = RequestMethod.GET)
	public String addClients( ModelMap model) {
		ClientSociete cl= new ClientSociete();
                //cl.setMail("kzaojcfpf");
                List<Ville> villes=villeService.findAllVille();
                model.addAttribute("villes",villes);
		model.addAttribute("client", cl);
		model.addAttribute("h", 3);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        @RequestMapping(value = { "/adds-client" }, method = RequestMethod.POST)
        public String saveClients(@ModelAttribute("client") @Valid ClientSociete clientso, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
                    model.addAttribute("h", 3); 
                          model.addAttribute("type", 2);
                      	
			return "viewclients";
		}
                String m=clientso.getMatricule();
                boolean b=true;
                m=m.toUpperCase();
                if (m==null)
                    {b=false;}
                else if (m.length()!=12)
                    {
                        b=false;}
                else{ 
                try{System.err.println("b=true");
                    System.out.println("b=true");
                    int v=Integer.parseInt(m.substring(0, 5));}
                    catch(NumberFormatException e ){{b=false; }
                        if(m.charAt(6)<'A' || m.charAt(6)>'Z' || m.charAt(6)=='I' ||m.charAt(6)=='O' || m.charAt(6)=='U')
                        {b=false;}
                        if(m.charAt(7)=='A'||m.charAt(7)=='P'||m.charAt(7)=='B'||m.charAt(7)=='D'||m.charAt(7)=='N')
                            {b=false;}
                        if(m.charAt(8)=='M'||m.charAt(8)=='P'||m.charAt(8)=='C'||m.charAt(8)=='N')
                        {b=false;}
                        try{
                        int v1=Integer.parseInt(m.substring(10, 12));
                        if(m.charAt(8)=='E'&&v1==0)
                        {b=false;}
        
                        }
                        catch(NumberFormatException e1 ){b=false; }
        
                    }}
                
                if(b==false)
                {FieldError matError =new FieldError("client","matricule",messageSource.getMessage("non.valid.matricule", new String[]{clientso.getMatricule()}, Locale.getDefault()));
		    result.addError(matError);
                    model.addAttribute("h", 3); 
                          model.addAttribute("type", 2);
			return "viewclients";}
                clientSService.save(clientso);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listcl";
	}
        @RequestMapping(value = { "/addpu-client" }, method = RequestMethod.POST)
        public String saveClientpu(@ModelAttribute("client") @Valid ClientPublic clientpub, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
                    model.addAttribute("h", 1);
                model.addAttribute("type", 2);
			return "viewclients";
		}
                clientPubService.save(clientpub);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listcl";
	}
        @RequestMapping(value = { "/addp-client" }, method = RequestMethod.POST)
        public String saveClientp(@ModelAttribute("client") @Valid ClientP clientpp, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
                    model.addAttribute("h", 2);
                model.addAttribute("type", 2);
			return "viewclients";
		}
                if(clientPService.findBycin(clientpp.getCin())!=null){
			FieldError cinError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.cin", new String[]{clientpp.getCin()}, Locale.getDefault()));
		    result.addError(cinError);
                    model.addAttribute("h", 2);
                model.addAttribute("type", 2);
			return "viewclients";
		}
                clientPService.save(clientpp);

		
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "redirect:/listcl";
	}
        
        @RequestMapping(value = { "/supp-client-{id}" }, method = RequestMethod.GET)
	public String supClientp(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                if(ProjetpriveService.findBypr(result).isEmpty())
                {clientPService.deleteById(result);
		return "redirect:/listcl?supp";}
                return "redirect:/listcl?opf";
		
	}
        @RequestMapping(value = { "/suppu-client-{id}" }, method = RequestMethod.GET)
	public String supClientpu(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                if(ProjetpuService.findBypr(result).isEmpty())
                {clientPubService.deleteById(result);
                return "redirect:/listcl?supp";}
                return "redirect:/listcl?opf";
		//model.addAttribute("client", cl);
		
	}
        @RequestMapping(value = { "/sups-client-{id}" }, method = RequestMethod.GET)
	public String supClients(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                if(ProjetpriveService.findBypr(result).isEmpty())
                {clientSService.deleteById(result);
		return "redirect:/liscl?supp";}
                return "redirect:/liscl?opf";
	}
       
           
        /**
         * USERs
         */
 

        /**
	 * 
	 */
        @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String Accueil(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
                List<Facture> facts=fService.findAllFacture();
                //double montantf1=(double)0;
                List<Paiement> pays=pService.findAllPaiement();
                double montantp1=(double)0;
                double montantp2=(double)0;
                double montantp3=(double)0;
                double montantp4=(double)0;
                double montantp5=(double)0;
                double montantp6=(double)0;
                double montantp7=(double)0;
                double montantp8=(double)0;
                double montantp9=(double)0;
                double montantp10=(double)0;
                double montantp11=(double)0;
                double montantp12=(double)0;
                
                double montantf1=(double)0;
                double montantf2=(double)0;
                double montantf3=(double)0;
                double montantf4=(double)0;
                double montantf5=(double)0;
                double montantf6=(double)0;
                double montantf7=(double)0;
                double montantf8=(double)0;
                double montantf9=(double)0;
                double montantf10=(double)0;
                double montantf11=(double)0;
                double montantf12=(double)0;
                for (Paiement p:pays)
                {
                
                Calendar cal = Calendar.getInstance();
                cal.setTime(p.getDatereception());
                int month = cal.get(Calendar.MONTH);
                switch (month){
                    case 0:{montantp1 +=p.getMttc();break;}
                    case 1:{montantp2 +=p.getMttc();break;}
                    case 2:{montantp3 +=p.getMttc();break;}
                    case 3:{montantp4 +=p.getMttc();break;}
                    case 4:{montantp5 +=p.getMttc();break;}
                    case 5:{montantp6 +=p.getMttc();break;}
                    case 6:{montantp7 +=p.getMttc();break;}
                    case 7:{montantp8 +=p.getMttc();break;}
                    case 8:{montantp9 +=p.getMttc();break;}
                    case 9:{montantp10 +=p.getMttc();break;}
                    case 10:{montantp11 +=p.getMttc();break;}
                    case 11:{montantp12+=p.getMttc();break;}
                    
                }
                
                
                }
                for (Facture f:facts)
                {
                //f.getDatedesignation();
                Calendar cal = Calendar.getInstance();
                cal.setTime(f.getDatedesignation());
                int month = cal.get(Calendar.MONTH);
                System.out.println(month);
                //montantf1 +=f.getMtttc();
                switch (month){
                    case 0:{montantf1 +=f.getMtttc();break;}
                    case 1:{montantf2 +=f.getMtttc();break;}
                    case 2:{montantf3 +=f.getMtttc();break;}
                    case 3:{montantf4 +=f.getMtttc();break;}
                    case 4:{montantf5 +=f.getMtttc();break;}
                    case 5:{montantf6 +=f.getMtttc();break;}
                    case 6:{montantf7 +=f.getMtttc();break;}
                    case 7:{montantf8 +=f.getMtttc();break;}
                    case 8:{montantf9 +=f.getMtttc();break;}
                    case 9:{montantf10 +=f.getMtttc();break;}
                    case 10:{montantf11 +=f.getMtttc();break;}
                    case 11:{montantf12+=f.getMtttc();break;}
                
                
                
                
                }
                
                }
                model.addAttribute("montantf1",(int) montantf1);
                model.addAttribute("montantp1",(int) montantp1);
                model.addAttribute("montantf2",(int) montantf2);
                model.addAttribute("montantp2",(int) montantp2);
                model.addAttribute("montantf3",(int) montantf3);
                model.addAttribute("montantp3",(int) montantp3);
                model.addAttribute("montantf4",(int) montantf4);
                model.addAttribute("montantp4",(int) montantp4);
                model.addAttribute("montantf5",(int) montantf5);
                model.addAttribute("montantp5",(int) montantp5);
                model.addAttribute("montantf6",(int) montantf6);
                model.addAttribute("montantp6",(int) montantp6);
                model.addAttribute("montantf7",(int) montantf7);
                model.addAttribute("montantp7",(int) montantp7);
                model.addAttribute("montantf8",(int) montantf8);
                model.addAttribute("montantp8",(int) montantp8);
                model.addAttribute("montantf9",(int) montantf9);
                model.addAttribute("montantp9",(int) montantp9);
                model.addAttribute("montantf10",(int) montantf10);
                model.addAttribute("montantp10",(int) montantp10);
                model.addAttribute("montantf11",(int) montantf11);
                model.addAttribute("montantp11",(int) montantp11);
                model.addAttribute("montantf12",(int) montantf12);
                model.addAttribute("montantp12",(int) montantp12);
                
                
		model.addAttribute("loggedinuser", getPrincipal());
		return "Acceuil";
	}
        
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}
	/**
	 * 
	 */
        
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
        
	/**
	 * 
	 */
        
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
        
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}

        
	/**
	 * 
	 */
        
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
               	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {
                        
		if (result.hasErrors()) {
			return "registration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
        @ModelAttribute("villes")
	public List<Ville> initializeVilles() {
		return villeService.findAllVille();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "loginv2";
	    } else {
	    	return "redirect:/";  
	    }
	}
        @RequestMapping(value = "/tentative", method = RequestMethod.GET)
	public String tentativePage(ModelMap model) {
		
			return "tentative";
	    
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
			//persistentTokenBasedRememberMeServices.logout(request, response, auth);
			//SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}


}