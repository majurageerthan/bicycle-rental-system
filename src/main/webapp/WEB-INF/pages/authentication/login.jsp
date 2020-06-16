<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../source/header.jsp">
    <jsp:param name="title" value="Bicycle rental system"/>
</jsp:include>

<style type="text/css">
    .login-form {
        width: 340px;
        margin: 50px auto;
    }

    .login-form form {
        margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }

    .login-form h2 {
        margin: 0 0 15px;
    }

    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }

    .btn {
        font-size: 15px;
        font-weight: bold;
    }
</style>

<div class="alert alert-primary text-center" role="alert">
    ${message}
</div>

<div class="container">

    <div class="login-form">
        <form:form action="authenticate_user" method="post" modelAttribute="logInUser">
            <%--<form action="${pageContext.request.contextPath}/authenticate_user" method="post">--%>
            <h5 class="text-center">Bicycle rental system</h5>
            <h2 class="text-center">Log in</h2>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Username" required="required" name="userName"
                       autocomplete="off">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" required="required"
                       name="password" autocomplete="off">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Log in</button>
            </div>
            <div class="clearfix">
                <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
                <a href="#" class="pull-right">Forgot Password?</a>
            </div>
            <%--</form>--%>
        </form:form>
        <p class="text-center"><a href="#">Create an Account</a></p>
    </div>

</div>

<div class="container">
    <div class="alert alert-success text-center" role="alert">
       User roles and login credentials
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">User role</th>
            <th scope="col">User name</th>
            <th scope="col">Password</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Manager</td>
            <td>941212293V</td>
            <td>1234</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Cashier</td>
            <td>941312293V</td>
            <td>1234</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Customer</td>
            <td>941112293V</td>
            <td>1234</td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>