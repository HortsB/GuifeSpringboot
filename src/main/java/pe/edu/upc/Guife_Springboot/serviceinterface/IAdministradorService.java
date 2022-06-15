package pe.edu.upc.guife.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.guife.entities.Administrador;

public interface IAdministradorService {
	
	public void insert(Administrador admin);
	
	List<Administrador> lista();
	
	Optional<Administrador> listId(int idAdministrador);
	
	public void delete(int idAdministrador);

}
