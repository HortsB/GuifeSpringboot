package pe.edu.upc.Guife_Springboot.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.Guife_Springboot.entities.Activity;

public interface IActivityService {
	public void insert(Activity activity);
	List<Activity>list();
	public void delete(int idActivity);
	Optional<Activity>listId(int idActivity);
	public void update(Activity activity);
}
