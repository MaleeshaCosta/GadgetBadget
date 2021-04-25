package com;
import model.Product; 

//For REST Service 
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON 
import com.google.gson.*; 

//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 


@Path("/Products")

public class ProductService {
	
		Product productObj = new Product();
		@GET  
		@Path("/read/1")  
		@Produces(MediaType.TEXT_HTML)  
		public String readProduct()  {   
			return productObj.readProduct();  } 
		 
		@POST 
		@Path("/insert/2") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertProduct(@FormParam("productCode") String productCode,       
				@FormParam("productName") String productName,    
				@FormParam("productPrice") String productPrice,
				@FormParam("researcherName") String researcherName,
				@FormParam("productDesc") String productDesc)
		{ 
			String output = productObj.insertProduct(productCode, productName, productPrice,researcherName,productDesc);  
			return output; 
			
		} 
		 
		@PUT 
		@Path("/update/3") 
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateProduct(String productData) {  //Convert the input string to a JSON object  
			JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject(); 
			 
			 //Read the values from the JSON object  
			String productID = productObject.get("productID").getAsString(); 
			String productCode = productObject.get("productCode").getAsString(); 
			String productName = productObject.get("productName").getAsString(); 
			String productPrice = productObject.get("productPrice").getAsString();  
			String researcherName = productObject.get("researcherName").getAsString();  
			String productDesc = productObject.get("productDesc").getAsString(); 
			 
			       String output = productObj.updateProduct(productID, productCode, productName, productPrice,researcherName, productDesc); 
			 
			 return output;
			 } 
			 
		@DELETE 
		@Path("/delete/4") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN)
		
		public String deleteProduct(String productData) {  //Convert the input string to an XML document  
			Document doc = Jsoup.parse(productData, "", Parser.xmlParser());     //Read the value from the element <itemID>  
			String productID = doc.select("productID").text(); 
			 
			 String output = productObj.deleteProduct(productID); 
			 
			 return output; 
			 }
		
				
		 
	}



