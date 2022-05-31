package pe.edu.upc.Guife_Springboot.serviceinterface;

import java.util.List;

import pe.edu.upc.Guife_Springboot.entities.Specialist;

public interface ISpecialistService {
	public void insert(Specialist specialist);

	List<Specialist> list();
}
