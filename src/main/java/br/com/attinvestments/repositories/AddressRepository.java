package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.Address;
import br.com.attinvestments.domain.Countrie;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	

}
