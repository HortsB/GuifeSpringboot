package pe.edu.upc.guife.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.guife.entities.Appointment;

public interface IAppointmentService {
	
	public void insert(Appointment appointment);
	
	List<Appointment> list();
	
	public void delete(int idAppointment);
	
	Optional<Appointment> listId(int idAppointment);
	
	public void update(Appointment appointment);
}
