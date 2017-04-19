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
                                                <td><a href="<c:url value='/viewp-client-${client.getCode()}' />" class="btn btn-success">Consulter</a> <a href="<c:url value='/view-client-${client.getCode()}' />" class="btn btn-warning">Modifier</a> <a href="<c:url value='/sp-client-${client.getCode()}' />" class="btn btn-danger">Supprimer</a></td>
                                            </tr>
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
                                                <td><a href="<c:url value='/view-clientpu-${client.getCode()}' />" class="btn btn-success">Consulter</a> <a href="<c:url value='/view-client-${client.getCode()}' />" class="btn btn-warning">Modifier</a> <a href="<c:url value='/sp-client-${client.getCode()}' />" class="btn btn-danger">Supprimer</a></td>
                                            </tr>
                                                </c:forEach>
                                                </c:if>
                                            <c:if test="${not empty cls}" >
                                                    <c:forEach items="${clp}" var="client">
                                            <tr>
						<td>${client.getCode()}</td>
                                                <td>${client.raisonsociale} </td>
                                                <td>${client.matricule}</td>
						<td>${client.getAdresse()}</td>
						<td>${client.getMail()}</td>
						<td>${client.getCodeville().getDescription()}</td>
                                                <td><a href="<c:url value='/view-clients-${client.getCode()}' />" class="btn btn-success">Consulter</a> <a href="<c:url value='/view-client-${client.getCode()}' />" class="btn btn-warning">Modifier</a> <a href="<c:url value='/sp-client-${client.getCode()}' />" class="btn btn-danger">Supprimer</a></td>
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
                    
                </div>
<%@include file="dashf.jsp" %>