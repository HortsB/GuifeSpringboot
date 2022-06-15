package pe.edu.upc.Guife_Springboot.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.Guife_Springboot.entities.Reminder;

public interface IReminderService {
	public void insert(Reminder reminder);
	List<Reminder>list();
	public void delete (int idReminder);
	Optional<Reminder>listId(int idReminder);
	public void update(Reminder reminder);
}
	