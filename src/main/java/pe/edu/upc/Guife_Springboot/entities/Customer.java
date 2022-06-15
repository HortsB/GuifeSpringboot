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
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCustomer;

	@ManyToOne
	@JoinColumn(name = "idPerson")
	private Person person;

	@NotEmpty(message = "Ingresa el nick")
	@Column(name = "nickNameCustomer", nullable = false, length = 20)
	private String nickNameCustomer;

	@NotEmpty(message = "Ingresa Email")
	@Email
	@Column(name = "mailCustomer", nullable = false, length = 50)
	private String mailCustomer;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingresa un número valido")
	@Column(name = "phoneCustomer", nullable = false, length = 9)
	private String phoneCustomer;

	@NotEmpty(message = "Ingresa una contraseña")
	@Column(name = "passwordCustomer", nullable = false, length = 40)
	private String passwordCustomer;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int idCustomer, Person person, @NotEmpty(message = "Ingresa el nick") String nickNameCustomer,
			@NotEmpty(message = "Ingresa Email") @Email String mailCustomer,
			@Size(min = 9, max = 9) @NotEmpty(message = "Ingresa un número valido") String phoneCustomer,
			@NotEmpty(message = "Ingresa una contraseña") String passwordCustomer) {
		super();
		this.idCustomer = idCustomer;
		this.person = person;
		this.nickNameCustomer = nickNameCustomer;
		this.mailCustomer = mailCustomer;
		this.phoneCustomer = phoneCustomer;
		this.passwordCustomer = passwordCustomer;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getNickNameCustomer() {
		return nickNameCustomer;
	}

	public void setNickNameCustomer(String nickNameCustomer) {
		this.nickNameCustomer = nickNameCustomer;
	}

	public String getMailCustomer() {
		return mailCustomer;
	}

	public void setMailCustomer(String mailCustomer) {
		this.mailCustomer = mailCustomer;
	}

	public String getPhoneCustomer() {
		return phoneCustomer;
	}

	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}

	public String getPasswordCustomer() {
		return passwordCustomer;
	}

	public void setPasswordCustomer(String passwordCustomer) {
		this.passwordCustomer = passwordCustomer;
	}

}
