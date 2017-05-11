<%-- 
    Document   : factureslist
    Created on : 4 mai 2017, 14:04:12
    Author     : ak47@minduos
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="dashh.jsp" %>
<ul class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li >Projets</li>
                    <li class="active">factures</li>
                </ul>
                <!-- END BREADCRUMB -->

                <!-- PAGE TITLE -->
                <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Factures</h2>
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
                                                    <th>Code</th>
                                                    <th>Code projet</th>
                                                    <th>num Facture</th>
                                                    <th>Date designation</th>
                                                    
                                                    <th>Montant hors tva</th>
                                                    <th>P% Tva</th>
                                                    <th>Montant TTC</th>
                                                    <th>Observations</th>
                                                    
                                                    <th>Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${not empty contrats}" >
                                                    <c:forEach items="${contrats}" var="contrat">
                                                <tr>
                                                    <td>${contrat.code}</td>
                                                    <td>${contrat.codeprojet.code}</td>
                                                    <td>${contrat.numfacture}</td>
                                                    <td>${contrat.datedesignation}</td>
                                                    
                                                    <td>${contrat.mthtva}</td>
                                                    <td>${contrat.ptva}</td>
                                                    <td>${contrat.mtttc}</td>
                                                    <td>${contrat.observation}</td>
                                                    
                                                    <td><c:if test="${empty contrat.liendoc}"><a href="<c:url value="/aj-doc-f-${contrat.code}"/>" class="btn btn-primary btn-sm btn-block">Ajouter document</a></c:if><c:if test="${not empty contrat.liendoc}"><a href="<c:url value="/view-doc-f-${contrat.code}-internal"/>" class="btn btn-primary btn-sm btn-block">Voir document</a><a href="<c:url value="/up-doc-f-${contrat.code}"/>" class="btn btn-default btn-sm btn-block">Modifier document</a></c:if><a href="<c:url value='/view-f-${contrat.code}' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/up-f-${contrat.code}' />" class="btn btn-warning btn-sm btn-block"> Modifier</a> <a href="<c:url value='/sup-f-${contrat.code}' />" class="btn btn-danger mb-control btn-sm btn-block" data-box="#message-box-danger-${contrat.code}">Supprimer</a></td>
                                                </tr>
                                                <div class="message-box message-box-danger animated fadeIn" id="message-box-danger-${contrat.code}">
                                            <div class="mb-container">
                                                <div class="mb-middle">
                                                <div class="mb-title"><span class="fa fa-times"></span> Danger</div>
                                                <div class="mb-content">
                                                    <p>Vous allez supprimer la facture définitivement. Continuez ?</p>
                                                </div>
                                                    <div class="mb-footer">
                                                        <a href="<c:url value='/sup-f-${contrat.code}' />" class="btn btn-success btn-lg">Oui</a>
                                                        <button class="btn btn-default btn-lg mb-control-close">Non</button>
                                                    </div>
                                                </div>
                                            </div>
                                            </div>
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
                        <center><a href="<c:url value='/add-f-${p}' />" class="btn btn-info btn-group-lg active" type="button">Ajouter Nouvelle Facture</a>	</center>
                    </div>		
                </div>
						
                    
                
<%@include file="dashf.jsp" %>

<%@include file="dashfe.jsp" %>