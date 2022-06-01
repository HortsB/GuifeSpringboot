package pe.edu.upc.guife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.guife.entities.Country;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Integer> {

	
}
