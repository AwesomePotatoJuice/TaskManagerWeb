package servlets;

import util.DBC;
import org.jasypt.util.password.BasicPasswordEncryptor;
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

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Connection connection;
        Statement statement;
        try {
            connection = DBC.connect();
            String email = request.getParameter("email");
            String password = request.getParameter("password1");
            BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
            password = passwordEncryptor.encryptPassword(password);
            String query = "INSERT INTO users (email, password) VALUES ('" + email + "', '" + password + "');";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            query = "SELECT id FROM users WHERE email = '"+ email +"'";
            ResultSet resultSet = statement.executeQuery(query);
            int id = 0;
            while (resultSet.next()){
                 id = Integer.parseInt(resultSet.getString("id"));
            }
            connection.close();
            statement.close();

            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            response.sendRedirect("manager.jsp");
            //request.getRequestDispatcher("manager.jsp").forward(request, response);

        } catch (SQLException ex){
            out.println("DataBase is down\n");
            ex.printStackTrace(out);
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

    }
}
