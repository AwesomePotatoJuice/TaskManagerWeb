<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS File -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
          crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script>
        function loadRegisterJSPAjax() {
            $.post("ajax", {load: "register"}, function (data) {
                $("#loginSection").remove();
                $("#body").html(data);
            })
            // $.ajax({
            //     url: "ajax",
            //     method: "POST",
            //     data: {load: "register"},
            //     dataType: "text",
            //     success: function (data) {
            //         $("#body").innerHTML = data;
            //     }
            // });
        }
    </script>
</head>
<body>
<div class="container" style="margin-top:30px">
    <%@include file="header.jsp" %>
    <div class="col-sm-12 " id="body">
        <%@ include file="index/login.jsp"%>
    </div>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>