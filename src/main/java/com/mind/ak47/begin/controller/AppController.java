package com.mind.ak47.begin.controller;

import com.mind.ak47.begin.model.Client;
import com.mind.ak47.begin.model.ClientP;
import com.mind.ak47.begin.model.ClientPublic;
import com.mind.ak47.begin.model.ClientSociete;
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
//import com.mind.ak47.begin.service.ClientService;
import com.mind.ak47.begin.service.UserProfileService;
import com.mind.ak47.begin.service.UserService;
import com.mind.ak47.begin.service.VilleService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;



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
	ClientPublicService clientPubService;
         @Autowired
	ClientSocieteService clientSService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
         @Autowired
	VilleService villeService;
	
         
         
         
         /**
         * 
         * PROJETs
         *  
         */
	
        @RequestMapping(value = { "/listpr" }, method = RequestMethod.GET)
	public String listProjets(ModelMap model) {
                
		model.addAttribute("loggedinuser", getPrincipal());
                model.addAttribute("mess","test");
		return "projetslist";
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
        @RequestMapping(value = { "/supp-client-{id}" }, method = RequestMethod.GET)
	public String supClientp(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientP cl = clientPService.findById(result);
		model.addAttribute("client", cl);
		model.addAttribute("h", 2);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        @RequestMapping(value = { "/suppu-client-{id}" }, method = RequestMethod.GET)
	public String supClientpu(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientPublic cl = clientPubService.findById(result);
		model.addAttribute("client", cl);
		model.addAttribute("h", 1);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        @RequestMapping(value = { "/sups-client-{id}" }, method = RequestMethod.GET)
	public String supClients(@PathVariable String id, ModelMap model) {
		int result = Integer.parseInt(id);
                ClientSociete cl = clientSService.findById(result);
		model.addAttribute("client", cl);
		model.addAttribute("h", 3);
                model.addAttribute("type", 2);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewclients";
	}
        
        
        
        
        
        
        
        
        
        /**
         * USERs
         */
        
        /**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}
	/**
	 * This method will provide the medium to add a new user.
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
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
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
	 * This method will provide the medium to update an existing user.
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
			return "login";
	    } else {
	    	return "redirect:/list";  
	    }
	}
        @RequestMapping(value = "/tentative", method = RequestMethod.GET)
	public String tentativePage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "tentative";
	    } else {
	    	return "redirect:/list";  
	    }
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