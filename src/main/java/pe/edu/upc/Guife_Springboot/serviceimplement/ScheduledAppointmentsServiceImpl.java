package pe.edu.upc.guife.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.guife.entities.ScheduledAppointments;
import pe.edu.upc.guife.repositories.ScheduledAppointmentRepository;
import pe.edu.upc.guife.serviceinterface.IScheduledAppointmentService;

@Service
public class ScheduledAppointmentsServiceImpl implements IScheduledAppointmentService{

	@Autowired
	private ScheduledAppointmentRepository saR;
	
	
	@Override
	public void insert(ScheduledAppointments sApo) {
		// TODO Auto-generated method stub
		saR.save(sApo);
	}

	@Override
	public List<ScheduledAppointments> lista() {
		// TODO Auto-generated method stub
		return saR.findAll();
	}

	@Override
	public void delete(int idsApo) {
		// TODO Auto-generated method stub
		saR.deleteById(idsApo);
	}

	@Override
	public Optional<ScheduledAppointments> listId(int idsApo) {
		// TODO Auto-generated method stub
		return saR.findById(idsApo);
	}

	
	

}
