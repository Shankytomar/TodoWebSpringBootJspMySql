<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"/>
  </head>
  
  <body>
  
  <div class="container">
  <h1>TODO Portal</h1>
  <hr>
  <h2> ${username}'s Todo List</h2>
  <table class="table">
  <thead>
  <th>Description</th>
  <th>TargetDate</th>
  <th>IsDone</th>
  <th>Delete</th>
  <th>Update</th>
  </thead>
  
  <tbody>
    <c:forEach items="${todos}" var="todo">
  	<tr>
  		<td>${todo.description}</td>
  		<td>${todo.targetDate}</td>
  		<td>${todo.done}</td>
  		<td><a href="/delete-todo?id=${todo.id}" class="btn btn-danger" style="text-decoration:none">Delete</a></td>
  		<td><a href="/update-todo?id=${todo.id}" class="btn btn-warning" style="text-decoration:none">Update</a></td>
  	</tr>
  	</c:forEach>
  	<tr><td><a href="/new-todo?username=${username}" class="btn btn-success" style="text-decoration:none">Add</a><td>
 		<td><a href="/logout" class="btn btn-primary" style="text-decoration:none">Logout</a><td> 	
  	</tr>
  	
  </tbody> 
  </table>
  </div>
  </body>