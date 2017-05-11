<%-- 
    Document   : loginv2
    Created on : 4 mai 2017, 15:07:53
    Author     : ak47@minduos
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr" class="body-full-height">
    <head>
        <title>CNA Login</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="favicon.ico" type="<c:url value='/image/x-icon' />" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="<c:url value='/css/theme-default.css' />"/>
        <!-- EOF CSS INCLUDE -->  
    </head>
      <body>
        
        <div class="login-container login-v2">
            
            <div class="login-box animated fadeInDown">
                <div class="login-body">
                    <div class="login-title"><strong>Bonjour </strong> Veulliez authentifier</div>
                    <form action="${loginUrl}" class="form-horizontal" method="post">
                        <c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid Pseudo et Mot de passe.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>Vous êtes déconnecté avec success</p>
								</div>
							</c:if>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="fa fa-user"></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Pseudo" id="username" name="ssoId"  required/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="fa fa-lock"></span>
                                </div>                                
                                <input type="password" class="form-control" placeholder="Mot de Passe" id="password" name="password" required/>
                            </div>
                        </div>
                    </div>
                        <div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                              </div>
                            </div>
                    <div class="form-group">
                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								
							<div class="form-actions">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in">
							</div>
                    </div>
                    </form>
                </div>
                <div class="login-footer">
                    <div class="pull-left">
                        &copy; 2017 CNA-Documentations
                    </div>
                    
                </div>
            </div>
            
        </div>
        
    </body>
</html>
