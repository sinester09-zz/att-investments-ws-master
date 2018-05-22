package br.com.attinvestments.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.City;
import br.com.attinvestments.domain.Person;
import br.com.attinvestments.domain.User;
@Repository
public interface PersonInfRepository extends JpaRepository<Person, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT u.persons FROM User u WHERE u.email = :eml")
	List<Person> findByEmail(String eml);
	
	@Transactional(readOnly=true)
	@Query("SELECT p FROM Person p WHERE p.personType = :id")
	Person findByIdTypePerson(String id);
	
}
