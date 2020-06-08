<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../source/header.jsp">
    <jsp:param name="title" value="Sucess"/>
</jsp:include>

<%--<script type="text/javascript">setTimeout("window.close();", 3000);</script>--%>

<div class="container">
    <br><br><br><br>
    <div class="alert alert-success text-center" role="alert">
        ${message}
    </div>

    <a class="btn btn-outline-secondary btn-lg btn-block" onclick="history.back()" role="button">Go back</a>


</div>
</body>
</html>