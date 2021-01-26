<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
       <title>Save Customer</title>
       <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
   
    <div id="wrapper">
             <div id="header">
                   <h2>Customer Relationship Management</h2>
             </div>
       </div>
      
    
       <div id="container">
         
          <h3>Save Customer</h3>
            
         <!-- Add Table -->
            <form:form action="saveCustomerForm" modelAttribute="customer" method="POST">
                     <!-- Table Format -->
                 <form:hidden path="id" />    
                      
				     <table>
					     <tbody>
					     	<tr>
					          <td><label>First Name :</label></td>
					          <td><form:input path="firstname"/></td>
				            </tr>
				            <tr>
					          <td><label>Last Name :</label></td>
					          <td><form:input path="lastname"/></td>
				            </tr>
				            <tr>
					          <td><label>Email :</label></td>
					          <td><form:input path="email"/></td>
				            </tr>
				             <tr>
					          <td><label></label></td>
					          <td><input type="submit" value="Save" class="save" /></td>
				            </tr>
					     </tbody>
				     </table>    
	        </form:form>
	        
	       
	        
	        <p>
	           <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
	        </p>
       </div> 
   
   
     
</body>
</html>