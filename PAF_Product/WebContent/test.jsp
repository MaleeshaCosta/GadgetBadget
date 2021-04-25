<%@page import="model.Product"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if (request.getParameter("productCode") != null)  {   
	
	Product productObj = new Product(); 
 
  String stsMsg = productObj.insertProduct(request.getParameter("productCode"),      
		  request.getParameter("productName"),      
		  request.getParameter("productPrice"), 
		  request.getParameter("researcherName"), 
		  request.getParameter("productDesc")); 
 
  session.setAttribute("statusMsg", stsMsg);  
  }
if (request.getParameter("hidItemIDDelete") != null) { 
	
	Product productObj = new Product(); 
	   String stsMsg =                 
			   productObj.deleteProduct(request.getParameter("hidItemIDDelete")); 
	   session.setAttribute("statusMsg", stsMsg);
	   } 
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
   	out.print(session.getAttribute("statusMsg"));
   %>
    <br>
   <%
   	Product productObj = new Product(); 
         
         out.print(productObj.readProduct());
       //  out.print(productObj.deleteProduct(productID));
         
   %> 
</body>
</html>