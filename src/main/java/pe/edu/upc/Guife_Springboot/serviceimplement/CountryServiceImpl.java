package pe.edu.upc.Guife_Springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Guife_Springboot.entities.Country;
import pe.edu.upc.Guife_Springboot.repositories.ICountryRepository;
import pe.edu.upc.Guife_Springboot.serviceinterface.ICountryService;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private ICountryRepository countryRepository;

	@Override
	public void insert(Country co) {
		// TODO Auto-generated method stub
	countryRepository.save(co);
	}

	@Override
	public List<Country> list() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public void delete(int idCountry) {
		// TODO Auto-generated method stub
		countryRepository.deleteById(idCountry);
	}

	@Override
	public Optional<Country> listId(int idCountry) {
		// TODO Auto-generated method stub
		return countryRepository.findById(idCountry);
	}

	@Override
	public void update(Country coun) {
		// TODO Auto-generated method stub
		countryRepository.save(coun);
	}
	

}
