package ru.fireshine.laba1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.fireshine.laba1.eao.RestaurantEAO;

@WebServlet(name = "RestaurantsServlet", urlPatterns = {"/restaurants"})
public class RestaurantsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RestaurantEAO restaurantBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setAttribute("restaurants", restaurantBean.findAll());
		req.getRequestDispatcher("restaurants.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cookery = req.getParameter("cookery");
		String dishes[] = req.getParameter("dishesToFind").split(",");
		List<String> dishesList = new ArrayList<>();
		Collections.addAll(dishesList, dishes);
		req.setAttribute("restaurants", restaurantBean.findAll(cookery, dishesList));
		req.getRequestDispatcher("restaurants.jsp").forward(req, res);
	}
	
}