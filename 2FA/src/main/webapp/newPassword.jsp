<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enter New Password</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional for styling -->
</head>
<body>
    <div class="container">
        <h2>Enter Your New Password</h2>
        
        <!-- Display error or success messages -->
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form action="ResetPasswordServlet" method="post">
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
            
            <button type="submit">Reset Password</button>
        </form>
        
        <p><a href="login.jsp">Back to Login</a></p>
    </div>
</body>
</html>
