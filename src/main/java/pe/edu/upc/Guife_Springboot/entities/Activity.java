package pe.edu.upc.Guife_Springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idActivity;
	@NotEmpty(message = "Seleccione un tipo")
	@Column(name = "typeActivity", nullable = false)
	private String typeActivity;
	@NotEmpty(message = "Seleccione una prioridad")
	@Column(name = "priorityActivity", nullable = false)
	private String priorityActivity;
	@NotEmpty(message = "Seleccione un frecuencia para la actividad")
	@Column(name = "frecuentActivity", nullable = false)
	private String frecuentActivity;

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activity(int idActivity, @NotEmpty(message = "Seleccione un tipo") String typeActivity,
			@NotEmpty(message = "Seleccione una prioridad") String priorityActivity,
			@NotEmpty(message = "Seleccione un frecuencia para la actividad") String frecuentActivity) {
		super();
		this.idActivity = idActivity;
		this.typeActivity = typeActivity;
		this.priorityActivity = priorityActivity;
		this.frecuentActivity = frecuentActivity;
	}

	public int getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public String getTypeActivity() {
		return typeActivity;
	}

	public void setTypeActivity(String typeActivity) {
		this.typeActivity = typeActivity;
	}

	public String getPriorityActivity() {
		return priorityActivity;
	}

	public void setPriorityActivity(String priorityActivity) {
		this.priorityActivity = priorityActivity;
	}

	public String getFrecuentActivity() {
		return frecuentActivity;
	}

	public void setFrecuentActivity(String frecuentActivity) {
		this.frecuentActivity = frecuentActivity;
	}

}
