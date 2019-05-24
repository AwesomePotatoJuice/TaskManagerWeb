<%--
  Created by IntelliJ IDEA.
  User: surin
  Date: 23.05.2019
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section id="registerSection">
    <script>
        function check() {
            $('#password2').blur(function (event) {
                if ($('#password2').val() === $('#password1').val()) {
                    $('#message').style.color = 'green';
                    $('#message').innerHTML = 'Passwords match';
                    $('#submit').removeAttr('disabled');
                    return true;
                } else {
                    $('message').style.color = 'red';
                    $('message').innerHTML = 'Passwords do not match';
                    $('#submit').attr('disabled');
                    return false;
                }
            });
        }
    </script>
    <h2 class="h2 text-center">Register</h2>
    <form action="register" method="post">
        <div class="form-group row">
            <label for="email" class="col-sm-4 col-form-label">E-mail:</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" id="email" name="email"
                       placeholder="E-mail" maxlength="60" required
                       value="">
            </div>
        </div>
        <div class="form-group row">
            <label for="password1" class="col-sm-4 col-form-label">Password:</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="password1" name="password1"
                       placeholder="Password" minlength="8" maxlength="12" required
                       value="">
                <span id='message'>Between 8 and 12 characters.</span>
            </div>
        </div>
        <div class="form-group row">
            <label for="password2" class="col-sm-4 col-form-label">Confirm Password:</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="password2" name="password2"
                       placeholder="Confirm Password" minlength="8" maxlength="12" required
                       value="">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-12">
                <input id="submit" class="btn btn-primary" type="submit" name="submit" value="Register">
            </div>
        </div>
    </form>
</section>
