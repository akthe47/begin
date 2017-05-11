<%-- 
    Document   : villelist
    Created on : 5 mai 2017, 15:23:50
    Author     : ak47@minduos
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="dashh.jsp" %>
<ul class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Projet</a></li>
                    <li><a href="#">Consulter</a></li>
                    <li class="active">projet n° </li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE CONTENT WRAPPER -->
                
                <div class="page-content-wrap">
                <form:form method="POST" modelAttribute="ville" class="form-horizontal">
                    <div class="row">
                        <div class="col-md-12">
                            
                            <!--<form class="form-horizontal">-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>Projet</strong>  </h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>
                                </div>
                                
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">code</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-ban"></span></span>
                                                <form:input type="number" path="code" id="code" class="form-control"  disabled="true"  />
                                                <form:input type="hidden" path="code" id="code"/>
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                                <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">nom</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                
                                                        <form:input type="text" path="description" id="description" class="form-control"  />
                                                        
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                                 <div class="panel-footer">
                                    <button class="btn btn-default">Retour</button>     
                                    <input type="submit" class="btn btn-primary pull-right" value="Enregistrer" />
                                </div>
                                
                            </div>
                            
                            
                        </div>
                    </div>                    
                    
                </div>
                                        </form:form>
<%@include file="dashh.jsp" %>