package br.com.attinvestments.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.File;
import br.com.attinvestments.domain.Person;
@Repository
public interface FileRepository extends JpaRepository<File, Long> {

	/*@Transactional(readOnly=true)
	@Query("SELECT u.persons FROM User u WHERE u.email = :eml")
	List<Person> findByEmail(String eml);
	
	
	@Transactional(readOnly=true)
	@Query("SELECT u.email FROM User u join Person p on u.id=p.id WHERE u.email = :eml")
	Person findByEmailUserPerson(String eml);*/
	
	
	
	
	
}
