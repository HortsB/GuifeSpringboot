package pe.edu.upc.Guife_Springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Guife_Springboot.entities.Activity;
import pe.edu.upc.Guife_Springboot.repositories.IActivityRepository;
import pe.edu.upc.Guife_Springboot.serviceinterface.IActivityService;

@Service
public class ActivityServiceImpl implements IActivityService{

	@Autowired
	private IActivityRepository acR;
	@Override
	public void insert(Activity activity) {
		// TODO Auto-generated method stub
		acR.save(activity);
	}

	@Override
	public List<Activity> list() {
		// TODO Auto-generated method stub
		return acR.findAll();
	}

	@Override
	public void delete(int idActivity) {
		// TODO Auto-generated method stub
		acR.deleteById(idActivity);
	}

	@Override
	public Optional<Activity> listId(int idActivity) {
		// TODO Auto-generated method stub
		return acR.findById(idActivity);
	}

	@Override
	public void update(Activity activity) {
		// TODO Auto-generated method stub
		acR.save(activity);
	}

	@Override
	public List<String[]> NTaskPerActivity() {
		// TODO Auto-generated method stub
		return acR.NTaskPerActivity();
	}
}
