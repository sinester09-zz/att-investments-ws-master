package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
