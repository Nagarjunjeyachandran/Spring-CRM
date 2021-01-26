<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

       <div class="wrapper">
             <div class="header">
                   <h2>Customer Relationship Management</h2>
             </div>
       </div>
      
    
       <div class="container">
         <div class="content">
         
            <!-- Put Add Customer button -->
            <input type="text" value="Add Customer" 
                                  onclick="window.location.href = 'showNewCustomerForm'; return false;"
                                  class="add-button"/>
                                  
              <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" value="${param.theSearchName}"/>
                <input type="submit" value="Search" class="add-button" />
               </form:form>                     
         <!-- Add Table -->
            <table>
	            <tr>
	                   <th>FirstName</th>
	                   <th>LastName</th>
	                   <th>Email</th>
	                   <th>Actions</th>
	            </tr>
	          
	           <!--  loop over and print the customers -->
	           <c:forEach var="cust" items="${customer}">	      
	           
	           <!-- Construct an update link -->     
	           
	              <c:url var="updateLink" value="/customer/showUpdateCustomerForm">
	                <c:param name="customerId" value="${cust.id}"></c:param>
	              </c:url>
	              
	             <!-- Construct an delete link -->     
	           
	              <c:url var="deleteLink" value="/customer/delete">
	                <c:param name="customerId" value="${cust.id}"></c:param>
	              </c:url>
			           <tr>
			                   <td>${cust.firstname}</td>
			                   <td>${cust.lastname}</td>
			                   <td>${cust.email}</td>
			                   <td>
			                    <a href="${updateLink}">Update</a>
			                     |
			                    <a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>
			                    </td>
			            </tr>	           
	           </c:forEach>
	            
            </table>
         </div>
       </div> 

</body>

</html>









