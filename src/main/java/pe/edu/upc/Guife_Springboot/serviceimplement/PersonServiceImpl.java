package pe.edu.upc.guife.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.guife.entities.Person;
import pe.edu.upc.guife.repositories.IPersonRepository;
import pe.edu.upc.guife.serviceinterface.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired
	private IPersonRepository pRepository;
	
	@Override
	public void insert(Person person) {
		// TODO Auto-generated method stub
		pRepository.save(person);
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return pRepository.findAll();
	}

	@Override
	public void delete(int idPerson) {
		// TODO Auto-generated method stub
		pRepository.deleteById(idPerson);
	}

	@Override
	public Optional<Person> listId(int idPerson) {
		// TODO Auto-generated method stub
		return pRepository.findById(idPerson);
	}

	
	
}
