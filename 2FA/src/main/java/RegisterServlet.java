
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String confirmPassword = request.getParameter("confirmPassword").trim();
        String email = request.getParameter("email").trim();
		UserDAO user = new UserDAO();


        if ((username.isEmpty() || password.isEmpty() || email.isEmpty()) || !password.equals(confirmPassword)) {
            request.setAttribute("error", "All fields are required.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }
					try {
						if (user.createUser(username, password, email) ) {
						    request.setAttribute("message", "Registration successful! Please log in.");
						    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						    rd.forward(request, response);
						} else {
						    request.setAttribute("error", "Registration failed. Please try again.");
						    RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
						    rd.forward(request, response);
						}
					} catch (SQLException | ServletException | IOException e) {
						e.printStackTrace();
					}
            
        
    }
}
