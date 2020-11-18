package ru.fireshine.laba1.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.fireshine.laba1.eao.RestaurantEAO;

@WebServlet(name = "DelRestaurantServlet", urlPatterns = {"/delRes"})
public class DelRestaurantServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RestaurantEAO restaurantBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		restaurantBean.delete(Long.parseLong(req.getParameter("id")));
		res.sendRedirect(req.getContextPath() + "/restaurants");
	}
	
}