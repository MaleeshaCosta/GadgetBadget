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
if (request.getParameter("productCode") != null) { 
	Product productObj = new Product();  
	String stsMsg = ""; 

//Insert--------------------------  
if (request.getParameter("hidItemIDSave") == "")  {   
	stsMsg = productObj.insertProduct(request.getParameter("itemCode"),      
			 request.getParameter("productName"),      
			  request.getParameter("productPrice"), 
			  request.getParameter("researcherName"), 
			  request.getParameter("productDesc"));
}
			
else//Update---------------------- 
{   
	
	stsMsg = productObj.updateProduct(request.getParameter("hidProductIDUpdate"),   
			request.getParameter("itemCode"),
			 request.getParameter("productName"),      
			  request.getParameter("productPrice"), 
			  request.getParameter("researcherName"), 
			  request.getParameter("productDesc"));  } 

session.setAttribute("statusMsg", stsMsg); } 

if (request.getParameter("hidItemIDDelete") != null) { 
	
	Product productObj = new Product(); 
	   String stsMsg =                 
			   productObj.deleteProduct(request.getParameter("hidItemIDDelete")); 
	   session.setAttribute("statusMsg", stsMsg); } 
%>


   
	<!DOCTYPE html> 
	<html> 
	<head> <meta charset="ISO-8859-1">
	 <title>Products Management</title> 
	</head>
	<style>
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 10px 10px 10px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width:80%;
}

.col-25 {
  float: left;
  width: 20%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 40%;
  margin-top: 4px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
	 <body> 
	
 
 <h1 style="align:center">Products Management</h1> 
 <div class="container">
  <form id="formItem" name="formItem" method="post" action="test.jsp">
    <div class="row">
      <div class="col-25">
        <label for="fname">Products code:</label>
      </div>
      <div class="col-75">
       
         <input name="productCode" type="text" >
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="lname">Products name:</label>
      </div>
      <div class="col-75">
         <input name="productName" type="text" > 
      </div>
    </div>
     <div class="row">
      <div class="col-25">
        <label for="lname">Products price: </label>
      </div>
      <div class="col-75">
        <input name="productPrice" type="text" >
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="lname">researcher Name: </label>
      </div>
      <div class="col-75">
         <input name ="researcherName" type="text">
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="subject">Products description: </label>
      </div>
      <div class="col-75">
        <textarea id="subject" name="productDesc" placeholder="Write something.." style="height:100px"></textarea>
      </div>
    </div>
    <div class="row">
      
       <input name="btnSubmit" type="submit" value="Save" style ="float:left"> 
    </div>
  </form>
</div>
  <!-- <form id="formItem" name="formItem" method="post" action="products.jsp">  
   <Label for="fname">Products code:  </Label>
   <input name="productCode" type="text" ><br> 
    <Label for="fname"> Products name:  </Label> 
   
   <input name="productName" type="text" ><br> 
    <Label for="fname">Products price:   </Label> 
   
   <input name="productPrice" type="text" ><br> 
    <Label for="fname">researcher Name:  </Label>
    
   <input name ="researcherName" type="text"><br>
    <Label for="fname"> Products description:  </Label>
  
   <input name="productDesc" type="text" ><br>   <br>
   <input name="btnSubmit" type="submit" value="Save">  

   </form> -->
 
  </body> 
  </html>