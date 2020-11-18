package ru.fireshine.laba1.eao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ru.fireshine.laba1.utils.Utils;

@Stateless
@LocalBean
public class UtilsBean {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void fillTables() {
		Utils.fillDishesTable().forEach(s -> {
			em.createNativeQuery(s).executeUpdate();
		});
		Utils.fillRestaurantsTable().forEach(s -> {
			em.createNativeQuery(s).executeUpdate();
		});
		Utils.fillRestrauntsDishesTable().forEach(s -> {
			em.createNativeQuery(s).executeUpdate();
		});
	}
	
}
