<%-- 
    Document   : projetslist
    Created on : 21 avr. 2017, 03:55:32
    Author     : ak47@minduos
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th>Office</th>
                                                    <th>Age</th>
                                                    <th>Start date</th>
                                                    <th>Salary</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Tiger Nixon</td>
                                                    <td>System Architect</td>
                                                    <td>Edinburgh</td>
                                                    <td>61</td>
                                                    <td>2011/04/25</td>
                                                    <td>$320,800</td>
                                                </tr>
												<tr>
                                                    <td>adza</td>
                                                    <td>System Architect</td>
                                                    <td>Edinburgh</td>
                                                    <td>61</td>
                                                    <td>2011/04/25</td>
                                                    <td>$320,800</td>
                                                </tr>
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- END DEFAULT DATATABLE -->

                          <div class="panel panel-default">
						  <div class="panel-heading">
                                    <h3 class="panel-title">Recherche simple</h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span></a></li>
                                        <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>                                
                          </div>
                                <div class="panel-body">                                    
                                    <div class="row stacked">
									
                                        <div class="col-md-6">
                                            <div class="input-group push-down-10">
                                                <span class="input-group-addon"><span class="fa fa-search"></span></span>
                                                <input type="text" class="form-control" placeholder="Recherche simple par..." />
                                                <div class="input-group-btn">
                                                    <button class="btn btn-primary">Recherche simple</button>
                                                </div>
                                            </div>                                                                
                                            
                                            <span class="line-height-30" hidden="true">résultats trouvés pour<strong></strong> $ resultats</span>
                                        </div>
                                        <div class="col-md-6">
                                           
                                            <div class="pull-right push-down-10">
                                                <div class="form-group">
                                            <label class="radio-material">
                                                <input id="radio1" type="radio" name="radios" checked>
                                                <span class="outer"><span class="inner"></span></span> Client
                                            </label>                                            
                                            <label class="radio-material">
                                                <input id="radio2" type="radio" name="radios">
                                                <span class="outer"><span class="inner"></span></span> Ville
                                            </label>
                                        </div>            
                                        </div>
                                            </div>
                                                                                    
                                        </div>
                                    </div>
                                <div class="panel-heading">
                                    <h3 class="panel-title">Recherche par date</h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span></a></li>
                                        <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>                                
                                </div>
                                <div class="panel-body">                                    
                                    <div class="row stacked">
                                        
                                            <div class="input-group push-down-10">
                                                <span class="input-group-addon"><span class="fa fa-search"></span></span>
                                                <div class="col-md-6">
                                                <div class="input-group">
                                                    <input type="text" class="mask-date form-control datepicker" >
                                                    <span class="input-group-addon add-on"> - </span>
                                                    <input type="text" class="mask-date form-control datepicker" >
													<div class="input-group-btn">
                                                    <button class="btn btn-primary">Recherche avancé par date</button>
                                                </div>
                                                </div>
												
												</div>
                                                
												
                                            </div>                                                                
                                            
                                            <span class="line-height-30" hidden="true">résultats trouvés pour<strong></strong> $ resultats</span>
                                        </div>
                                        
                                    </div>
                                </div>                                                                
                            </div>
					                                             
                            </div>

                        </div>
						
                    </div>
						
                    
                </div>
<%@include file="dashf.jsp" %>				