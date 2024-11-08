import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
       // response.setContentType("text/html");
       // PrintWriter out = response.getWriter();
        String instagramLoginUrl = "https://www.instagram.com/accounts/login/";
        response.sendRedirect(instagramLoginUrl);

  /* try {
   
            try (Connection conn = DatabaseHelper.getConn String instagramLoginUrl = "https://www.instagram.com/accounts/login/";
        response.sendRedirect(instagramLoginUrl);ection()) {
                String sql = "SELECT * FROM users WHERE username = ? AND password = ? ";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);
                
                
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    
                    out.println("<h2>Login Successful</h2>");
                    out.println("<p>Welcome, " + username + "!</p>");
                    
                } else {
                    
                    out.println("<h2>Invalid Username or Password</h2>");
                }
                
                
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>Database Error!</h2>");
        }*/

    }
}
