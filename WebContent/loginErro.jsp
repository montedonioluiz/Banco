<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="model.Cliente" %>
    
    <% Cliente c = (Cliente) request.getAttribute("cliente"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco - Login Erro</title>
</head>
<body>
	<h1> Deu erro. Tente Novamente.</h1>
	<form action="login">
		CPF: <input type="text" name = "cpfcliente"><br>
		Senha: <input type="password" name= "senhacliente"><br>
		<input type="submit" value="Acessar">
	</form>
</body>
</html>