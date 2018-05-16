package br.com.attinvestments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.attinvestments.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional(readOnly=true)
	User findByUsername(String username);
	
	@Transactional(readOnly=true)
	User findByUsernameAndEmail(String username, String email);
	
	@Transactional(readOnly=true)
	User findByEmail(String email);
	
	@Transactional(readOnly=true)
	User findByPassword(String password);

}
