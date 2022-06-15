package pe.edu.upc.guife.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ScheduledAppointments")
public class ScheduledAppointments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idScheduledAppointments;

	@NotEmpty(message = "Ingresa la descripción")
	@Column(name = "descriptionAppointment", nullable = false, length = 50)
	private String descriptionAppointment;

	@NotNull
	@Past(message = "La fecha debe ser valida")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateAppointment")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateAppointment;

	@Column(name = "TypeSpecialist", nullable = false, length = 30)
	private String TypeSpecialist;

	@ManyToOne
	@JoinColumn(name = "idSpecialist")
	private Specialist specialist;

	@ManyToOne
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	public ScheduledAppointments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduledAppointments(int idScheduledAppointments,
			@NotEmpty(message = "Ingresa la descripción") String descriptionAppointment,
			@NotNull @Past(message = "La fecha debe ser valida") Date dateAppointment, String typeSpecialist,
			Specialist specialist, Customer customer) {
		super();
		this.idScheduledAppointments = idScheduledAppointments;
		this.descriptionAppointment = descriptionAppointment;
		this.dateAppointment = dateAppointment;
		TypeSpecialist = typeSpecialist;
		this.specialist = specialist;
		this.customer = customer;
	}

	public int getIdScheduledAppointments() {
		return idScheduledAppointments;
	}

	public void setIdScheduledAppointments(int idScheduledAppointments) {
		this.idScheduledAppointments = idScheduledAppointments;
	}

	public String getDescriptionAppointment() {
		return descriptionAppointment;
	}

	public void setDescriptionAppointment(String descriptionAppointment) {
		this.descriptionAppointment = descriptionAppointment;
	}

	public Date getDateAppointment() {
		return dateAppointment;
	}

	public void setDateAppointment(Date dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public String getTypeSpecialist() {
		return TypeSpecialist;
	}

	public void setTypeSpecialist(String typeSpecialist) {
		TypeSpecialist = typeSpecialist;
	}

	public Specialist getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
