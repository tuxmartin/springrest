<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>
	Login
</h1>


<div class="login">
    <form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
        <h2>Přihlásit se</h2>
	<c:if test="${not empty error}">
		<div class="error">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>        
        <label for="username">Přihlašovací jméno</label>
        <input type='text' name='j_username' value='' placeholder="zadejte jméno...">
        <label for="password">Heslo</label>
        <input type='password' name='j_password' id="password" placeholder="zadejte heslo...">
        <button type="submit">Přihlásit se</button>
    </form>                    
</div>
