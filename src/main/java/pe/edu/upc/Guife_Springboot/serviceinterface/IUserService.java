package pe.edu.upc.guife.serviceinterface;

import java.util.List;

import pe.edu.upc.guife.entities.Users;

public interface IUserService {

	public void insertar(Users u);
	List<Users> listar();
}
