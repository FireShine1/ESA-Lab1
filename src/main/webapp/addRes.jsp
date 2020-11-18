<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Add Restaurants</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="form">
		<h2>Add/Edit Restaurant</h2>
		<form action="addRes" method="post">
			<input type="hidden" name="id" value=${restaurant.id}>
			<div>
				<label for="name">Name</label>
				<input type="text" name="name" id="name" class="input" placeholder="Cool Restaurant" required maxlength="255" value="${restaurant.name}">
			</div>
			<div>
				<label for="cook">Type</label>
				<input type="text" name="cook" id="cook" class="input" placeholder="Tasty" required maxlength="255" value="${restaurant.cookery}">
			</div>
			<div>
				<label for="addr">Address</label>
				<input type="text" name="addr" id="addr" class="input" placeholder="Universe, planet Earth" required maxlength="255" value="${restaurant.address}">
			</div>
			<div>
				<label for="dishes">List of dishes</label>
				<select name="dishes" id="dishes" size="4" multiple required>
					<c:choose>
						<c:when test="${restaurant == null}">
							<c:forEach items="${dishes}" var="dish">
								<option value=${dish.id}>${dish.name}</option>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach items="${restaurant.dishes}" var="dish">
								<option selected value=${dish.id}>${dish.name}</option>
							</c:forEach>
							<c:forEach items="${removedDishes}" var="dish">
								<option value=${dish.id}>${dish.name}</option>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</select>
			</div>
			<div class="buttongroup">
				<button class="btn btn-form" type="submit">Confirm</button>
				<button class="btn" onclick="location.href='restaurants'">Cancel</button>
			</div>
		</form>
	</div>
</body>