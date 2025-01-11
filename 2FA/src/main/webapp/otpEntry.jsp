<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enter OTP</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional for styling -->
</head>
<body>
    <div class="container">
        <h2>Enter the OTP</h2>
        
        <!-- Display error or success messages -->
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form action="ValidateOtpServlet" method="post">
            <label for="otp">Enter OTP:</label>
            <input type="text" id="otp" name="otp" required>
            
            <button type="submit">Verify OTP</button>
        </form>
        
        <p><a href="forgotPassword.jsp">Back to Forgot Password</a></p>
    </div>
</body>
</html>
