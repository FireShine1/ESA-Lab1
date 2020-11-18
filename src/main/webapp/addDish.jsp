<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Add Dish</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="form">
		<h2>Add/Edit Dish</h2>
		<form action="addDish" method="post">
			<input type="hidden" name="id" value=${dish.id}>
			<div>
				<label for="name">Name</label>
				<input type="text" name="name" id="name" class="input input-dish" placeholder = "Cool Dish" required maxlength="255" value="${dish.name}">
			</div>
			<div>
				<label for="cook">Type</label>
				<input type="text" name="cook" id="cook" class="input input-dish" placeholder = "Tasty" required maxlength="255" value="${dish.cookery}">
			</div>
			<div>
				<label for="ccal">Calorie</label>
				<input type="text" name="ccal" id="ccal" class="input input-dish" placeholder = "75.0" required pattern="[1-9][0-9]*\.[0-9]*" value="${dish.calorie}">
			</div>
			<div>
				<label for="ingr">Ingredients</label>
				<input type="text" name="ingr" id="ingr" class="input input-dish" placeholder = "Some cool ingredients" required maxlength="1024" value="${dish.ingredients}">
			</div>
			<div>
				<label for="price">Price</label>
			<input type="text" name="price" id="price" class="input input-dish" placeholder = "100.0" required pattern="[1-9][0-9]*\.[0-9]*" value="${dish.cost}">
			<div class="buttongroup">
				<button class="btn btn-form" type="submit">Confirm</button>
				<button class="btn" onclick="location.href='dishes'">Cancel</button>
			</div>
		</form>
	</div>
</body>