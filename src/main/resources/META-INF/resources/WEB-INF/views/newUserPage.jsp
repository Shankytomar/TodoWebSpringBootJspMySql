   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <html>
  <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"/>
  </head>
  
  <body>
  
  <div class="container">
  <h1>TODO Portal</h1>
  <hr>
  <h2>Register yourself</h2>
  <form:form action="/new-user" method="post" modelAttribute="user">
  <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label" >username</label>
  <form:input type="text" class="form-control w-50 p-3" id="exampleFormControlInput1" path="username" name="username"/>
  <form:errors path="username" cssClass="text-warning"/>
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">password</label>
  <form:input type="password" class="form-control w-50 p-3" id="exampleFormControlInput1" path="password" name="password"/>
  <form:errors path="password" cssClass="text-warning"/>
</div>
<button type="submit"  class="btn btn-primary">Register</button>

<a href="/login" class="btn btn-warning">Back</a>
  </form:form>
  
  </div>
  
  </body>
  </html>