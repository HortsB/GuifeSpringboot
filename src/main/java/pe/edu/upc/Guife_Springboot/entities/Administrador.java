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
@Table(name = "Administrator")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAdministrador;

	@NotEmpty(message = "Ingresa el nick")
	@Column(name = "nickNameAdministrador", nullable = false, length = 20)
	private String nickNameAdministrador;

	@NotEmpty(message = "Ingresa Email")
	@Email
	@Column(name = "mailAdministrador", nullable = false, length = 20)
	private String mailAdministrador;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingresa un número valido")
	@Column(name = "phoneAdministrador", nullable = false, length = 9)
	private String phoneAdministrador;

	@NotEmpty(message = "Ingresa una contraseña")
	@Column(name = "passwordAdministrador", nullable = false, length = 40)
	private String passwordAdministrador;

	@ManyToOne
	@JoinColumn(name = "idPerson")
	private Person person;

	public Administrador() {
		super();
	}

	public Administrador(int idAdministrador, @NotEmpty(message = "Ingresa el nick") String nickNameAdministrador,
			@NotEmpty(message = "Ingresa Email") @Email String mailAdministrador,
			@Size(min = 9, max = 9) @NotEmpty(message = "Ingresa un número valido") String phoneAdministrador,
			@NotEmpty(message = "Ingresa una contraseña") String passwordAdministrador, Person person) {
		super();
		this.idAdministrador = idAdministrador;
		this.nickNameAdministrador = nickNameAdministrador;
		this.mailAdministrador = mailAdministrador;
		this.phoneAdministrador = phoneAdministrador;
		this.passwordAdministrador = passwordAdministrador;
		this.person = person;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNickNameAdministrador() {
		return nickNameAdministrador;
	}

	public void setNickNameAdministrador(String nickNameAdministrador) {
		this.nickNameAdministrador = nickNameAdministrador;
	}

	public String getMailAdministrador() {
		return mailAdministrador;
	}

	public void setMailAdministrador(String mailAdministrador) {
		this.mailAdministrador = mailAdministrador;
	}

	public String getPhoneAdministrador() {
		return phoneAdministrador;
	}

	public void setPhoneAdministrador(String phoneAdministrador) {
		this.phoneAdministrador = phoneAdministrador;
	}

	public String getPasswordAdministrador() {
		return passwordAdministrador;
	}

	public void setPasswordAdministrador(String passwordAdministrador) {
		this.passwordAdministrador = passwordAdministrador;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
