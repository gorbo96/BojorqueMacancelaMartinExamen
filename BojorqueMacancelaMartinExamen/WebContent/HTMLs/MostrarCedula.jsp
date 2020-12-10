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
<title>Busqueda por Cedula</title>
</head>
<body>
	<c:set var="p" scope="request" value="${bcedula}" />
		<% Usuario list = (Usuario) request.getAttribute("bcedula"); %>
		<% List<Telefono> listNum = (List<Telefono>) request.getAttribute("btelefonos"); %>				
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
	    	for(int i=0;i<listNum.size();i++){
	    		out.println("<tr>");
	    		out.println("<td class='tg-y698'>"+list.getCedula()+"</td><td class='tg-y698'>"+list.getNombres()+"</td><td" +
    					" class='tg-y698'>"+list.getApellidos()+"</td><td class='tg-y698'>"+listNum.get(i).getNumero()+"</td><td class='tg-y698'>"
    					+listNum.get(i).getTipo().getNombre()+"</td><td class='tg-y698'>"+listNum.get(i).getOperadora().getNombre());
	    		out.println("</tr>");
	    	}
	   
	    %>
</body>
</html>