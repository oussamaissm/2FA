<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mot de Passe Oublié</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center text-dark mt-5">Mot de Passe Oublié</h2>
                <div class="text-center mb-5 text-dark">Entrez votre adresse e-mail pour réinitialiser votre mot de passe.</div>
                <div class="card my-5 cardbody-color">
                    <form action="ForgotPasswordServlet" method="post" class="card-body cardbody-color p-lg-5">
                        <div class="text-center">
                            <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png" 
                                 class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                                 width="200px" alt="profile">
                        </div>
                        <div class="mb-3">
                            <input type="email" class="form-control" id="email" name="email" 
                                   placeholder="Adresse e-mail" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-color px-5 mb-3 w-100">Envoyer le Code</button>
                        </div>
                        <div class="text-danger text-center">${param.error}</div>
                        <div class="text-success text-center">${param.success}</div>
                        <div class="text-center mt-3">
                            <a href="login.jsp" class="text-dark fw-bold">Retour à la connexion</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
