<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="vendor/header.jsp"%> <!-- Подключение Bootstrap -->
    <title>Login</title>
</head>
<body>
<%@include file="vendor/navbar.jsp"%> <!-- Подключение Navbar -->
<div class="container mt-5 d-flex justify-content-center">
    <div style="width: 500px;">
        <%
            // Получаем параметр ошибки из URL
            String error = request.getParameter("error");
            if (error != null && error.equals("1")) {
        %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Invalid email or password. Please try again.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }
        %>
    <div class="card shadow-sm" style="width: 500px;"> <!-- Увеличена ширина до 500px -->
        <div class="card-body">
            <h5 class="card-title text-center">Login Page</h5>
            <form action="/login" method="post">
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                </div>
                <button type="submit" class="btn btn-success w-100">Login</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
