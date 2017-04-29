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
                    <li class="active">Projets</li>
                </ul>
                <!-- END BREADCRUMB -->

                <!-- PAGE TITLE -->
                <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Sortable Tables</h2>
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
                                                    <th>code</th>
                                                    <th>code client</th>
                                                    <th>adresse</th>
                                                    <th>description</th>
                                                    <th>date debut</th>
                                                    <th>date fin</th>
                                                    <th>personne a contacter</th>
                                                    <th>num tel</th>
                                                    <th>maitre d'ouvrage</th>
                                                    <th>montant travaux</th>
                                                    <th>actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${not empty projetpu}" >
                                                    <c:forEach items="${projetpu}" var="projet">
                                                <tr>
                                                    <td>PU ${projet.getProjetPK().getAnnee()} / ${projet.getProjetPK().getCode()}</td>
                                                    <td>${projet.codeclient.getCode()}</td>
                                                    <td>${projet.adresse}</td>
                                                    <td>${projet.description}</td>
                                                    <td>${projet.datedebut}</td>
                                                    <td>${projet.datefin}</td>
                                                    <td>${projet.personneacontacter}</td>
                                                    <td>${projet.numtel}</td>
                                                    <td>${projet.maitreouvrage}</td>
                                                    <td>${projet.montatnttravaux}</td>
                                                    <td><a href="<c:url value='/viewpu-projet-${projet.getProjetPK().getAnnee()}-${projet.getProjetPK().getCode()}' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/uppu-projet-${projet.getProjetPK().getAnnee()}-${projet.getProjetPK().getCode()}' />" class="btn btn-warning btn-sm btn-block">Modifier</a> <a href="<c:url value='/suppu-projet-${projet.getProjetPK().getAnnee()}-${projet.getProjetPK().getCode()}' />" class="btn btn-danger btn-sm btn-block">Supprimer</a></td>
                                                </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${not empty projetpr}" >
                                                    <c:forEach items="${projetpr}" var="projet">
                                                <tr>
                                                    <td>PR ${projet.getProjetPK().getAnnee()} / ${projet.getProjetPK().getCode()}</td>
                                                    <td>${projet.codeclient.getCode()}</td>
                                                    <td>${projet.adresse}</td>
                                                    <td>${projet.description}</td>
                                                    <td>${projet.datedebut}</td>
                                                    <td>${projet.datefin}</td>
                                                    <td>${projet.personneacontacter}</td>
                                                    <td>${projet.numtel}</td>
                                                    <td>${projet.maitreouvrage}</td>
                                                    <td><fmt:formatNumber type="number" groupingUsed="false" value="${projet.montatnttravaux}" /></td>
                                                    <td><a href="<c:url value='/viewpr-projet-${projet.getProjetPK().getAnnee()}-${projet.getProjetPK().getCode()}' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/uppr-projet-${projet.getProjetPK().getAnnee()}-${projet.getProjetPK().getCode()}' />" class="btn btn-warning btn-sm btn-block">Modifier</a> <a href="<c:url value='/suppr-projet-${projet.getProjetPK().getAnnee()}-${projet.getProjetPK().getCode()}' />" class="btn btn-danger btn-sm btn-block">Supprimer</a></td>
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