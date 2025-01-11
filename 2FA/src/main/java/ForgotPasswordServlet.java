import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.mail.MessagingException;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email").trim();

        // Validate email
        if (email == null || email.isEmpty()) {
            request.setAttribute("error", "Veuillez entrer une adresse e-mail.");
            RequestDispatcher rd = request.getRequestDispatcher("forgotPassword.jsp");
            rd.forward(request, response);
            return;
        }

        // Generate OTP using OTPGenerator
        String otp = OTPGenerator.generateOTP();

        // Store OTP, email, and expiry in the session (valid for 1 hour)
        request.getSession().setAttribute("resetEmail", email);
        request.getSession().setAttribute("resetOtp", otp);
        request.getSession().setAttribute("otpExpiry", System.currentTimeMillis() + (60 * 60 * 1000)); // 1 hour expiry

        try {
            // Send OTP email using MailSender utility class
            String emailSubject = "Your Password Reset Code"; 
            MailSender.sendOTP(email, otp, emailSubject);

            // Set success message and forward to the JSP page
            request.setAttribute("success", "Un code OTP a été envoyé à votre adresse e-mail.");
        } catch (MessagingException e) {
            // Log the error and set error message
            e.printStackTrace();
            request.setAttribute("error", "Erreur lors de l'envoi de l'e-mail. Veuillez réessayer.");
        }

        // Forward to forgotPassword.jsp to show success or error message
        RequestDispatcher rd = request.getRequestDispatcher("otpEntry.jsp");
        rd.forward(request, response);
    }
}
