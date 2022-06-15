package pe.edu.upc.guife.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.guife.entities.Role;
import pe.edu.upc.guife.repositories.IRoleRepository;
import pe.edu.upc.guife.serviceinterface.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository rR;
	@Override
	public void insertar(Role r) {
		// TODO Auto-generated method stub
		rR.save(r);
	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}

}
