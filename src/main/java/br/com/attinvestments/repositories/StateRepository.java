package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import br.com.attinvestments.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT s FROM State s WHERE s.code = :id")
	State findById(String id);
	
}
