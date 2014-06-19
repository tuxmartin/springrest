<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

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

</body>
</html>
