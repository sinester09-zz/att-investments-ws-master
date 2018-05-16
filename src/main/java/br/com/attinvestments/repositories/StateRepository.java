package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
