<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="model.Conta" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="model.Cliente" %>
     <% ArrayList<Conta> contas = (ArrayList<Conta>) request.getAttribute("contas"); %>
	 <% Cliente c = (Cliente) request.getAttribute("cliente"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco - Login Sucesso</title>
</head>
<body>
	<table border = "1">
	<caption> Cliente <%= c.getNomeCliente() %> (<%= c.getCpfCliente() %>)</caption>
		<tr>
			<th>Número da Conta</th>
		</tr>
		<% for(Conta a : contas){ %>
			<tr>
				<td><a href="detalharConta?id=<%= a.getIdConta() %>"><%= a.getNumeroConta() %></a></td>
			</tr>
		<% }%>
	</table>
</body>
</html>