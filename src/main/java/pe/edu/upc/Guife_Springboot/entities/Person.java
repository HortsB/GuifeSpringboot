package pe.edu.upc.guife.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPerson;

	@NotEmpty(message = "Ingresa el nombre")
	@Column(name = "fullNamePerson", nullable = false, length = 45)
	private String fullNamePerson;

	@NotEmpty(message = "Ingresa el nick")
	@Column(name = "nickNamePerson", nullable = false, length = 20)
	private String nickNamePerson;

	@NotEmpty(message = "Ingresa Email")
	@Email
	@Column(name = "mailPerson", nullable = false, length = 50)
	private String mailPerson;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingresa un número valido")
	@Column(name = "phonePerson", nullable = false, length = 9)
	private String phonePerson;

	@NotEmpty(message = "Ingresa una contraseña")
	@Column(name = "passwordPerson", nullable = false, length = 40)
	private String passwordPerson;

	@ManyToOne
	@JoinColumn(name = "idCountry")
	private Country country;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Person(int idPerson, @NotEmpty(message = "Ingresa el nombre") String fullNamePerson,
			@NotEmpty(message = "Ingresa el nick") String nickNamePerson,
			@NotEmpty(message = "Ingresa Email") @Email String mailPerson,
			@Size(min = 9, max = 9) @NotEmpty(message = "Ingresa un número valido") String phonePerson,
			@NotEmpty(message = "Ingresa una contraseña") String passwordPerson, Country country) {
		super();
		this.idPerson = idPerson;
		this.fullNamePerson = fullNamePerson;
		this.nickNamePerson = nickNamePerson;
		this.mailPerson = mailPerson;
		this.phonePerson = phonePerson;
		this.passwordPerson = passwordPerson;
		this.country = country;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getFullNamePerson() {
		return fullNamePerson;
	}

	public void setFullNamePerson(String fullNamePerson) {
		this.fullNamePerson = fullNamePerson;
	}

	public String getNickNamePerson() {
		return nickNamePerson;
	}

	public void setNickNamePerson(String nickNamePerson) {
		this.nickNamePerson = nickNamePerson;
	}

	public String getMailPerson() {
		return mailPerson;
	}

	public void setMailPerson(String mailPerson) {
		this.mailPerson = mailPerson;
	}

	public String getPhonePerson() {
		return phonePerson;
	}

	public void setPhonePerson(String phonePerson) {
		this.phonePerson = phonePerson;
	}

	public String getPasswordPerson() {
		return passwordPerson;
	}

	public void setPasswordPerson(String passwordPerson) {
		this.passwordPerson = passwordPerson;
	}

}
