package com.cdac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
														//Entity   //Datatype of the primary key
//public interface ProductRepository extends CrudRepository<Product, Integer>{
	public interface ProductRepository extends JpaRepository<Product, Integer>{
		
}
