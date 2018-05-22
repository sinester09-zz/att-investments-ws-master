package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.Countrie;


@Repository
public interface CountrieRepository extends JpaRepository<Countrie, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT c FROM Countrie c WHERE c.code = :id")
	Countrie findById(String id);
	
}
