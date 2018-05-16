package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attinvestments.domain.UserRole;
import br.com.attinvestments.domain.UserRoleId;

@Repository
public interface UserProfileRepository extends JpaRepository<UserRole, UserRoleId> {

}
