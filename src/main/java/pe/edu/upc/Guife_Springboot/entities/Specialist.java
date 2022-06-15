package pe.edu.upc.Guife_Springboot.entities;

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
@Table(name = "Specialist")
public class Specialist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSpecialist;

	@NotEmpty(message = "Ingresa el nombre")
	@Column(name = "fullNameSpecialist", nullable = false, length = 45)
	private String fullNameSpecialist;

	@NotEmpty(message = "Ingresa el nick")
	@Column(name = "nickNameSpecialist", nullable = false, length = 45)
	private String nickNameSpecialist;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingresa un número valido")
	@Column(name = "phoneSpecialist", nullable = false, length = 45)
	private String phoneSpecialist;

	@Column(name = "typeSpecialist", nullable = false, length = 45)
	private String typeSpecialist;

	@NotEmpty(message = "Ingresa una contraseña")
	@Column(name = "passwordSpecialist", nullable = false, length = 45)
	private String passwordSpecialist;

	@NotEmpty(message = "Ingresa una descipción")
	@Column(name = "descriptionSpecialist", nullable = false, length = 45)
	private String descriptionSpecialist;

	@ManyToOne
	@JoinColumn(name = "idPerson")
	private Person person;

	public Specialist(int idSpecialist, @NotEmpty(message = "Ingresa el nombre") String fullNameSpecialist,
			@NotEmpty(message = "Ingresa el nick") String nickNameSpecialist,
			@Size(min = 9, max = 9) @NotEmpty(message = "Ingresa un número valido") String phoneSpecialist,
			String typeSpecialist, @NotEmpty(message = "Ingresa una contraseña") String passwordSpecialist,
			@NotEmpty(message = "Ingresa una descipción") String descriptionSpecialist, Person person) {
		super();
		this.idSpecialist = idSpecialist;
		this.fullNameSpecialist = fullNameSpecialist;
		this.nickNameSpecialist = nickNameSpecialist;
		this.phoneSpecialist = phoneSpecialist;
		this.typeSpecialist = typeSpecialist;
		this.passwordSpecialist = passwordSpecialist;
		this.descriptionSpecialist = descriptionSpecialist;
		this.person = person;
	}

	public Specialist() {
		super();
	}

	public int getIdSpecialist() {
		return idSpecialist;
	}

	public void setIdSpecialist(int idSpecialist) {
		this.idSpecialist = idSpecialist;
	}

	public String getFullNameSpecialist() {
		return fullNameSpecialist;
	}

	public void setFullNameSpecialist(String fullNameSpecialist) {
		this.fullNameSpecialist = fullNameSpecialist;
	}

	public String getNickNameSpecialist() {
		return nickNameSpecialist;
	}

	public void setNickNameSpecialist(String nickNameSpecialist) {
		this.nickNameSpecialist = nickNameSpecialist;
	}

	public String getPhoneSpecialist() {
		return phoneSpecialist;
	}

	public void setPhoneSpecialist(String phoneSpecialist) {
		this.phoneSpecialist = phoneSpecialist;
	}

	public String getTypeSpecialist() {
		return typeSpecialist;
	}

	public void setTypeSpecialist(String typeSpecialist) {
		this.typeSpecialist = typeSpecialist;
	}

	public String getPasswordSpecialist() {
		return passwordSpecialist;
	}

	public void setPasswordSpecialist(String passwordSpecialist) {
		this.passwordSpecialist = passwordSpecialist;
	}

	public String getDescriptionSpecialist() {
		return descriptionSpecialist;
	}

	public void setDescriptionSpecialist(String descriptionSpecialist) {
		this.descriptionSpecialist = descriptionSpecialist;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
