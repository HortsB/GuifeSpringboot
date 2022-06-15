package pe.edu.upc.guife.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.guife.entities.Customer;

public interface ICustomerService {

	public void insert(Customer customer);

	List<Customer> lista();

	Optional<Customer> listId(int idCustomer);

	public void delete(int idCustomer);
}
