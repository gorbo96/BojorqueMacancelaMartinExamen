<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.entidades.Telefono"%>
<%@page import="ec.edu.ups.dao.TelefonoDAO"%>
<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda Total</title>
</head>
<body>			
		<% List<Telefono> listNum = (List<Telefono>) DAOFactory.getFactory().getTelefonoDAO().findAll(); %>				
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
	    		out.println("<td class='tg-y698'>"+listNum.get(i).getUsuario().getCedula()+"</td><td class='tg-y698'>"+listNum.get(i).getUsuario().getNombres()+"</td><td" +
    					" class='tg-y698'>"+listNum.get(i).getUsuario().getApellidos()+"</td><td class='tg-y698'>"+listNum.get(i).getNumero()+"</td><td class='tg-y698'>"
    					+listNum.get(i).getTipo().getNombre()+"</td><td class='tg-y698'>"+listNum.get(i).getOperadora().getNombre());
	    		out.println("</tr>");
	    	}
	   
	    %>
</body>
</html>