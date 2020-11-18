package ru.fireshine.laba1.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.fireshine.laba1.eao.DishEAO;
import ru.fireshine.laba1.model.Dish;

@WebServlet(name = "AddDishServlet", urlPatterns = {"/addDish"})
public class AddDishServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DishEAO dishBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		if (req.getParameter("edit") != null) {
			req.setAttribute("dish", dishBean.findById(Long.parseLong(req.getParameter("edit"))));
		}
		req.getRequestDispatcher("addDish.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String cookery = req.getParameter("cook");
		String ingredients = req.getParameter("ingr");
		Double calorie = Double.parseDouble(req.getParameter("ccal"));
		Double cost = Double.parseDouble(req.getParameter("price"));
		if (req.getParameter("id") != "" && !req.getParameter("id").isEmpty()) {
			Dish dish = dishBean.findById(Long.parseLong(req.getParameter("id")));
			dish.setName(name);
			dish.setCookery(cookery);
			dish.setIngredients(ingredients);
			dish.setCalorie(calorie);
			dish.setCost(cost);
			dishBean.update(dish);
		} else {
			dishBean.insert(new Dish(name, cookery, ingredients, calorie, cost));
		}
		res.sendRedirect(req.getContextPath() + "/dishes");
	}
	
}