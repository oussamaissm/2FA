<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page de Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center text-dark mt-5">Page de Connexion</h2>
                <div class="text-center mb-5 text-dark">Bienvenue ! Connectez-vous pour continuer.</div>
                <div class="card my-5 cardbody-color">
                    <form action="LoginServlet" method="post" class="card-body cardbody-color p-lg-5">
                        <div class="text-center">
                            <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png" 
                                 class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                                 width="200px" alt="profile">
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" id="txtName" name="txtName" 
                                   placeholder="Nom d'utilisateur" required>
                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" id="txtPwd" name="txtPwd" 
                                   placeholder="Mot de passe" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-color px-5 mb-3 w-100">Se connecter</button>
                        </div>
                        <div class="text-center">
                            <a href="forgotPassword.jsp" class="text-dark fw-bold">Mot de passe oublié ?</a>
                        </div>
                        <div id="emailHelp" class="form-text text-center mb-5 text-dark">Pas encore inscrit ? 
                            <a href="register.jsp" class="text-dark fw-bold">Créer un compte</a>
                        </div>
                        <div class="text-danger text-center">${param.error}</div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
