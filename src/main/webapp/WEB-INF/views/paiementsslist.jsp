<%-- 
    Document   : paiementsslist
    Created on : 4 mai 2017, 14:04:30
    Author     : ak47@minduos
--%>

<%-- 
    Document   : projetslist
    Created on : 21 avr. 2017, 03:55:32
    Author     : ak47@minduos
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="dashh.jsp" %>
<ul class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Paiements</li>
                </ul>
                <!-- END BREADCRUMB -->

                <!-- PAGE TITLE -->
                <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Paiements</h2>
                </div>
                <!-- END PAGE TITLE -->                

                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">                
                
                    <div class="row">
                        <div class="col-md-12">

                            <!-- START DEFAULT DATATABLE -->
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table id="example" class="table datatable table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Numero Paiement</th>
                                                    <th>code memoire</th>
                                                    <th>code Facture</th>
                                                    <th>mode de paiement</th>
                                                    <th>date reception</th>
                                                    <th>mtttc</th>
                                                    <th>observation</th>
                                                    <th>doc</th>
                                                    <th>actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${not empty pays}" >
                                                    <c:forEach items="${pays}" var="pay">
                                                <tr>
                                                    <td>${pay.getNumpaiement()}</td>
                                                    <td>${pay.codemem.getCode()} </td>
                                                    <td>${pay.codefact.getCode()}</td>
                                                    <td>${pay.mode.getLibelle()}</td>
                                                    <td>${pay.datereception}</td>
                                                    <td><fmt:formatNumber type="number" groupingUsed="false" value="${pay.mttc}"/></td>
                                                    <td>${pay.observation}</td>
                                                    <td>${pay.liendoc}</td>
                                                    
                                                    <td><c:if test="${empty pay.liendoc}"><a href="<c:url value="/aj-doc-p-${pay.numpaiement}"/>" class="btn btn-primary btn-sm btn-block">Ajouter document</a></c:if><c:if test="${not empty pay.liendoc}"><a href="<c:url value="/view-doc-p-${pay.numpaiement}-internal"/>" class="btn btn-primary btn-sm btn-block">Voir document</a></c:if><a href="<c:url value='/view-p-${pay.getNumpaiement()}' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/up-p-${pay.getNumpaiement()}' />" class="btn btn-warning btn-sm btn-block">Modifier</a> <a href="<c:url value='/sup-p-${pay.getNumpaiement()}' />" class="btn btn-danger btn-sm btn-block">Supprimer</a></td>
                                                </tr>
                                                    </c:forEach>
                                                </c:if>
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- END DEFAULT DATATABLE -->

                          
					                                             
                            </div>
                        
                        
                        </div>
				<div class="row">
                         
                            <center><a href="<c:url value='/add-p-m' />" class="btn btn-info btn-group-lg active" type="button">Ajouter Nouveau Paiement pour une mémoire</a> <a href="<c:url value='/add-p-f' />" class="btn btn-info btn-group-lg active" type="button">Ajouter Nouveau Paiement pour une facture</a></center>
                            
                            
                        </div>		
                </div>
						
                    
                
<%@include file="dashf.jsp" %>
<%@include file="dashfe.jsp" %>