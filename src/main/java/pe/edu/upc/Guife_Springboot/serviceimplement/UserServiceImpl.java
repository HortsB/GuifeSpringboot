package pe.edu.upc.guife.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.guife.entities.Users;
import pe.edu.upc.guife.repositories.UserRepository;
import pe.edu.upc.guife.serviceinterface.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository tR;
	@Override
	public void insertar(Users u) {
		tR.save(u);
	}

	@Override
	public List<Users> listar() {
		return tR.findAll();
	}

}
