package servlets;

import org.jasypt.util.password.BasicPasswordEncryptor;
import util.DBC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBC.connect();

            String email = request.getParameter("email");
            String query = "SELECT password, id FROM users WHERE email = '" + email + "'";



            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ArrayList<String> passwords = new ArrayList<>();
            int id = 0;
            while (resultSet.next()){
               passwords.add(resultSet.getString("password"));
               id = resultSet.getInt("id");
            }

            BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

            if (passwords.size() == 1 && passwordEncryptor.checkPassword(request.getParameter("password"), passwords.get(0))) {
                out.println("Welcome " + email + "! Your password was verified from database.");
                HttpSession session = request.getSession();
                session.setAttribute("id", id);
                request.getRequestDispatcher("manager.jsp").forward(request, response);
            }
            else{
                out.println("Welcome ahhhhhh, nope, password is incorrect :(");

            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException ex){
        out.println("DataBase is down\n");
        out.println(ex.getMessage());
        } catch (ClassNotFoundException ex){
        out.println("Server driver is broken\n");
        out.println(ex.getMessage());
        } catch (Exception ex){
            ex.printStackTrace(out);
        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //Connection connection = util.DBC.connect();
        out.println("Get was here");
    }
}
