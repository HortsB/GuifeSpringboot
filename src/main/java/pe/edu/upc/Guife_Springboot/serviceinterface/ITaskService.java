package pe.edu.upc.Guife_Springboot.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.Guife_Springboot.entities.Task;

public interface ITaskService {
	public void insert(Task task);
	List<Task>list();
	public void delete (int idTask);
	Optional<Task>listId(int idTask);
	public void update(Task task);
}
