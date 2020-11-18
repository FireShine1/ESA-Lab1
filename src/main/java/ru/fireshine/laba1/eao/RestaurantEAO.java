package ru.fireshine.laba1.eao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import ru.fireshine.laba1.model.Restaurant;

@Stateless
@LocalBean
public class RestaurantEAO {
	
	@PersistenceContext
	private EntityManager em;

	public List<Restaurant> findAll() {
		return findAll(null, null);
	}
	
	public List<Restaurant> findAll(String cookery, List<String> dishes) {
		Query findAll = em.createQuery("SELECT r FROM Restaurant r");
		List<Restaurant> temp = findAll.getResultList();
		List<Restaurant> result = new ArrayList<Restaurant>();
		temp.forEach(r -> {
			boolean passesCookery = (cookery == null || cookery.isEmpty() || cookery == ""
					|| r.getCookery().toLowerCase().contains(cookery.toLowerCase()));
			List<String> dishesNames = new ArrayList<>();
			r.getDishes().forEach(d -> {
				dishesNames.add(d.getName());
			}); 
			boolean passesDishes = (dishes == null || dishes.isEmpty() || dishes.get(0) == ""
					|| dishes.get(0).isEmpty() || dishesNames.containsAll(dishes));
			if (passesCookery && passesDishes) {
				result.add(r);
			}
		});
		return result;
	}

	public Restaurant findById(Long id) {
		return em.find(Restaurant.class, id);
	}
	
	@Transactional
	public void insert(Restaurant r) {
		em.persist(r);
	}
	
	@Transactional
	public void update(Restaurant r) {
		em.merge(r);
	}
	
	@Transactional
	public void delete(Long id) {
		Restaurant r = em.find(Restaurant.class, id);
		if (r != null) {
			em.remove(r);
		}
	}
	
}