package pe.edu.upc.Guife_Springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Guife_Springboot.entities.Appointment;
import pe.edu.upc.Guife_Springboot.repositories.IAppointmentRepository;
import pe.edu.upc.Guife_Springboot.serviceinterface.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

	@Autowired
	private IAppointmentRepository aRepository;
	
	@Override
	public void insert(Appointment appointment) {
		// TODO Auto-generated method stub
		aRepository.save(appointment);
	}

	@Override
	public List<Appointment> list() {
		// TODO Auto-generated method stub
		return aRepository.findAll();
	}

	@Override
	public void delete(int idAppointment) {
		// TODO Auto-generated method stub
		aRepository.deleteById(idAppointment);
	}

	@Override
	public Optional<Appointment> listId(int idAppointment) {
		// TODO Auto-generated method stub
		return aRepository.findById(idAppointment);
	}

	@Override
	public void update(Appointment appointment) {
		// TODO Auto-generated method stub
		aRepository.save(appointment);
	}

}
