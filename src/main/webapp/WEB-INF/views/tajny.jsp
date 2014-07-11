<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<h2><c:out value="${text}" /></h2>

<h3>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<p>Jsi ADMIN</p>
	</security:authorize>	
</h3>

