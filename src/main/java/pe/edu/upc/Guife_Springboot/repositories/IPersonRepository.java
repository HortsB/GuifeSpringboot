package pe.edu.upc.guife.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.guife.entities.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer>{
	
	@Query(value="Select c.name_country, count(p.id_person) from public.person p join country c on p.id_country=c.id_country group by c.name_country order by count(p.id_person) DESC LIMIT 1", nativeQuery=true)
	public List<String[]>PersonMaxCountry();
	
	@Query(value="Select c.name_country, count(p.id_person) from public.person p join country c on p.id_country=c.id_country group by c.name_country order by count(p.id_person) ASC LIMIT 1", nativeQuery=true)
	public List<String[]>PersonMinCountry();
}
