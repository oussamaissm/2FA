<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page de Connexion</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <!-- Image ajoutée en haut à gauche -->
        <img src="images/ensias.jpg" alt="Logo">

        <!-- Titre de la page -->
        <h2>Authentification Etape 1 </h2>

        <!-- Formulaire de connexion -->
        <form action="LoginServlet" method="post">
            <label for="txtName">Username</label>
            <input type="text" id="txtName" name="txtName" placeholder="Entrez votre nom d'utilisateur" required>
            
            <label for="txtPwd">Password</label>
            <input type="password" id="txtPwd" name="txtPwd" placeholder="Entrez votre mot de passe" required>

            <!-- Message d'erreur -->
            <div class="error-message">
                ${param.error}
            </div>
            
            <input type="submit" value="Se connecter">
        </form>
    </div>
</body>
</html>
