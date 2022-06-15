package pe.edu.upc.guife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.guife.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}
