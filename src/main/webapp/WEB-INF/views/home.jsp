<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page session="false" %>

<div class=loginStatus>
	<security:authorize access="isAuthenticated()">
		<a href="<c:url value="/logout" />" >Odhlasit</a>        	
	</security:authorize>
    	
	<security:authorize access="isAnonymous()">
		<a href="<c:url value="/login" />" >Prihlasit</a> 	
	</security:authorize>
</div>

<a href='<c:url value="/tajny" />'>Tajny controller</a>
<br>
<a href='<c:url value="/tajny/admin" />'>Tajny controller - admin</a>
<br>

<p> Jmeno role 1: <strong>${role.name}</strong>. </p>

<div>
	<table border="1">
	<tr>
		<th>id</th>
		<th>Jmeno</th>
		<th>JSON</th>
	</tr>
	<c:forEach var="role" items="${vsechnyRole}">
	<tr>
		<td><c:out value="${role.id}" /></td>
		<td><c:out value="${role.name}" /></td>
		<td>
			<a href='<c:url value="/role/getById/${role.id}" />'>JSON</a>
		</td>
	</tr>
	</c:forEach>	
	</table>
	<a href='<c:url value="/role/all" />'>JSON vsech roli</a>
</div>
