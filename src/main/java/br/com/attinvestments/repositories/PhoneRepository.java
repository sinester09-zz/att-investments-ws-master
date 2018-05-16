package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
