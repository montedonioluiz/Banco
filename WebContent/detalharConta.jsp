<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="model.Conta" %>
     <% Conta c = (Conta) request.getAttribute("conta"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco - Login Sucesso</title>
</head>
<body>
	<table border = "1">
		<tr>
			<th>C�digo Conta</th>
			<th>C�digo Cliente</th>
			<th>N�mero da Conta</th>
			<th>Ag�ncia</th>
			<th>Tipo Conta</th>
		</tr>
			<tr>
				<td><%= c.getIdConta() %></td>
				<td><%= c.getIdCliente() %></td>
				<td><%= c.getNumeroConta() %></td>
				<td><%= c.getAgenciaConta() %></td>
				<td><%= c.getTipoConta() %></td>
			</tr>
	</table>
</body>
</html>