package pe.edu.upc.Guife_Springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Guife_Springboot.entities.Task;
import pe.edu.upc.Guife_Springboot.repositories.ITaskRepository;
import pe.edu.upc.Guife_Springboot.serviceinterface.ITaskService;

@Service
public class TaskServiceImpl implements ITaskService{
	@Autowired
	private ITaskRepository tR;
	@Override
	public void insert(Task task) {
		// TODO Auto-generated method stub
		tR.save(task);
	}

	@Override
	public List<Task> list() {
		// TODO Auto-generated method stub
		return tR.findAll();
	}

	@Override
	public void delete(int idTask) {
		// TODO Auto-generated method stub
		tR.deleteById(idTask);
	}

	@Override
	public Optional<Task> listId(int idTask) {
		// TODO Auto-generated method stub
		return tR.findById(idTask);
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		tR.save(task);
	}
	
	
}
