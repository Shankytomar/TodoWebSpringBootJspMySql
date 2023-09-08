 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
  <html>
  <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"/>
  </head>
  
  <body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
  
  <div class="container">
  <h1>TODO Portal</h1>
  <hr>
  <h2>Update the Todo task</h2>
  <form:form action="/update-todo" method="post" modelAttribute="todo">
  <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Description</label>
  <form:input type="text" class="form-control w-50 p-3" id="exampleFormControlInput1"  path="description" value="${todo.description}"/>
  <form:errors path="description" cssClass="text-warning"/>
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Target date</label>
  <form:input type="date" class="form-control w-50 p-3" id="exampleFormControlInput1" path="targetDate"/>
  <form:errors path="targetDate" cssClass="text-warning"/>
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">IsDone</label>
  <form:input class="form-control w-50 p-3" id="exampleFormControlInput1" path="done" value="${todo.done}"/>
  <form:errors path="done" cssClass="text-warning"/>
</div>

<button type="submit"  class="btn btn-primary">Proceed To Update</button>
  </form:form>
  <h2 class="btn btn-danger">donot go back until save this todo</h2>
  </div>
  </body>
  </html>