<%-- 
    Document   : BCparPr
    Created on : 4 mai 2017, 13:47:41
    Author     : ak47@minduos
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="dashh.jsp" %>

 <li><a href="#">Home</a></li>
                    <li><a href="#">Projet</a></li>
                    <li><a href="#">Consulter</a></li>
                    <li class="active">projet n° </li>
                    <li class="active">Contrats </li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE CONTENT WRAPPER -->
                
                <div class="page-content-wrap">
                <form method="POST"  class="form-horizontal">
                    <div class="row">
                        <div class="col-md-12">
                            
                            <form class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>Projet</strong>  </h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>
                                </div>
                                
                                <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Code projet</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>                                                
                                                            <input type="text" name="code"  class="form-control" />
                                            </div>                                            
                                            
                                        </div>
                                    </div>
                                    
                                            
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    
                                <div class="panel-footer">
                                    <button class="btn btn-default">Retour</button> 
                                    <input type="submit" class="btn btn-primary pull-right" value="Recherche" />
                                </div>
                                
                            </div>
                            
                            
                        </div>
                    </div>                    
                    </form>
                </div>
                                        
                <!-- END PAGE CONTENT WRAPPER -->
<%@include file="dashf.jsp" %>

<%@include file="dashfe.jsp" %>