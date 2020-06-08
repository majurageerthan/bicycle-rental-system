<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="./source/header.jsp">
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
    For creating necessary tables and creating user role, MySQL needs your root/ root level MySQL account. Please enter
    your details below
</div>

<div class="container">
    <h5 class="text-center">Please enter your MySQL root userName and Password</h5>

    <div class="login-form">
        <%--<form:form action="authenticate_user" method="post" modelAttribute="logInUser">--%>
        <form action="${pageContext.request.contextPath}/initialize_system" method="post">
            <h2 class="text-center">MySQL root details</h2>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="MySQL root Username" required="required"
                       name="userName"
                       autocomplete="off">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="MySQL root Password" required="required"
                       name="password" autocomplete="off">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Initialize system</button>
            </div>
        </form>
        <%--</form:form>--%>
    </div>

    <a class="btn btn-outline-secondary btn-lg btn-block" href="${pageContext.request.contextPath}/login_page"
       role="button">Already initialized system, Go to user role login page</a>

</div>

</body>
</html>