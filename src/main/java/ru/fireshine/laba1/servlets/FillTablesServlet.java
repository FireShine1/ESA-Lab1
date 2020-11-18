package ru.fireshine.laba1.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.fireshine.laba1.eao.UtilsBean;

@WebServlet(name = "FillTablesServlet", urlPatterns = {"/fillTables"})
public class FillTablesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UtilsBean utilsBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		utilsBean.fillTables();
		res.sendRedirect(req.getContextPath() + "/dishes");
	}
	
}