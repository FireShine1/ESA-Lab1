<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Update Dish</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="form">
		<h2>Update Dish</h2>
		<form action="updDish/update" method="post">
			<input type="hidden" name="id" value=${dish.id}>
			<input type="text" name="name" class="input input-dish" value=${dish.name}>
			<input type="text" name="cook" class="input input-dish" value=${dish.cookery}>
			<input type="text" name="ccal" class="input input-dish" value=${dish.calorie}>	
			<input type="text" name="ingr" class="input input-dish" value=${dish.ingredients}>
			<input type="text" name="price" class="input input-dish" value=${dish.cost}>
			<button class="btn btn-form" type="submit">Update</button>
		</form>
	</div>
</body>