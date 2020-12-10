<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.entidades.Usuario"%>
<%@page import="ec.edu.ups.entidades.Tipo"%>
<%@page import="ec.edu.ups.entidades.Operadora"%>
<%@page import="ec.edu.ups.entidades.Telefono"%>
<%@page import="ec.edu.ups.dao.UsuarioDAO"%>
<%@page import="ec.edu.ups.dao.TipoDAO"%>
<%@page import="ec.edu.ups.dao.OperadoraDAO"%>
<%@page import="ec.edu.ups.dao.TelefonoDAO"%>
<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%Usuario usu=(Usuario)request.getAttribute("usuario"); %>
<%int cantidad=Integer.parseInt((String)request.getAttribute("cantidad")); %>
<%List <Operadora> operadoras=DAOFactory.getFactory().getOperadoraDAO().findAll(); %>
<%List <Tipo> tipos=DAOFactory.getFactory().getTipoDAO().findAll(); %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso de Telefonos</title>
	<%out.println("<form action=/BojorqueMacancelaMartinExamen/GuardarTelfs method='post'>"); 
	out.println("<input type='hidden' name='numero' value="+cantidad+">");
	out.println("<input type='hidden' name='id' value="+usu.getId()+">"); 
	for(int i=0;i<cantidad;i++){
		out.println("<h1>Telefono"+(i+1)+"</h1>");
		out.println("<input name='tel"+i+"'type=text>");
		out.println("<select name='tipos"+i+"'>");
		for(Tipo t:tipos){
			out.println("<option value="+t.getId()+">"+t.getNombre()+"</option>");
		}
		out.println("</select>");
		out.println("<select name='operadoras"+i+"'>");
		for(Operadora o:operadoras){
			out.println("<option value="+o.getId()+">"+o.getNombre()+"</option>");
		}
		
		out.println("</select>");
				
	}
	out.println("<input type='submit' value='Aceptar'/>");
	out.println("<input type='reset' value='Cancelar'/>");
	out.println("</form>");
		%>
</head>
<body>

</body>
</html>