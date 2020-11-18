package ru.fireshine.laba1.utils;
 
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.transaction.Transactional;
 
@WebListener
public class ContextListener implements ServletContextListener {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
    public void contextInitialized(ServletContextEvent e) {
        em.createNativeQuery(Utils.createDishesTable()).executeUpdate();
        em.createNativeQuery(Utils.createRestaurantsTable()).executeUpdate();
        em.createNativeQuery(Utils.createRestaurantsDishes()).executeUpdate();
    }

    public void contextDestroyed(ServletContextEvent e) {}
    
}