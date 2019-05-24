package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("load");
        //if( == "register") {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<section id=\"registerSection\">\n" +
                    "    <script>\n" +
                    "        function check() {\n" +
                    "            $('#password2').blur(function (event) {\n" +
                    "                if ($('#password2').val() === $('#password1').val()) {\n" +
                    "                    $('#message').style.color = 'green';\n" +
                    "                    $('#message').innerHTML = 'Passwords match';\n" +
                    "                    $('#submit').removeAttr('disabled');\n" +
                    "                    return true;\n" +
                    "                } else {\n" +
                    "                    $('message').style.color = 'red';\n" +
                    "                    $('message').innerHTML = 'Passwords do not match';\n" +
                    "                    $('#submit').attr('disabled');\n" +
                    "                    return false;\n" +
                    "                }\n" +
                    "            });\n" +
                    "        }\n" +
                    "    </script>\n" +
                    "    <h2 class=\"h2 text-center\">Register</h2>\n" +
                    "    <form action=\"register\" method=\"post\">\n" +
                    "        <div class=\"form-group row\">\n" +
                    "            <label for=\"email\" class=\"col-sm-4 col-form-label\">E-mail:</label>\n" +
                    "            <div class=\"col-sm-8\">\n" +
                    "                <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\"\n" +
                    "                       placeholder=\"E-mail\" maxlength=\"60\" required\n" +
                    "                       value=\"\">\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"form-group row\">\n" +
                    "            <label for=\"password1\" class=\"col-sm-4 col-form-label\">Password:</label>\n" +
                    "            <div class=\"col-sm-8\">\n" +
                    "                <input type=\"password\" class=\"form-control\" id=\"password1\" name=\"password1\"\n" +
                    "                       placeholder=\"Password\" maxlength=\"12\" required\n" +
                    "                       value=\"\">\n" +
                    "                <span id='message'>Between 8 and 12 characters.</span>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"form-group row\">\n" +
                    "            <label for=\"password2\" class=\"col-sm-4 col-form-label\">Confirm Password:</label>\n" +
                    "            <div class=\"col-sm-8\">\n" +
                    "                <input type=\"password\" class=\"form-control\" id=\"password2\" name=\"password2\"\n" +
                    "                       placeholder=\"Confirm Password\" maxlength=\"12\" required\n" +
                    "                       value=\"\">\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"form-group row\">\n" +
                    "            <div class=\"col-sm-12\">\n" +
                    "                <input id=\"submit\" class=\"btn btn-primary\" type=\"submit\" name=\"submit\" value=\"Register\">\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </form>\n" +
                    "</section>");
        //}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
