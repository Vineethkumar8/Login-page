import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class RegisterServlet extends HttpServlet {
    // This method will handle the form submission and store data in the database
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get data from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Print writer for response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Insert into database
        try {
            // Get a connection to the database
            Connection conn = DatabaseHelper.getConnection();
            
            // Create SQL query to insert the user
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            
            // Prepare the statement to insert user data into the database
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // In a real app, hash the password before storing it
            
            // Execute the query
            int rowsInserted = stmt.executeUpdate();
            
            if (rowsInserted > 0) {
                out.println("<h2>User Registered Successfully!</h2>");
            } else {
                out.println("<h2>Error: User could not be registered!</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>Error: Database issue occurred!</h2>");
        }
    }
}

