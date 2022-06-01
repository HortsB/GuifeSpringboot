package pe.edu.upc.Guife_Springboot.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.Guife_Springboot.entities.Country;

public interface ICountryService {
	
	public void insert(Country co);
	List<Country>list();
	public void delete(int idCountry);
	
	Optional<Country> listId(int idCountry);
	public void update(Country coun);

}
