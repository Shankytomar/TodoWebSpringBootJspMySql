 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
  <html>
  <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"/>
  </head>
  
  <body>
  
  <div class="container">
  <h1>TODO Portal</h1>
  <hr>
  <h2>Ready to add new Task to your list</h2>
  <form:form action="/new-todo" method="post" modelAttribute="todo">
  <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Description</label>
  <form:input type="text" class="form-control w-50 p-3" id="exampleFormControlInput1"  path="description"/>
  <form:errors path="description" cssClass="text-warning"/>
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Target date</label>
  <form:input type="date" class="form-control w-50 p-3" id="exampleFormControlInput1" path="targetDate" placeholder="yyyy/mm/dd"/>
  <form:errors path="targetDate" cssClass="text-warning"/>
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">IsDone</label>
  <form:input readonly="true" class="form-control w-50 p-3" id="exampleFormControlInput1" path="done" value="false"/>
  <form:errors path="done" cssClass="text-warning"/>
</div>

<div class="mb-3">
	<label for="exampleFormControlTextarea1" class="form-label">under the Username</label>
  <form:input readonly="true" class="form-control w-50 p-3" id="exampleFormControlInput1" path="user" value="${username}"/>
</div>

<button type="submit"  class="btn btn-primary">Proceed To Add</button>
  </form:form>
  
  </div>
  
  </body>
  </html>