<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un Compte</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <!-- Page Title -->
                <h2 class="text-center text-dark mt-5">Créer un Compte</h2>
                <div class="card my-5 cardbody-color">
                    <!-- Registration Form -->
                    <form action="RegisterServlet" method="post" class="card-body cardbody-color p-lg-5">
                        <div class="text-center">
                            <!-- Profile Image -->
                            <img src="./avatar.webp" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                                width="200" alt="profile">
                        </div>
                        <!-- Username Field -->
                        <div class="mb-3">
                            <input type="text" class="form-control" id="username" name="username" 
                                placeholder="Nom d'utilisateur" required>
                        </div>
                        <!-- Email Field -->
                        <div class="mb-3">
                            <input type="email" class="form-control" id="email" name="email" 
                                placeholder="Adresse email" required>
                        </div>
                        <!-- Password Field -->
                        <div class="mb-3">
                            <input type="password" class="form-control" id="password" name="password" 
                                placeholder="Mot de passe" required>
                        </div>
                        <!-- Confirm Password Field -->
                        <div class="mb-3">
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" 
                                placeholder="Confirmez votre mot de passe" required>
                        </div>
                        <!-- Error Message -->
                        <div class="error-message text-center text-danger mb-3">
                            ${param.error}
                        </div>
                        <!-- Submit Button -->
                        <div class="text-center">
                            <button type="submit" class="btn btn-color px-5 mb-3 w-100">Créer un compte</button>
                        </div>
                        <!-- Login Redirect -->
                        <div class="text-center">
                            <a href="login.jsp" class="btn btn-outline-dark px-5 w-100">Retour à la connexion</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
