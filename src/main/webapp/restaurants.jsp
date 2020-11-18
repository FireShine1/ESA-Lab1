<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Restaurants</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="buttongroup">
		<button class="btn" onclick="location.href='dishes'">Dishes</button>
		<button class="btn" onclick="location.href='restaurants'">Restaurants</button>
	</div>
	<hr>
	<form action="restaurants" method="post">
		Filters:
		<label for="cook">Type</label>
		<input type="text" name="cookery" id="cook" class="input" placeholder="Tasty">
		<label for="dishesToFind">Dishes</label>
		<input type="text" name="dishesToFind" id="dishesToFind" class="input" placeholder="Comma-separated list of dishes">
		<button class="btn btn-form" type="submit">Search</button>
		<button class="btn btn-form" type="reset">Clear</button>
	</form>
	<table>
		<tr>
			<th>ID</th> <th>Name</th> <th>Type</th> <th>Address</th> <th>Dishes</th>
		</tr>
		<tbody>
			<c:forEach items="${restaurants}" var="restaurant">
				<tr><td> ${restaurant.id} </td>
				<td> ${restaurant.name} </td>
				<td> ${restaurant.cookery} </td>
				<td> ${restaurant.address} </td>
				<td>
					${restaurant.dishes.toArray()[0].name}
					<c:forEach items="${restaurant.dishes}" var="dish" begin="1">, ${dish.name}</c:forEach>
				<td> <button class="btn" onclick="location.href='addRes?edit=${restaurant.id}'">Update</button> </td>
				<td> <button class="btn" onclick="location.href='delRes?id=${restaurant.id}'">Delete</button> </td></tr>
			</c:forEach>
		</tbody> 
	</table>
	<div class="buttongroup">
		<button class="btn" onclick="location.href='addRes'">Add</button>
	</div>
</body>