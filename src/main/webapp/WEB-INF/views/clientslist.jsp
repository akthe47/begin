<%-- 
    Document   : clientslist
    Created on : 10 avr. 2017, 13:52:56
    Author     : ak47@minduos
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="dashh.jsp" %>
<!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Clients</li>
                </ul>
                <!-- END BREADCRUMB -->

                <!-- PAGE TITLE -->
                <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Clients </h2>
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
                                                    <th width="20">Code</th>
                                                    <th>Nom (Raison sociale)</th>
                                                    <th >CIN(MF)</th>
                                                    <th width="200">adresse</th>
                                                    <th>Mail</th>
                                                    <th>Ville</th>
                                                    <th width="300">actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${not empty cl}" >
                                                    <c:forEach items="${cl}" var="client">
                                            <tr>
						<td>${client.getCode()}</td>
                                                <td>${client.nom} ${client.prenom}</td>
                                                <td>${client.cin}</td>
						<td>${client.getAdresse()}</td>
						<td>${client.getMail()}</td>
						<td>${client.getCodeville().getDescription()}</td>
                                                <td><a href="<c:url value='/viewp-client-${client.getCode()}' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/upp-client-${client.getCode()}' />" class="btn btn-warning btn-sm btn-block">Modifier</a> <a href="<c:url value='/supp-client-${client.getCode()}' />" class="btn btn-danger mb-control btn-sm btn-block" data-box="#message-box-danger-${client.getCode()}">Supprimer</a></td>
                                            </tr>
                                            <div class="message-box message-box-danger animated fadeIn" id="message-box-danger-${client.getCode()}">
                                            <div class="mb-container">
                                                <div class="mb-middle">
                                                <div class="mb-title"><span class="fa fa-times"></span> Danger</div>
                                                <div class="mb-content">
                                                    <p>Vous allez supprimer le client définitivement. Continuez ?</p>
                                                </div>
                                                    <div class="mb-footer">
                                                        <a href="<c:url value='/supp-client-${client.getCode()}' />" class="btn btn-success btn-lg">Oui</a>
                                                        <button class="btn btn-default btn-lg mb-control-close">Non</button>
                                                    </div>
                                                </div>
                                            </div>
                                            </div>
                                                </c:forEach>
                                                </c:if>
                                            <c:if test="${not empty clp}" >
                                                    <c:forEach items="${clp}" var="client">
                                            <tr>
						<td>${client.getCode()}</td>
                                                <td>${client.nom} </td>
                                                <td> </td>
						<td>${client.getAdresse()}</td>
						<td>${client.getMail()}</td>
						<td>${client.getCodeville().getDescription()}</td>
                                                <td><a href="<c:url value='/viewpu-client-${client.getCode()}' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/uppu-client-${client.getCode()}' />" class="btn btn-warning btn-sm btn-block"> Modifier</a> <a href="<c:url value='/suppu-client-${client.getCode()}' />" class="btn btn-danger mb-control btn-sm btn-block" data-box="#message-box-danger-${client.getCode()}">Supprimer</a></td>
                                            </tr>
                                            <div class="message-box message-box-danger animated fadeIn" id="message-box-danger-${client.getCode()}">
                                            <div class="mb-container">
                                                <div class="mb-middle">
                                                <div class="mb-title"><span class="fa fa-times"></span> Danger</div>
                                                <div class="mb-content">
                                                    <p>Vous allez supprimer le client définitivement. Continuez ?</p>
                                                </div>
                                                    <div class="mb-footer">
                                                        <a href="<c:url value='/suppu-client-${client.getCode()}' />" class="btn btn-success btn-lg">Oui</a>
                                                        <button class="btn btn-default btn-lg mb-control-close">Non</button>
                                                    </div>
                                                </div>
                                            </div>
                                            </div>
                                                </c:forEach>
                                                </c:if>
                                            <c:if test="${not empty cls}" >
                                                    <c:forEach items="${cls}" var="client">
                                            <tr>
						<td>${client.getCode()}</td>
                                                <td>${client.raisonSociale} </td>
                                                <td>${client.matricule}</td>
						<td>${client.getAdresse()}</td>
						<td>${client.getMail()}</td>
						<td>${client.getCodeville().getDescription()}</td>
                                                <td><a href="<c:url value='/views-client-${client.getCode()}' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/ups-client-${client.getCode()}' />" class="btn btn-warning btn-sm btn-block"> Modifier</a> <a href="<c:url value='/sups-client-${client.getCode()}' />" class="btn btn-danger mb-control btn-sm btn-block" data-box="#message-box-danger-${client.getCode()}">Supprimer</a></td>
                                            </tr>
                                            <div class="message-box message-box-danger animated fadeIn" id="message-box-danger-${client.getCode()}">
                                            <div class="mb-container">
                                                <div class="mb-middle">
                                                <div class="mb-title"><span class="fa fa-times"></span> Danger</div>
                                                <div class="mb-content">
                                                    <p>Vous allez supprimer le client définitivement. Continuez ?</p>
                                                </div>
                                                    <div class="mb-footer">
                                                        <a href="<c:url value='/sups-client-${client.getCode()}' />" class="btn btn-success btn-lg">Oui</a>
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
                        
                        <center><a href="<c:url value='/addpu-client' />" class="btn btn-info btn-group-lg active" type="button">Ajouter Nouveau Client Public</a> <a href="<c:url value='/addp-client' />" class="btn btn-info btn-group-lg active" type="button">Ajouter Nouveau Client Privé</a> <a href="<c:url value='/adds-client' />" class="btn btn-info btn-group-lg active" type="button">Ajouter Nouveau Client Societé</a></center>
                        <center><a href="<c:url value='/impclients' />" class="btn btn-primary btn-group-lg active" type="button">imp</a></center>
                    </div>
                    
                </div>
                
<%@include file="dashf.jsp" %>
<c:if test="${param.opf != null}">
                               <script>noty({text: 'suppression n''est pas valide, layout: 'topCenter'});</script>
							</c:if>
                               <c:if test="${param.supp != null}">
                               <script>noty({text: 'suppression confirmée', layout: 'topCenter'});</script>
							</c:if>
<%@include file="dashfe.jsp" %>