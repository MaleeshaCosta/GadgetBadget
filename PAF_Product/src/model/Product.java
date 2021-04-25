package model;

import java.sql.*;
import java.sql.DriverManager;

import javax.jws.WebMethod;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class Product {
	private Connection connect()  {   
		Connection con = null; 
	
	 
	  try   {     
		  Class.forName("com.mysql.cj.jdbc.Driver"); //Provide the correct details: DBServer/DBName, username, password    
		  con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PAFproducts", "root", "madhu@2020MY");   
		  }   catch (Exception e) {
			  
			  e.printStackTrace();
			 // System.out.println("error while inserting");
			  } 
	  
	 
	  return con;  
	}
	 
	 public String insertProduct(String code, String name, String price,String reName, String desc)  {  
		 String output = ""; 
	 
	 
	  try   {    Connection con = connect(); 
	 
	   if (con == null)    {
		   return "Error while connecting to the database for inserting."; } 
	 
	   // create a prepared statement    
	   String query = " insert into products(productID,productCode,productName,productPrice,researcherName,productDesc)"      
	   + " values (?, ?, ?, ?, ?, ?)"; 
	 
	   PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	   // binding values    
	   preparedStmt.setInt(1, 0);    
	   preparedStmt.setString(2, code);    
	   preparedStmt.setString(3, name);    
	   preparedStmt.setDouble(4, Double.parseDouble(price));  
	   preparedStmt.setString(5,reName);
	   preparedStmt.setString(6, desc); 
	   preparedStmt.execute();    con.close(); 
	   
	   output = "Inserted successfully";   
	   }   catch (Exception e)   {    
		   output = "Error while inserting the item.";    
		   System.err.println(e.getMessage());   
		   } 
	 
	  return output; 
	  } 
	 
	 public String readProduct()  {   
		 String output = ""; 
		 
		  try   {   
			  Connection con = connect(); 
		 
		   if (con == null)    {
			   return "Error while connecting to the database for reading.";
			   } 
		 
		   // Prepare the html table to be displayed   
		   output = "<table border='1'><tr><th>Product Code</th>"
		   + "<th>Product Name</th>"
		   +     "<th>Product Price</th>" 
		   +		"<th>Researcher Name</th>"
		   +      "<th>Product Description</th>" 
		   +     "<th>Update</th><th>Remove</th></tr>";      
				   
		   String query = "select * from products";    
		   Statement stmt = con.createStatement();    
		   ResultSet rs = stmt.executeQuery(query); 
		 
		   // iterate through the rows in the result set    
		   while (rs.next())    {     
			   String productID = Integer.toString(rs.getInt("productID"));     
			   String productCode = rs.getString("productCode");     
			   String productName = rs.getString("productName");     
			   String productPrice = Double.toString(rs.getDouble("productPrice"));     
			   String researcherName = rs.getString("researcherName");
			   String productDesc = rs.getString("productDesc"); 
		   
		 
		    // Add into the html table 
			   output += "<tr><td><input id='hidProductIDUpdate'       "
				  		+ " name='hidProductIDUpdate'          "
				  		+ "type='hidden' value='" + productID + "'>"      + productCode + "</td>";   
			   output += "<td>" + productName + "</td>";     
			   output += "<td>" + productPrice + "</td>"; 
			   output += "<td>" + researcherName + "</td>"; 
			   output += "<td>" + productDesc + "</td>"; 
				 
				 
		    
		  
		 
		    // buttons     
		  
		   output += "<td><input name='btnUpdate'         type='button' value='Update'         class=' btnUpdate btn btn-secondary'></td>      "
			  		+ "<td><form method='post' action='test.jsp'>    "
			  		+ "  <input name='btnRemove' type='submit'        "
			  		+ "value='Remove' class='btn btn-danger'>      <input name='hidItemIDDelete' type='hidden'       "
			  		+ "value='" + productID + "'>" + "</form></td></tr>"; 
			 } 
		 
		   con.close(); 
		 
		   // Complete the html table    
		   output += "</table>";  
		   }   catch (Exception e)   {   
			   output = "Error while reading the items.";    
			   System.err.println(e.getMessage());   
			   } 
		 
		  return output; 
		  } 
		 
	 
	 public String updateProduct(String ID, String code, String name, String price,String reName, String desc) {
		 String output = ""; 
		 
		  try   {    
			  Connection con = connect(); 
		 
		   if (con == null)    {
			   return "Error while connecting to the database for updating."; 
			   } 
		 
		   // create a prepared statement    
		   String query = "UPDATE products SET productCode=?,productName=?,productPrice=?,researcherName=?, productDesc=? WHERE productID=?"; 
		 
		   PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		   // binding values    
		   preparedStmt.setString(1, code);    
		   preparedStmt.setString(2, name);    
		   preparedStmt.setDouble(3, Double.parseDouble(price)); 
		   preparedStmt.setString(4, reName);
		   preparedStmt.setString(5, desc);    
		   preparedStmt.setInt(6, Integer.parseInt(ID)); 
		 
		   // execute the statement    
		   preparedStmt.execute();    con.close(); 
		 
		   output = "Updated successfully";  
		   }   catch (Exception e)   {    
			   output = "Error while updating the item.";
			   System.err.println(e.getMessage());   
			   } 
		 
		  return output;  } 
		 
		 public String deleteProduct(String productID)  {  
			 
			 String output = ""; 
		 
			 	try   {  
			  Connection con = connect(); 
		 
			  				if (con == null)    {
			   
			  							return "Error while connecting to the database for deleting.";
			  					} 
		 
		   // create a prepared statement    
			  String query = "delete from products where productID=?"; 
		 
			  PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		   // binding values    
			 preparedStmt.setInt(1, Integer.parseInt(productID)); 
		 
		   // execute the statement    
			 preparedStmt.execute();    
			 con.close(); 
		 
			 output = "Deleted successfully"; 
		   }  
			 	catch (Exception e)   {   
			 			output = "Error while deleting the item.";    
			 			System.err.println(e.getMessage());   
			 			
			 			} 
		 
		return output; 
		
		  }  
		 @GET
		    @Path("/retrive")
		    @Produces("text/html")
		    @WebMethod(operationName = "retrive")
		    public String retrive() 
		    {
		        ResultSet rs = null;
		        String details = ""; 
		        try 
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PAFproducts", "root", "madhu@2020MY");

		            String query = "select productID,productCode from products";

		            PreparedStatement st = con.prepareStatement(query);
		            rs = st.executeQuery();

		            details = "<html><body>"; 
		            details = details + "<table border=1>";
		            details = details + "<tr><td><Strong>Id </Strong></td>" +
		                                    "<td><Strong>Code </Strong></td>" + "</tr>";
		            while (rs.next()) 
		            {
		                details = details + "<tr><td>" + rs.getInt("productID") + "</td>" +
		                                        "<td>" + rs.getString("productCode") + "</td></tr>";
		            }
		            details += "</table></body></html>"; 
		        } 
		        catch (Exception e) 
		        {
		            System.out.println(e.getMessage());
		        }   
		        return details;
		    }
		
		}

