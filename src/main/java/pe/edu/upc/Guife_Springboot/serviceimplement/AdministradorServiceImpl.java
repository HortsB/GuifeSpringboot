package pe.edu.upc.guife.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.guife.entities.Administrador;
import pe.edu.upc.guife.repositories.IAdministradorRepository;
import pe.edu.upc.guife.serviceinterface.IAdministradorService;

@Service
public class AdministradorServiceImpl implements IAdministradorService{

	@Autowired
	private IAdministradorRepository adRepo;
	
	@Override
	public void insert(Administrador admin) {
		// TODO Auto-generated method stub
		adRepo.save(admin);
	}

	@Override
	public List<Administrador> lista() {
		// TODO Auto-generated method stub
		return adRepo.findAll();
	}

	@Override
	public Optional<Administrador> listId(int idAdministrador) {
		// TODO Auto-generated method stub
		return adRepo.findById(idAdministrador);
	}

	@Override
	public void delete(int idAdministrador) {
		// TODO Auto-generated method stub
		adRepo.deleteById(idAdministrador);
	}

}
