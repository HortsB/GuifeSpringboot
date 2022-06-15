package pe.edu.upc.guife.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="roles", uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id","rol"})})
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String rol;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String rol, Users user) {
		super();
		this.id = id;
		this.rol = rol;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
