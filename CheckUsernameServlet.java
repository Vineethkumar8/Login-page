import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkUsernameServlet  ")
public class CheckUsernameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("name");
        String result = "available";

        response.setContentType("text/plain");

        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_system", "root", "test_sensen")) {

                String query = "SELECT COUNT(*) FROM registered_users WHERE name = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    if (count > 0) {
                        result = "exists";
                    }
                }
                
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                result = "error: SQL exception";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            result = "error: Driver not found";
        }
       response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
