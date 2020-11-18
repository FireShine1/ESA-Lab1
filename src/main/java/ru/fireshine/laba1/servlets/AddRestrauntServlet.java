package ru.fireshine.laba1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.fireshine.laba1.eao.DishEAO;
import ru.fireshine.laba1.eao.RestaurantEAO;
import ru.fireshine.laba1.model.Dish;
import ru.fireshine.laba1.model.Restaurant;

@WebServlet(name = "AddRestrauntServlet", urlPatterns = {"/addRes"})
public class AddRestrauntServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RestaurantEAO restaurantBean;
	@EJB
	private DishEAO dishBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setAttribute("dishes", dishBean.findAll());
		if (req.getParameter("edit") != null) {
			Restaurant rest = restaurantBean.findById(Long.parseLong(req.getParameter("edit")));
			req.setAttribute("restaurant", rest);
			List<Dish> dishesWithoutResDishes = dishBean.findAll();
			List<Dish> temp = new ArrayList<>();
			dishesWithoutResDishes.forEach(d -> {
				rest.getDishes().forEach(rd -> {
					if (d.getId() == rd.getId()) {
						temp.add(d);
					}
				});
			});
			dishesWithoutResDishes.removeAll(temp);
			req.setAttribute("removedDishes", dishesWithoutResDishes);
		}
		req.getRequestDispatcher("addRes.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String cookery = req.getParameter("cook");
		String address = req.getParameter("addr");
		String dishesId[] = req.getParameterValues("dishes");
		HashSet<Dish> dishes = new HashSet<Dish>();
		for (String dishId : dishesId) {
			Long id = Long.parseLong(dishId);
			dishes.add(dishBean.findById(id));
		}
		if (req.getParameter("id") != "" && !req.getParameter("id").isEmpty()) {
			Restaurant rest = restaurantBean.findById(Long.parseLong(req.getParameter("id")));
			rest.setName(name);
			rest.setCookery(cookery);
			rest.setAddress(address);
			rest.setDishes(dishes);
			restaurantBean.update(rest);
		} else {
			restaurantBean.insert(new Restaurant(name, cookery, address, dishes));
		}
		res.sendRedirect(req.getContextPath() + "/restaurants");
	}
	
}