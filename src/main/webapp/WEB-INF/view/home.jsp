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

<%@include file="includes/header.jsp" %>

<div class="table-responsive">
    <table class="table">
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Category</th>
            <th>Creation Date</th>
            <th>Deadline</th>
            <th>Description</th>
        <tr>
            <c:set var="counter" value="0"/>
            <c:forEach items="${todolist}" var="todo">
        <tr class="${todo.done ? "alert-success": ""}">
            <td><h6>${counter=counter+1}</h6></td>
            <td><h6>${todo.title}</h6></td>
            <td><h6>${todo.category}</h6></td>
            <td><h6>${todo.creationDate}</h6></td>
            <td><h6>${todo.deadlineDate}</h6></td>
            <td><h6>${todo.description}</h6></td>

            <td>
                <form action="${pageContext.request.contextPath}/to-do/list/markAsDone?id=${todo.id}" method="post">
                    <c:if test="${todo.done == false}"> <input type="submit" class="btn btn-success" value="Done"
                                                               name="doneButton"/></c:if>
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/to-do/list/edit?id=${todo.id}" method="get">
                    <button type="submit" class="btn btn-warning" value="${todo.id}" name="id">Edit</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/to-do/list/delete?id=${todo.id}" method="post">
                    <input type="submit" class="btn btn-danger" value="Delete" name="deleteButton"/>
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>

    <div class="container">
        <div class="row">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/to-do/list/add" method="post">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">To Do:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="title" name="title" size="50">
                    </div>
                </div>
                <div class="form-group">
                    <label for="category" class="col-sm-2 control-label">Category</label>
                    <div class="col-sm-3">
                        <select class="form-control" id="category" name="category">
                            <c:forEach var="category" items="${categories}">
                                <option value="${category}">${category}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="deadline" class="col-sm-2 control-label">Deadline time:</label>
                    <div class="col-sm-3">
                        <input type="date" class="form-control" id="deadline" name="deadline" size="50">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">Description:</label>
                    <div class="col-sm-3">
                        <textarea class="form-control" rows="3" id="description" name="description"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Add ToDo</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>