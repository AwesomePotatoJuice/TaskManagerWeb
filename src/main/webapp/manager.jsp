<%--
  Created by IntelliJ IDEA.
  User: surin
  Date: 24.05.2019
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TM</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div id="header" class="header-panel">
        <%@include file="header.jsp"%>
    </div>
    <div class="row" id="personal">
        <div class="col-sm-12  text-center">
            <h2>Your id is: <%=session.getAttribute("id")%></h2>
            And other personal info...
        </div>
    </div>
    <div class="row" id="main">
        <div id="projects" class="col-sm-4">
            <%@include file="manager/projects.jsp"%>
        </div>
        <div id="tasks" class="col-sm-4">
            <%@include file="manager/tasks.jsp"%>
        </div>
        <div id="description" class="col-sm-4">
            <%@include file="manager/taskDescription.jsp"%>
        </div>
    </div>
    <div id="footer" class="row">
        <%@include file="footer.jsp"%>
    </div>
</div>
</body>
</html>
