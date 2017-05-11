<%-- 
    Document   : viewdocument
    Created on : 9 mai 2017, 13:12:03
    Author     : ak47@minduos
--%>
<%-- 
    Document   : viewcontrats
    Created on : 4 mai 2017, 13:59:58
    Author     : ak47@minduos
--%>

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
                    <li><a href="#">Client</a></li>
                    <li><a href="#">Consulter</a></li>
                    <li class="active">contrat n°</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE CONTENT WRAPPER -->
                <span></span>
                <div class="page-content-wrap">
                <form:form method="POST" modelAttribute="document" class="form-horizontal">
                    <div class="row">
                        <div class="col-md-12">
                            
                            
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>Contrat</strong></h3>
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
                                                <c:if test="${type==1||type==3}">
                                                <form:input type="number" path="code" id="code" class="form-control"  disabled="true"  />
                                                
                                                </c:if>
                                                
                                                <form:input type="hidden" path="code" id="code" class="form-control"/>
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                                                                                                     
                                   
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">code</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-ban"></span></span>
                                                <c:if test="${type==1||type==3}">
                                                <form:input type="number" path="codeprojet" id="codeprojet" class="form-control"  disabled="true"  />
                                                
                                                </c:if>
                                                
                                                <form:input type="hidden" path="codeprojet" id="codeprojet" value="${codepr}"/>
                                                <form:input type="hidden" path="path" id="path"/>
                                                <form:input type="hidden" path="ext" id="ext"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                               <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Numero document</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="true" value="${doc.num}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input path="num" id="num" class="form-control" value="${numdoc}"/>
                                                        </c:otherwise>
                                                </c:choose>    
                                                
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                                
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Observations</label>
                                        <div class="col-md-6 col-xs-12">
                                                <c:choose>
							<c:when test="${type==1}">
                                                            <textarea  class="form-control" rows="5" disabled="true">${doc.description}</textarea>
                                                        </c:when>
							<c:otherwise>
                                                        <form:textarea path="description" id="description" class="form-control" rows="5"  ></form:textarea>
                                                        </c:otherwise>
                                                </c:choose>                                            
                                            
                                            <span class="help-block">Default textarea field</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Type document</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                            <form:select path="type" id="type" class="form-control" name="type" disabled="true">
                                                                    <c:forEach var="ville" items="${villes}">
                                                            <c:if test="${ville.code ==doc.type.getCode()}">
                                                                    <form:option value="${ville.code}"  selected="selected">${ville.description}</form:option>
                                                                    </c:if>
                                                            
                                                                    <c:if test="${ville.code !=doc.type.getCode()}">
                                                                    <form:option value="${ville.code}"  >${ville.description}</form:option>
                                                                    </c:if>
                                                                    </c:forEach>
                                                                </form:select>
                                                        </c:when>
							<c:otherwise>
                                                                <form:select path="type" id="type" class="form-control" name="type">
                                                                    <c:forEach var="ville" items="${villes}">
                                                                    
                                                                    <c:if test="${ville.code ==doc.type.getCode()}">
                                                                    <form:option value="${ville.code}"  selected="selected">${ville.description}</form:option>
                                                                    </c:if>
                                                            
                                                                    <c:if test="${ville.code !=doc.type.getCode()}">
                                                                    <form:option value="${ville.code}"  >${ville.description}</form:option>
                                                                    </c:if>
                                                                    </c:forEach>
                                                                </form:select>
                                                        
                                                        </c:otherwise>
                                                </c:choose>    
                                             
                                               
                                    </div>                                            
                                            <span class="help-block">Choisir un type</span>
                                        </div>
                                    </div> 
                                        
                                <div class="panel-footer">
                                    <button class="btn btn-default">Retour</button>     
                                    <input type="submit" class="btn btn-primary pull-right" value="Enregistrer Et Ajouter Document" />
                                </div>
                                
                            </div>
                            
                            
                        </div>
                           
                    </div>                    
                    
                </div>
                   </form:form>                      
                <!-- END PAGE CONTENT WRAPPER -->
                </div>
<%@include file="dashf.jsp" %>
<!--<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script> 
<script >

</script>-->
<%@include file="dashfe.jsp" %>