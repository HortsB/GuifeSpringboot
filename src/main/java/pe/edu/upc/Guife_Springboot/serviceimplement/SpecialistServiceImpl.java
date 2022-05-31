package pe.edu.upc.Guife_Springboot.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Guife_Springboot.entities.Specialist;
import pe.edu.upc.Guife_Springboot.repositories.ISpecialistRepository;
import pe.edu.upc.Guife_Springboot.serviceinterface.ISpecialistService;

@Service
public class SpecialistServiceImpl implements ISpecialistService {
	@Autowired
	private ISpecialistRepository sR;

	@Override
	public void insert(Specialist specialist) {
		sR.save(specialist);
	}

	@Override
	public List<Specialist> list() {
		return sR.findAll();
	}
}
