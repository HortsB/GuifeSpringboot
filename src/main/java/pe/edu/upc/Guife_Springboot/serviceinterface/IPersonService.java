package pe.edu.upc.guife.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.guife.entities.Person;

public interface IPersonService {
	public void insert(Person person);

	List<Person> list();

	public void delete(int idPerson);

	Optional<Person> listId(int idPerson);

}
