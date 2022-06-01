package pe.edu.upc.Guife_Springboot.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.Guife_Springboot.entities.Specialist;

public interface ISpecialistService {
	public void insert(Specialist specialist);

	List<Specialist> list();
	public void delete (int idSpecialist);
	Optional<Specialist> listId(int idSpecialist);
	public void update(Specialist specialist);
}
