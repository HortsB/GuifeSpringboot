package pe.edu.upc.guife.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.guife.entities.Customer;
import pe.edu.upc.guife.repositories.ICustomerRepository;
import pe.edu.upc.guife.serviceinterface.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepository cRepo;
	
	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		cRepo.save(customer);
	}

	@Override
	public List<Customer> lista() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

	@Override
	public Optional<Customer> listId(int idCustomer) {
		// TODO Auto-generated method stub
		return cRepo.findById(idCustomer);
	}

	@Override
	public void delete(int idCustomer) {
		// TODO Auto-generated method stub
		cRepo.deleteById(idCustomer);
	}

}
