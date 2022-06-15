package pe.edu.upc.guife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.guife.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	public Users findByUsername(String username);
}
