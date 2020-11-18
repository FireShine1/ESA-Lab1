package ru.fireshine.laba1.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Dishes")
public class Dish implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cookery;
	private String name;
	private String ingredients;
	private double calorie;
	private double cost;	
	@ManyToMany(mappedBy = "dishes",
			fetch = FetchType.EAGER)
	private Set<Restaurant> restaurants = new HashSet<Restaurant>();
	
	public Dish() {}
	
	public Dish(String name, String cookery, String ingredients, Double calorie, Double cost) {
		this.name = name;
		this.cookery = cookery;
		this.ingredients = ingredients;
		this.calorie = calorie;
		this.cost = cost;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCookery() {
		return cookery;
	}
	public void setCookery(String cookery) {
		this.cookery = cookery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public double getCalorie() {
		return calorie;
	}
	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}
	
}
