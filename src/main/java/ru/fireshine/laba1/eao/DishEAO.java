package ru.fireshine.laba1.eao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import ru.fireshine.laba1.model.Dish;

@Stateless
@LocalBean
public class DishEAO {
	
	@PersistenceContext
	private EntityManager em;

	public List<Dish> findAll() {
		Query findAll = em.createQuery("SELECT d FROM Dish d");
		return findAll.getResultList();
	}
	
	public Dish findById(Long id) {
		return em.find(Dish.class, id);
	}
	
	@Transactional
	public void insert(Dish d) {
		em.persist(d);
	}
	
	@Transactional
	public void update(Dish d) {
		em.merge(d);
	}
	
	@Transactional
	public void delete(Long id) {
		Dish d = em.find(Dish.class, id);
		if (d != null) {
			d.getRestaurants().forEach(r -> {
				r.getDishes().remove(d);
			});
			em.createNativeQuery("DELETE FROM RestaurantsDishes WHERE dishId = " + id).executeUpdate();
			em.remove(d);
		}
	}
	
}
