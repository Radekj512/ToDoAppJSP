<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <title>To Do</title>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <p class="navbar-brand"><a href="${pageContext.request.contextPath}/" class="navbar-link">To Do</a></p>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <c:choose>
            <c:when test="${wrongLogin}">
                <div class="alert alert-danger">
                    Podano zły login lub hasło
                </div>
            </c:when>
        </c:choose>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Nazwa użytkownika</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="Nazwa użytkownika" size="50">
                </div>
            </div>
            <div class="form-group">
                <label for="haslo" class="col-sm-2 control-label">Hasło</label>
                <div class="col-sm-3">
                    <input type="password" class="form-control" id="haslo" name="pass" placeholder="Hasło" size="50">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Zaloguj się</button>
                </div>
            </div>

        </form>
    </div>
    <div class="row">
        <form action="${pageContext.request.contextPath}/register" method="get" class="form-horizontal">
            <button type="submit" class="btn btn-primary">Zarejestruj się</button>
        </form>
    </div>
</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>