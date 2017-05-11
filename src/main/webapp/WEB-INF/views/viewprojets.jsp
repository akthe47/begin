<%-- 
    Document   : viewclients
    Created on : 19 avr. 2017, 11:17:26
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
                <form:form method="POST" modelAttribute="projet" class="form-horizontal">
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
                                                <c:if test="${type==2}">
                                                 <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Client</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                
                                                                <form:select path="codeclient" id="codeclient" class="form-control" name="codeclient">
                                                                    <c:if test="${ h==1}">
                                                                    <c:forEach var="client" items="${villes}">
                                                                    
                                                                    <form:option value="${client.code}"  >${client.code}</form:option>
                                                                    
                                                            
                                                                    
                                                                    </c:forEach>
                                                                    </c:if>
                                                                    <c:if test="${ h==2}">
                                                                    <c:forEach var="client" items="${villes1}">
                                                                    
                                                                    
                                                                     <form:option value="${client.code}"  >${client.code} |  ${client.nom}</form:option>
                                                                    
                                                                    </c:forEach>
                                                                     </c:if>
                                                                     <c:if test="${ h==1}">
                                                                    <c:forEach var="client" items="${villes2}">
                                                                    
                                                                    
                                                                     <form:option value="${client.code}"  >${client.code} |  ${client.raisonSociale}</form:option>
                                                                    
                                                                    </c:forEach>
                                                                     </c:if>
                                                                </form:select>
                                                       
                                                       
                                             
                                               
                                    </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div> 
                                                 </c:if>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Adresse</label>
                                        <div class="col-md-6 col-xs-12">
                                                <c:choose>
							<c:when test="${type==1}">
                                                            <textarea  class="form-control" rows="5" disabled="true">${projet.getAdresse()}</textarea>
                                                        </c:when>
							<c:otherwise>
                                                        <form:textarea path="adresse" id="adresse" class="form-control" rows="5"  ></form:textarea>
                                                        </c:otherwise>
                                                </c:choose>                                            
                                            
                                            <span class="help-block">Default textarea field</span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Description</label>
                                        <div class="col-md-6 col-xs-12">
                                                <c:choose>
							<c:when test="${type==1}">
                                                            <textarea  class="form-control" rows="5" disabled="true">${projet.getDescription()}</textarea>
                                                        </c:when>
							<c:otherwise>
                                                        <form:textarea path="description" id="description" class="form-control" rows="5"  ></form:textarea>
                                                        </c:otherwise>
                                                </c:choose>                                            
                                            
                                            <span class="help-block">Default textarea field</span>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">datedebut</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="false" value="${projet.getDatedebut()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatDate value="${projet.getDatedebut()}" var="dateStringdd" pattern="dd-MM-yyyy" />
                                                            <form:input type="text" value="${dateStringdd}" path="datedebut" id="datedebut" class="mask_date form-control" />
                                                        </c:otherwise>
                                                </c:choose>    
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="datedebut" class="help-inline"/></div> </span>
                                        </div>
                                    </div>
                                                <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">date fin</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="false" value="${projet.getDatefin()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatDate value="${projet.getDatefin()}" var="dateStringdf" pattern="dd-MM-yyyy" />
                                                            <form:input type="text" value="${dateStringdf}" path="datefin" id="datefin" class="mask_date form-control" />
                                                        </c:otherwise>
                                                </c:choose>    
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="datefin" class="help-inline"/></div> </span>
                                        </div>
                                    </div>
                                            <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Personne a contacter</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="${projet.getPersonneacontacter()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="" path="personneacontacter" id="personneacontacter" class="form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                                 <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Num Telephone</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="${projet.getNumtel()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="text" path="numtel" id="numtel" class="mask_phone form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                        <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Maitre d'ouvrage</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="${projet.getMaitreouvrage()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="" path="maitreouvrage" id="maitreouvrage" class="form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                            ${sss}
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Montant Travaux</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="<fmt:formatNumber type="number" groupingUsed="false" value="${projet.getMontanttravaux()}"/>"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatNumber type="number" groupingUsed="false" value="${projet.montanttravaux}"  var="formMontantTravaux"/>
                                                            <form:input type="text" path="montanttravaux" id="montanttravaux" value="${formMontantTravaux}" class="form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                <div class="panel-footer">
                                    <a href="<c:url value="/listpr"/>" class="btn btn-default">Retour</a>  
                                    <a href="<c:url value='/viewdoc-${projet.getCode()}' />" class="btn btn-success btn-sm ">Consulter Documents</a>
                                    <c:if test="${h==1}"><a href="<c:url value='/listbc-${projet.getCode()}' />" class="btn btn-info btn-sm ">Consulter Bons de commandes</a> <a href="<c:url value='/listf-${projet.getCode()}' />" class="btn btn-warning btn-sm ">Consulter factures</a></c:if>
                                    <c:if test="${h==2}"><a href="<c:url value='/listcontr-${projet.getCode()}' />" class="btn btn-info btn-sm ">Consulter Contrats d'honoraire</a><a href="<c:url value='/listm-${projet.getCode()}' />" class="btn btn-warning btn-sm ">Consulter Memoires honoraires</a></c:if>
                                    <input type="submit" class="btn btn-primary pull-right" <c:if test="${type==1}"> disabled="true" </c:if> value="Enregistrer" />
                                </div>
                                
                            </div>
                            
                            
                        </div>
                    </div>                    
                    
                </div>
                                        </form:form>
                <!-- END PAGE CONTENT WRAPPER -->

<%@include file="dashf.jsp" %>

<%@include file="dashfe.jsp" %>