<%-- 
    Document   : viewmemoires
    Created on : 4 mai 2017, 14:01:18
    Author     : ak47@minduos
--%>
<%-- 
    Document   : Viewfactures
    Created on : 4 mai 2017, 14:00:50
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
                    <li class="active">contrat n° ${contrat.code}</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE CONTENT WRAPPER -->
                <span></span>
                <div class="page-content-wrap">
                <form:form method="POST" modelAttribute="contrat" class="form-horizontal myForm">
                    <div class="row">
                        <div class="col-md-12">
                            
                            
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>Memoire</strong></h3>
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
                                                
                                                <form:input type="hidden" path="code" id="code" />
                                                 <form:input type="hidden" path="codeprojet" id="codeprojet" value="${p}"/>
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                               <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Numero memoire</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="true" value="${contrat.nummemoire}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:input path="nummemoire" id="nummemoire" class="form-control" />
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
                                                            <textarea  class="form-control" rows="5" disabled="true">${contrat.observation}</textarea>
                                                        </c:when>
							<c:otherwise>
                                                        <form:textarea path="observation" id="observation" class="form-control" rows="5"  ></form:textarea>
                                                        </c:otherwise>
                                                </c:choose>                                            
                                            
                                            <span class="help-block">Default textarea field</span>
                                        </div>
                                    </div>
                                    
                                        
                                            
                                          
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">date signature</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="false" value="${contrat.datedesignation}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatDate value="${contrat.datedesignation}" var="dateStringds" pattern="dd-MM-yyyy" />
                                                            <form:input type="text" value="${dateStringds}" path="datedesignation" id="datedesignation" class="mask_date form-control" />
                                                        </c:otherwise>
                                                </c:choose>    
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="datedesignation" class="help-inline"/></div></span>
                                        </div>
                                     </div>
                                         
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Montant Hors TVA</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="<fmt:formatNumber type="number" groupingUsed="false" value="${contrat.mthtva}"/>"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatNumber type="number" groupingUsed="false" value="${contrat.mthtva}"  var="formMthtva"/>
                                                            <form:input type="text" path="mthtva" id="mthtva" value="${formMthtva}" class="form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="mthtva" class="help-inline"/></div></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Pourcentage TVA</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="<fmt:formatNumber type="number" groupingUsed="false" value="${contrat.mttva}"/>"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatNumber type="number" groupingUsed="false" value="${contrat.ptva}"  var="formMttva"/>
                                                            <form:input type="text" path="ptva" id="ptva" value="${formMttva}" class="mask_percent form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="ptva" class="help-inline"/></div></span>
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Montant TTC</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="<fmt:formatNumber type="number" groupingUsed="false" value="${contrat.mtttc}"/>"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatNumber type="number" groupingUsed="false" value="${contrat.mtttc}"  var="formmtttc"/>
                                                            <form:input type="text" path="mtttc" id="mtttc" value="${formmtttc}" class="form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="mtttc" class="help-inline"/></div></span>
                                        </div>
                                    </div>
                                                
                                <div class="panel-footer">
                                    <a href="<c:url value="/listm-${p}"/>" class="btn btn-default">Retour</a>  
                                    <c:if test="${type!=1}">
                                    <input type="submit" class="btn btn-primary pull-right" value="Enregistrer" />
                                    </c:if>
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
<script>
function calcule_ht_ttc(event) // fonction de calcul
{
	var prix_ht = $('input[name="mthtva"]').val();
	var taux_tva  = $('input[name="ptva"]').val();
	var prix_ttc = $('input[name="mtttc"]').val();
	
	if(event.target.name=='mtttc')
	{
		var new_prix_ht = (prix_ttc/(1+taux_tva/100)).toFixed(2);		
		$('input[name="mthtva"]').val(new_prix_ht);
	}
	else
	{
		var new_prix_ttc = (prix_ht*(1+taux_tva/100)).toFixed(2);		
		$('input[name="mtttc"]').val(new_prix_ttc);
	}	
}


$(function() // jQuery
{
	$('.myForm input').bind('keyup mouseup', calcule_ht_ttc); // appel de la fonction de calcul lors d'un événement 'keyup' ou 'mouseup'
});
</script>-->
<%@include file="dashfe.jsp" %>