<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Validation du Code</title>
    <link rel="stylesheet" href="welcome_css.css"> <!-- Lien vers le fichier CSS -->
</head>
<body>
    <div class="validation-container">
        <div class="header">
            <img src="images/ensias.jpg" alt="Logo" class="logo">
             <h3>Authentification Etape 2 </h3>
             <h1>Veuillez verifier votre boite e-mail.</h1>
        </div>
        <form action="ValidateCodeServlet" method="post" class="form">
            <label for="code">Entrez le code de vérification :</label>
            <input type="text" id="code" name="code" class="input" placeholder="Code à 6 chiffres" required>
            <button type="submit" class="btn">Valider</button>
        </form>
        <c:if test="${not empty param.error}">
            <p class="error-message">${param.error}</p>
        </c:if>
    </div>
</body>
</html>
