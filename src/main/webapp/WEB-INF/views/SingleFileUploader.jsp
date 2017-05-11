<%-- 
    Document   : SingleFileUploader
    Created on : 30 avr. 2017, 19:17:26
    Author     : ak47@minduos
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <%@include file="dashh.jsp" %>

    <div class="form-container">
        <h1>Spring 4 MVC File Upload Example </h1>
        <!---->
        <form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal" action="/singleUpload-${id}-doc?${_csrf.parameterName}=${_csrf.token}">
         
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="file">Upload a file</label>
                    <div class="col-md-7">
                        <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="file" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
                        
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>
        </form:form>
        <a href="<c:url value='/welcome' />">Home</a>
    </div>
<%@include file="dashf.jsp" %>
<%@include file="dashfe.jsp" %>
