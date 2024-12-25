<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.models.Items" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Bitlab Shop</title>
    <%@include file="vendor/header.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<%
    ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("items");
%>
<div class="container mt-5">
    <!-- Заголовок -->
    <div class="text-center mb-4">
        <h1 class="fw-bold">Welcome to BITLAB SHOP</h1>
        <p class="text-muted">Electronic devices with high quality and service</p>
    </div>
    <!-- Карточки товаров -->
    <div class="row g-4">
        <!-- Карточка товара -->
        <%
            if (items != null){
        %>
        <% for (Items item: items){ %>
        <div class="col-md-4">
            <div class="card border-0 shadow-sm h-100">
                <div class="card-body text-center">
                    <div class="card-header text-center fw-bold"><%=item.getName()%></div>
                    <p class="card-text text-success h4 fw-bold">$<%=item.getPrice()%></p>
                    <p class="text-muted mb-1 text-wrap"><%=item.getDescription()%></p>

                    <a href="#" class="btn btn-success w-100 mt-1">Buy Now</a>
                </div>
            </div>
        </div>
        <%}}%>

    </div>
</div>
</body>
</html>
