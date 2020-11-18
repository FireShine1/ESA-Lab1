package ru.fireshine.laba1.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.fireshine.laba1.eao.DishEAO;

@WebServlet(name = "DelDishServlet", urlPatterns = {"/delDish"})
public class DelDishServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DishEAO dishBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		dishBean.delete(Long.parseLong(req.getParameter("id")));
		res.sendRedirect(req.getContextPath() + "/dishes");
	}
	
}