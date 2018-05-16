package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
