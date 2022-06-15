package pe.edu.upc.guife.serviceinterface;

import java.util.List;

import pe.edu.upc.guife.entities.Role;

public interface IRoleService {

	public void insertar(Role r);
	List<Role>listar();
}
