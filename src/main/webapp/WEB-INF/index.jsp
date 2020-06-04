<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="pages/source/header.jsp">
    <jsp:param name="title" value="Add bracket to clipboard word"/>
</jsp:include>
<br><br><br><br><br>

<div class="container">

    <div class="container">
        <a class="btn btn-outline-secondary btn-lg btn-block"
           href="${pageContext.request.contextPath}/add_bracket_to_copied_clipboard" role="button">
            Add Bracket To Copied Clipboard
        </a>
    </div>

</div>


</body>
</html>
