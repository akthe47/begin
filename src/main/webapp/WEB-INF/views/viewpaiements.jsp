<%-- 
    Document   : viewpaiements
    Created on : 4 mai 2017, 14:01:45
    Author     : ak47@minduos
--%>

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
                    <li class="active">contrat n° </li>
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
                                    <h3 class="panel-title"><strong>Paiement ${ble} ${ble1} </strong></h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>
                                </div>
                                
                                <div class="panel-body">                                                                        
                                   
                                    
                                               <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Numero Paiement</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1||type==2}">
                                                        <input type="text" class="form-control"  disabled="true" value="${contrat.numpaiement}"/>
                                                        <form:input type="hidden" path="numpaiement" id="numpaiement" class="form-control" />
                                                        </c:when>
							<c:otherwise>
                                                            <form:input type="hidden" path="numpaiement" id="numpaiement" class="form-control" />
                                                        </c:otherwise>
                                                </c:choose>    
                                                        
                                            </div>                                            
                                            <span class="help-block">This is sample of text field</span>
                                        </div>
                                    </div>
                                    
                                                
                                                                    <div class="form-group">
                                                                        <label class="col-md-3 col-xs-12 control-label">Factures/Memoires</label>
                                                                            <div class="col-md-6 col-xs-12">
                                                                                <c:if test="${h==1}">
                                                        <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="true" value="${contrat.codemem.getCode()}|${contrat.codemem.getMtttc()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:select path="codemem" id="codemem" class="form-control" name="mode">
                                                                    <c:forEach var="ville" items="${mems}">
                                                                    
                                                                    <c:if test="${ville.code ==contrat.codemem.getCode()}">
                                                                    <form:option value="${ville.code}"  selected="selected">${ville.code}|<fmt:formatNumber type="number" groupingUsed="false" value="${ville.mtttc}" /></form:option>
                                                                    </c:if>
                                                            
                                                                    <c:if test="${ville.code !=contrat.codemem.getCode()}">
                                                                    <form:option value="${ville.code}"  >${ville.code}|<fmt:formatNumber type="number" groupingUsed="false" value="${ville.mtttc}" /></form:option>
                                                                    </c:if>
                                                                    </c:forEach>
                                                                </form:select>
                                                        </c:otherwise>
                                                        </c:choose>
                                                                    </c:if>
                                                                    <c:if test="${h==2}">
                                                        <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="true" value="${contrat.codefact.getCode()}|${contrat.codefact.getMtttc()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:select path="codemem" id="codemem" class="form-control" name="mode">
                                                                    <c:forEach var="ville" items="${facts}">
                                                                    
                                                                    <c:if test="${ville.code ==contrat.codefact.getCode()}">
                                                                    <form:option value="${ville.code}"  selected="selected">${ville.code}|<fmt:formatNumber type="number" groupingUsed="false" value="${ville.mtttc}" /></form:option>
                                                                    </c:if>
                                                            
                                                                    <c:if test="${ville.code !=contrat.codefact.getCode()}">
                                                                    <form:option value="${ville.code}"  >${ville.code}|<fmt:formatNumber type="number" groupingUsed="false" value="${ville.mtttc}" /></form:option>
                                                                    </c:if>
                                                                    </c:forEach>
                                                                </form:select>
                                                        </c:otherwise>
                                                        </c:choose>
                                                                    </c:if>                                            
                                            
                                                                            <span class="help-block"><div class="has-error">
                                                                                    <form:errors path="mttc" class="help-inline"/></div></span>
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
                                        <label class="col-md-3 col-xs-12 control-label">date Reception</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="false" value="${contrat.datereception}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatDate value="${contrat.datereception}" var="dateStringds" pattern="dd-MM-yyyy" />
                                                            <form:input type="text" value="${dateStringds}" path="datereception" id="datereception" class="mask_date form-control" />
                                                        </c:otherwise>
                                                </c:choose>    
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="datereception" class="help-inline"/></div></span>
                                        </div>
                                     </div>
                                         
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Montant TTC</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text"  class="form-control"  disabled="true"  value="<fmt:formatNumber type="number" groupingUsed="false" value="${contrat.mttc}"/>"/>
                                                        </c:when>
							<c:otherwise>
                                                            <fmt:formatNumber type="number" groupingUsed="false" value="${contrat.mttc}"  var="formMthtva"/>
                                                            <form:input type="text" path="mttc" id="mttc" value="${formMthtva}" class="form-control" />
                                                        </c:otherwise>
                                                </c:choose>
                                                
                                            </div>                                            
                                            <span class="help-block"><div class="has-error">
                                                    <form:errors path="mttc" class="help-inline"/></div></span>
                                        </div>
                                    </div>
                                   
                                                
                                                 <div class="form-group">
                                        <label class="col-md-3 col-xs-12 control-label">Mode de paiement</label>
                                        <div class="col-md-6 col-xs-12">                                            
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                 <c:choose>
							<c:when test="${type==1}">
                                                        <input type="text" class="form-control"  disabled="true" value="${contrat.mode.getLibelle()}"/>
                                                        </c:when>
							<c:otherwise>
                                                            <form:select path="mode" id="mode" class="form-control" name="mode">
                                                                    <c:forEach var="ville" items="${villes}">
                                                                    
                                                                    <c:if test="${ville.code ==contrat.mode.getCode()}">
                                                                    <form:option value="${ville.code}"  selected="selected">${ville.libelle}</form:option>
                                                                    </c:if>
                                                            
                                                                    <c:if test="${ville.code !=contrat.mode.getCode()}">
                                                                    <form:option value="${ville.code}"  >${ville.libelle}</form:option>
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
                                    <a href="<c:url value="/listpay"/>" class="btn btn-default">Retour</a>     
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