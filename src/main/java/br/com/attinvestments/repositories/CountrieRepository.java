package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.Countrie;

@Repository
public interface CountrieRepository extends JpaRepository<Countrie, Long> {

}
