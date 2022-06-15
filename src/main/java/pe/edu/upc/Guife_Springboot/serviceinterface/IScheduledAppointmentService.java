package pe.edu.upc.guife.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.guife.entities.ScheduledAppointments;

public interface IScheduledAppointmentService {
	
	public void insert(ScheduledAppointments sApo);
	
	List<ScheduledAppointments> lista();
	
	public void delete(int idsApo);
	
	Optional<ScheduledAppointments> listId(int idsApo);

}
