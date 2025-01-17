import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("txtName").trim();
        String password = request.getParameter("txtPwd").trim();

        if (username.isEmpty() || password.isEmpty()) {
            redirectToLoginWithError(request, response, "Please enter both username and password.");
            return;
        }

        UserDAO userDAO = new UserDAO();
        try {
        	
            if (userDAO.validateCredentials(username, password)) {
                String email = userDAO.getUserEmail(username);
                String otp = OTPGenerator.generateOTP();

                request.getSession().setAttribute("authCode", otp);
                MailSender.sendOTP(email, otp);

                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
                redirectToLoginWithError(request, response, "Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            redirectToLoginWithError(request, response, "Database error. Please try again later.");
        } catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void redirectToLoginWithError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("error", errorMessage);
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
}