<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AccessDenied page</title>
</head>
<body>
	<div class="page-container">
            <div <!--class=""--> >
			<span>M(Me). <strong>${loggedinuser}</strong>, Vous n'êtes pas authorisé a voir le contenu de cette page.</span> <span class="floatRight"><a href="<c:url value="/logout" />">Se déconnecter</a></span>
		</div>
                
                <img class="page-content" src="<c:url value='/img/better-accessed-denied-01.png' />" />
	</div>
</body>
</html>