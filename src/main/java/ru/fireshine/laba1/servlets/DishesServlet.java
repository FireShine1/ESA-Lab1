package ru.fireshine.laba1.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.fireshine.laba1.eao.DishEAO;

@WebServlet(name = "DishesServlet", urlPatterns = {"/dishes"})
public class DishesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DishEAO dishBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setAttribute("dishes", dishBean.findAll());
		req.getRequestDispatcher("dishes.jsp").forward(req, res);
	}
	
}