<%-- 
    Document   : viewclients
    Created on : 19 avr. 2017, 11:17:26
    Author     : ak47@minduos
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                <span>${sss}</span>
                <div class="page-content-wrap">
                <form:form method="POST" modelAttribute="client" class="form-horizontal">
                    <div class="row">
                        <div class="col-md-12">
                            
                            <form class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>Client</strong> ${aaa}</h3>
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
                                                <c:if test="${h < 3}">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">nom</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="${client.nom}"/>
                                                        </c:when>
							<c:otherwise>
                                                        <form:input type="text" path="nom" id="nom" class="form-control"  value="${client.nom}"/>
                                                        </c:otherwise>
                                                </c:choose>
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
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="${client.prenom}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="text" path="prenom" id="prenom" class="form-control" value="${client.prenom}"/>
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">cin</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true" value="${client.cin}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="number" path="cin" id="cin" class="form-control"   value="${client.cin}"/>
                                                        </c:otherwise>
                                                </c:choose>
                                                
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
                                                <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="${client.raisonSociale}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="text" path="raisonSociale" id="raisonSociale" class="form-control"  />
                                                        </c:otherwise>
                                                </c:choose>
                                               
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Matricule fiscale</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control" disabled="true" value="${client.matricule}"/>
                                                        </c:when>
							<c:otherwise>
                                                        <form:input type="text" path="matricule" id="matricule" class="form-control" value="${client.matricule}"/>
                                                        </c:otherwise>
                                                </c:choose>    
                                                
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
                                                            <textarea  class="form-control" rows="5" disabled="true">${client.getAdresse()}</textarea>
                                                        </c:when>
							<c:otherwise>
                                                        <form:textarea path="adresse" id="adresse" class="form-control" rows="5"  ></form:textarea>
                                                        </c:otherwise>
                                                </c:choose>                                            
                                            
                                            <span class="help-block">Default textarea field</span>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">mail</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="true" value="${client.getMail()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="text" path="mail" id="mail" class="form-control" value="${client.getMail()}"/>
                                                        </c:otherwise>
                                                </c:choose>    
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                            
                                            <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">ville</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                            <form:select path="codeville" id="codeville" class="form-control" name="ville" disabled="true">
                                                                    <c:forEach var="ville" items="${villes}">
                                                            <c:if test="${ville.code ==client.getCodeville().getCode()}">
                                                                    <form:option value="${ville.code}"  selected="selected">${ville.description}</form:option>
                                                                    </c:if>
                                                            
                                                                    <c:if test="${ville.code !=client.getCodeville().getCode()}">
                                                                    <form:option value="${ville.code}"  >${ville.description}</form:option>
                                                                    </c:if>
                                                                    </c:forEach>
                                                                </form:select>
                                                        </c:when>
							<c:otherwise>
                                                                <form:select path="codeville" id="codeville" class="form-control" name="ville">
                                                                    <c:forEach var="ville" items="${villes}">
                                                                    
                                                                    <c:if test="${ville.code ==client.getCodeville().getCode()}">
                                                                    <form:option value="${ville.code}"  selected="selected">${ville.description}</form:option>
                                                                    </c:if>
                                                            
                                                                    <c:if test="${ville.code !=client.getCodeville().getCode()}">
                                                                    <form:option value="${ville.code}"  >${ville.description}</form:option>
                                                                    </c:if>
                                                                    </c:forEach>
                                                                </form:select>
                                                        
                                                        </c:otherwise>
                                                </c:choose>    
                                             
                                               
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
                <!-- END PAGE CONTENT WRAPPER -->

<%@include file="dashf.jsp" %>