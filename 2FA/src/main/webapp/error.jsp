<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Erreur</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="styles/error_css.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center text-dark mt-5">Erreur</h2>
				<div class="text-center mb-5 text-dark">Le code de vérification est incorrect. Veuillez réessayer.</div>
				<div class="card my-5 cardbody-color">
					<div class="card-body cardbody-color p-lg-5">
						<div class="text-center">
							<button onclick="window.location.href='welcome.jsp'" class="btn btn-color px-5 mb-3 w-100">Réessayer le code</button>
							<button onclick="window.location.href='login.jsp'" class="btn btn-color px-5 mb-3 w-100">Page de Connexion</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
