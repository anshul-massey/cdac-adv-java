package com.cdac;


import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;





import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("productInventory4")
public class ProductInventoryImpl4 implements ProductInventory {
	
	//@Autowired autowired annotation doesn't work in case of injecting EntityManager object 
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void add(Product product) {
	    em.persist(product); //persist will generate insert query
	    
	}

	
	@Override
	public List<Product> getAvailableProducts() {
		return em	
				.createQuery("select p from Product p")
				.getResultList();
		
//	    Query q = em.createQuery("select p from Product p"); //HQL/JPQL
//		List<Product> list = q.getResultList();
	    
//	    return list;
	}

	
}

