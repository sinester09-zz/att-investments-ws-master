package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
