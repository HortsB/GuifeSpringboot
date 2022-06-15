package pe.edu.upc.Guife_Springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Guife_Springboot.entities.Reminder;
import pe.edu.upc.Guife_Springboot.repositories.IReminderRepository;
import pe.edu.upc.Guife_Springboot.serviceinterface.IReminderService;

@Service
public class ReminderServiceImpl implements IReminderService{

	@Autowired
	private IReminderRepository rRe;
	@Override
	public void insert(Reminder reminder) {
		// TODO Auto-generated method stub
		rRe.save(reminder);
	}

	@Override
	public List<Reminder> list() {
		// TODO Auto-generated method stub
		return rRe.findAll();
	}

	@Override
	public void delete(int idReminder) {
		// TODO Auto-generated method stub
		rRe.deleteById(idReminder);
	}

	@Override
	public Optional<Reminder> listId(int idReminder) {
		// TODO Auto-generated method stub
		return rRe.findById(idReminder);
	}

	@Override
	public void update(Reminder reminder) {
		// TODO Auto-generated method stub
		rRe.save(reminder);
	}

}
