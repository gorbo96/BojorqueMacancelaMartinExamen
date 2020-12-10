<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.entidades.Usuario"%>
<%@page import="ec.edu.ups.entidades.Telefono"%>
<%@page import="ec.edu.ups.entidades.Operadora"%>
<%@page import="ec.edu.ups.entidades.Tipo"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda por Telefono</title>
</head>
<body>		
		<% Telefono listNum = (Telefono) request.getAttribute("btelefonos"); %>				
		<% PrintWriter out2= response.getWriter();%>
		<table class='tg' style='width:95%'>
	    <tr>
	        <th class='tg-46ru'>Cedula</th>
	        <th class='tg-46ru'>Nombres</th>
	        <th class='tg-46ru'>Apellidos</th>
	        <th class='tg-46ru'>Numero</th>
	        <th class='tg-46ru'>Tipo</th>
	        <th class='tg-46ru'>Operadora</th>	        
	    </tr>
	    <%		    		    	
	    	
	    		out.println("<tr>");
	    		out.println("<td class='tg-y698'>"+listNum.getUsuario().getCedula()+"</td><td class='tg-y698'>"+listNum.getUsuario().getNombres()+"</td><td" +
    					" class='tg-y698'>"+listNum.getUsuario().getApellidos()+"</td><td class='tg-y698'>"+listNum.getNumero()+"</td><td class='tg-y698'>"
    					+listNum.getTipo().getNombre()+"</td><td class='tg-y698'>"+listNum.getOperadora().getNombre());
	    		out.println("</tr>");
	    	
	   
	    %>
</body>
</html>