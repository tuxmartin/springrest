<!DOCTYPE HTML>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
		<title>
			<tiles:insertAttribute name="title" ignore="true" />
			<c:if test="${not empty pageTitle}">
				<c:out value="${pageTitle}"></c:out>
			</c:if>
		</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />

    </head>
    <body>

        <div id="main">
            <tiles:insertAttribute name="body" />  
        </div>
       
    </body>
</html>