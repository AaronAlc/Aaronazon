<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>

<html>
	<body>
		<t:headerfooter>

		<h2>Username: aaron</h2>
		<h2>Password: test</h2>

			<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<table>
				<tr>
					<td>
						<form:label path="userName">Username: </form:label>
					</td>
					<td>
						<form:input path="userName" name="userName" id="userName"></form:input>
					</td>
				</tr>
				<tr>
					<td><form:label path="password">Password: </form:label></td>
					<td><form:password path="password" name="password" id="password"></form:password></td>
				</tr>
				<tr>
					<td></td>
					<td align="left">
						<form:button id="login" name="login">Login</form:button>
					</td>
				</tr>
				
			</table>

			</form:form>
			<h2>${message}</h2>

		</t:headerfooter>
	</body>
</html>