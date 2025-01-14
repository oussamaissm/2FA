
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@WebServlet("/ValidateOtpServlet")
public class ValidateOtpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userOtp = request.getParameter("otp").trim();
        String sessionOtp = (String) request.getSession().getAttribute("resetOtp");
        Instant sessionOtpTimestamp = (Instant) request.getSession().getAttribute("authCodeTimestamp");

        if (sessionOtp == null) {
            request.setAttribute("error", "OTP not found. Please request a new one.");
            RequestDispatcher rd = request.getRequestDispatcher("otpEntry.jsp");
            rd.forward(request, response);
            return;
        }

        Instant now = Instant.now();
        if (Duration.between(sessionOtpTimestamp, now).toMinutes() > 5) {
        	request.setAttribute("error", "OTP a expiré.");
            RequestDispatcher rd = request.getRequestDispatcher("forgotPassword.jsp");
            rd.forward(request, response);
            return;
        }

        // Validate OTP
        if (sessionOtp.equals(userOtp)) {
            // OTP is correct, redirect to the new password page
            RequestDispatcher rd = request.getRequestDispatcher("newPassword.jsp");
            rd.forward(request, response);
        } else {
            // OTP is incorrect
            request.setAttribute("error", "Invalid OTP. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("otpEntry.jsp");
            rd.forward(request, response);
        }
    }
}
