import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword").trim();
        String resetEmail = (String) request.getSession().getAttribute("resetEmail");

        if (resetEmail == null) {
            request.setAttribute("error", "Session expired or email not found. Please request a new OTP.");
            RequestDispatcher rd = request.getRequestDispatcher("otpEntry.jsp");
            rd.forward(request, response);
            return;
        }

        // Update the password in the database
        UserDAO userDAO = new UserDAO();
        try {
            if (userDAO.updatePassword(resetEmail, SHA256Hasher.hashPassword(newPassword))) {
                // Clear session data
                request.getSession().removeAttribute("resetEmail");
                request.getSession().removeAttribute("resetOtp");
                request.getSession().removeAttribute("otpExpiry");

                // Success message and redirect to login page
                request.setAttribute("success", "Password successfully updated. You can now log in.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Error updating password. Please try again.");
                RequestDispatcher rd = request.getRequestDispatcher("newPassword.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error. Please try again later.");
            RequestDispatcher rd = request.getRequestDispatcher("newPassword.jsp");
            rd.forward(request, response);
        }
    }
}
