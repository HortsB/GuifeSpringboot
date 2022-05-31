package pe.edu.upc.guife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.guife.entities.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

}
