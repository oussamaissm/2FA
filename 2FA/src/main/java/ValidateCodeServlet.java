
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCode = request.getParameter("code");
        String authCode = (String) request.getSession().getAttribute("authCode");
        Instant sessionOtpTimestamp = (Instant) request.getSession().getAttribute("authCodeTimestamp");


        if (authCode == null) {
            request.setAttribute("error", "Session expired or no verification code found. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }
        
        Instant now = Instant.now();
        if (Duration.between(sessionOtpTimestamp, now).toMinutes() > 5) {
            request.setAttribute("error", "Code OTP expiré.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return ;
        }

        if (authCode.equals(userCode)) {
            request.getSession().removeAttribute("authCode");
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "Invalid verification code. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("otp.jsp");
            rd.forward(request, response);
        }
    }
}