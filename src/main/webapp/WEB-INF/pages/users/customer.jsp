<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../source/header.jsp">
    <jsp:param name="title" value="Profile"/>
</jsp:include>

<div class="container">
    <div class="alert alert-success text-center" role="alert">
       Customer details
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Info</th>
            <th scope="col">Value</th>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>NIC</td>
            <td>${user.nic}</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>First name</td>
            <td>${user.fname}</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Last name</td>
            <td>${user.lname}</td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>Date of birth</td>
            <td>${user.dob}</td>
        </tr>
        <tr>
            <th scope="row">5</th>
            <td>Sex</td>
            <td>${user.sex}</td>
        </tr>
        <tr>
            <th scope="row">6</th>
            <td>Phone</td>
            <td>${user.phone}</td>
        </tr>
        <tr>
            <th scope="row">7</th>
            <td>Email</td>
            <td>${user.email}</td>
        </tr>
        </tbody>
    </table>
</div>