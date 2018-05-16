package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
