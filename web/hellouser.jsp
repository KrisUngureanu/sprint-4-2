<%@ page import="kz.bitlab.models.Users" %>
<%@ page import="kz.bitlab.models.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello User Profile</title>
    <%@include file="vendor/header.jsp"%> <!-- Подключение Bootstrap -->
</head>
<body>
<%@include file="vendor/navbar.jsp"%> <!-- Навигация -->
<%
    String id = request.getParameter("id");
    if (id != null) {
        Users user = DBManager.getUserById(Long.parseLong(id));
%>
<% if (user != null) { %>
<div class="container d-flex flex-column align-items-center mt-5">
    <h1 class="fw-bold">Hello, <%= user.getFullName() %></h1>
    <p class="text-muted fs-5">This is your profile page</p>
</div>
<% } else { %>
<div class="container mt-5">
    <div class="alert alert-danger" role="alert">
        User not found. Please try again.
    </div>
</div>
<% } %>
<% } %>
</body>
</html>
