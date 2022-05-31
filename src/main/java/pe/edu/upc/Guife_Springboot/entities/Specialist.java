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
	@Column(name = "fullNameSpecialist", length = 50, nullable = false)
	private String fullNameSpecialist;
	@Column(name = "nickNameSpecialist", length = 40, nullable = false)
	private String nickNameSpecialist;
	@SuppressWarnings("static-access")
	@DateTimeFormat(pattern = "yy-MM-dd")
	@Temporal(TemporalType.DATE.TIMESTAMP)
	@Column(name = "birthSpecialist", nullable = false)
	private Date birthSpecialist;
	@Column(name = "phoneSpecialist", length = 9, nullable = false)
	private String phoneSpecialist;
	@Column(name = "typeSpecialist", length = 45, nullable = false)
	private String typeSpecialist;
	@Column(name = "passwordSpecialist", length = 45, nullable = false)
	private String passwordSpecialist;
	@Column(name = "descriptionSpecialist", length = 100, nullable = false)
	private String descriptionSpecialist;

	public Specialist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialist(int idSpecialist, String fullNameSpecialist, String nickNameSpecialist, Date birthSpecialist,
			String phoneSpecialist, String typeSpecialist, String passwordSpecialist, String descriptionSpecialist) {
		super();
		this.idSpecialist = idSpecialist;
		this.fullNameSpecialist = fullNameSpecialist;
		this.nickNameSpecialist = nickNameSpecialist;
		this.birthSpecialist = birthSpecialist;
		this.phoneSpecialist = phoneSpecialist;
		this.typeSpecialist = typeSpecialist;
		this.passwordSpecialist = passwordSpecialist;
		this.descriptionSpecialist = descriptionSpecialist;
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

	public Date getBirthSpecialist() {
		return birthSpecialist;
	}

	public void setBirthSpecialist(Date birthSpecialist) {
		this.birthSpecialist = birthSpecialist;
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

}
