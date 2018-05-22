package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.City;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT c FROM City c WHERE c.id = :id")
	City findById(String id);
	
}
