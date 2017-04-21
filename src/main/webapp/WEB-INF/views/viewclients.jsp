<%-- 
    Document   : viewclients
    Created on : 19 avr. 2017, 11:17:26
    Author     : ak47@minduos
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="dashh.jsp" %>
<ul class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Client</a></li>
                    <li><a href="#">Consulter</a></li>
                    <li class="active">Client n° ${client.getCode()}</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                
                    <div class="row">
                        <div class="col-md-12">
                            
                            <form class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>One Column</strong> Layout</h3>
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
                                                <input type="text" class="form-control"  disabled="true"  value="${client.getCode()}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                                <c:if test="${h < 3}">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">nom</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" <c:if test="${type == 1}"> disabled="true" </c:if> value="${client.nom}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                                </c:if>
                                    <c:if test="${h == 2}"> 
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">prenom</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" <c:if test="${type == 1}"> disabled="true" </c:if> value="${client.prenom}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">cin</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" <c:if test="${type == 1}"> disabled="true" </c:if> value="${client.cin}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                    </c:if>
                                    <c:if test="${h == 3}"> 
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Raison sociale</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" <c:if test="${type == 1}"> disabled="true" </c:if> value="${client.raisonSociale}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Matricule fiscale</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" <c:if test="${type == 1}"> disabled="true" </c:if> value="${client.matricule}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                    </c:if>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Adresse</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <textarea class="form-control" rows="5" <c:if test="${type == 1}"> disabled="true" </c:if> >${client.getAdresse()}</textarea>
                                            <span class="help-block">Default textarea field</span>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">mail</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" <c:if test="${type == 1}"> disabled="true" </c:if> value="${client.getMail()}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                            <c:if test="${type == 3}">
                                            <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">mail</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                             <select class="form-control" name="ville">
                                            <c:forEach var="ville" items="${villes}">
                                                
                                            <option value="${ville.code}" <c:if test="${ville.code ==client.getCodeville().getCode()}"> selected="selected"</c:if>>${ville.description}</option>
                                            </c:forEach>
                                                </select>
                                               
                                    </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div> </c:if> 
                                   
                                <div class="panel-footer">
                                    <button class="btn btn-default">Retour</button>                                    
                                    <button class="btn btn-primary pull-right">Enregistrer</button>
                                </div>
                            </div>
                            </form>
                            
                        </div>
                    </div>                    
                    
                </div>
                <!-- END PAGE CONTENT WRAPPER -->

<%@include file="dashf.jsp" %>