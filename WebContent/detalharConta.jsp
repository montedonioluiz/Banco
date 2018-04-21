<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="model.Conta" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="model.Transacao" %>
     
     <% Conta c = (Conta) request.getAttribute("conta"); %>
     <% ArrayList<Transacao> ts = (ArrayList<Transacao>) request.getAttribute("transacoes"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco - Login Sucesso</title>
</head>
<body>
	<h1>Detalhes da Conta</h1>
	<table border = "1">
		<tr>
			<th>Código Conta</th>
			<th>Código Cliente</th>
			<th>Número da Conta</th>
			<th>Agência</th>
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
	<h2>Extrato</h2>
	<table>
		<tr>
			<th>Código da Transação</th>
			<th>Data</th>
			<th>Tipo</th>
			<th>Valor</th>
		</tr>
		<% for(Transacao t : ts){ %>
			<tr>
				<td><%= t.getIdTransacao() %></td>
				<td><%= t.getDataTransacao() %></td>
				<% if(t.getTipoTransacao().equals("C")){ %>
					<td bgcolor="red"><%= t.getTipoTransacao() %></td>
					<td bgcolor="red"><%= t.getValorTransacao() %></td>
				<%} else{%>
					<td bgcolor="green"><%= t.getTipoTransacao() %></td>
					<td bgcolor="green"><%= t.getValorTransacao() %></td>
				<%} %>
			</tr>
		<% } %>
		<tr> <td>Saldo = <%= request.getAttribute("saldo") %></td></tr>
	</table>
</body>
</html>