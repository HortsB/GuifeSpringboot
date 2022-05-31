package pe.edu.upc.guife.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAppointment;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateAppointment", nullable = false)
	private Date dateAppointment;
	
	@Column(name = "descriptionAppointment", nullable = false, length = 100)
	private String descriptionAppointment;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int idAppointment, Date dateAppointment, String descriptionAppointment) {
		super();
		this.idAppointment = idAppointment;
		this.dateAppointment = dateAppointment;
		this.descriptionAppointment = descriptionAppointment;
	}

	public int getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(int idAppointment) {
		this.idAppointment = idAppointment;
	}

	public Date getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(Date dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public String getDescriptionAppointment() {
		return descriptionAppointment;
	}

	public void setDescriptionAppointment(String descriptionAppointment) {
		this.descriptionAppointment = descriptionAppointment;
	}
	
	
}
