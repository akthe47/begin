<%-- 
    Document   : documentslist
    Created on : 29 avr. 2017, 12:18:38
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
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Tables Documents</h2>
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
                                                    <th>description</th>
                                                    <th>Typedocument</th>
                                                    <th>actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${not empty docs}" >
                                                    <c:forEach items="${docs}" var="doc">
                                                        <tr>
                                                            
                                                            <td>${doc.code}</td>
                                                            <td>${doc.description}</td>
                                                            <td>${doc.type.getDescription()}</td>
                                                            <td><c:if test="${not empty doc.ext}"><a href="<c:url value='/download/doc/${doc.code}/internal' />" class="btn btn-success btn-sm btn-block">Consulter</a> <a href="<c:url value='/up-doc-${doc.ext}' />" class="btn btn-warning btn-sm btn-block">Modifier</a></c:if><c:if test="${empty doc.ext}"><a href="<c:url value='/singleUpload-${doc.code}-doc' />" class="btn btn-primary btn-sm btn-block">Ajouter Document</a></c:if> <a href="<c:url value='/sup-doc-${doc.code}' />" class="btn btn-danger btn-sm btn-block">Supprimer</a></td>
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
                    <center><a href="<c:url value='/add-doc-${result}' />" class="btn btn-info btn-group-lg active" type="button">Ajouter Nouveau Document</a>	</center>
						
                </div>
						
                    
                
<%@include file="dashf.jsp" %>	
<%@include file="dashfe.jsp" %>