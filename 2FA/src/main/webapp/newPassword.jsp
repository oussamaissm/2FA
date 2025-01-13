<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Réinitialiser le Mot de Passe</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center text-dark mt-5">Réinitialiser le Mot de Passe</h2>
				<div class="card my-5 cardbody-color">
					<form action="ResetPasswordServlet" method="post"
						class="card-body cardbody-color p-lg-5">
						<div class="text-center">
							<img
								src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png"
								class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
								width="200px" alt="profile">
						</div>
						<div class="mb-3">
							<label for="newPassword" class="form-label">Nouveau Mot de Passe :</label>
							<input type="password" class="form-control" id="newPassword" name="newPassword" required>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-color px-5 mb-3 w-100">Réinitialiser le Mot de Passe</button>
						</div>
						<!-- Display error or success messages -->
						<div class="text-danger text-center">
							<c:if test="${not empty error}">${error}</c:if>
						</div>
						<div class="text-center">
							<a href="login.jsp" class="text-decoration-none">Retour à la connexion</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
