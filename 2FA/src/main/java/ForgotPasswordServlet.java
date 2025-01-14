import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;

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

        String otp = OTPGenerator.generateOTP();

        request.getSession().setAttribute("resetOtp", otp);
        request.getSession().setAttribute("authCodeTimestamp", Instant.now());

        try {
            String emailSubject = "Your Password Reset Code"; 
            MailSender.sendOTP(email, otp, emailSubject);

            request.setAttribute("success", "Un code OTP a été envoyé à votre adresse e-mail.");
        } catch (MessagingException e) {
            e.printStackTrace();
            request.setAttribute("error", "Erreur lors de l'envoi de l'e-mail. Veuillez réessayer.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("otpEntry.jsp");
        rd.forward(request, response);
    }
}
