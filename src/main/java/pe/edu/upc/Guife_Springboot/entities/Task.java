package pe.edu.upc.Guife_Springboot.entities;

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

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTask;
	@NotEmpty(message = "Añadir una descripcion")
	@Column (name="descriptionTask",length=100,nullable = false)
	private String descriptionTask;
	@NotEmpty(message="Añadir un estado")
	@Column(name="statusTask",nullable = false)
	private String statusTask;
	@NotNull(message = "Ingrese una fecha")
	@SuppressWarnings("static-access")
	@DateTimeFormat(pattern="yy-MM-dd")
	@Temporal(TemporalType.DATE.TIMESTAMP)
	@Column(name="dateTask",nullable = false)
	private Date dateTask;
	@ManyToOne
	@JoinColumn(name="idActivity")
	private Activity activity;
	public Task() {
		super();
		//TODO Auto-generated constructor stub
	}
	public Task(int idTask, @NotEmpty(message="Añadir una descripcion") String descriptionTask,
			@NotEmpty(message="Añadir un estado") String statusTask,
			@NotNull(message = "Ingrese una fecha")Date dateTask) {
		super();
		this.idTask=idTask;
		this.descriptionTask=descriptionTask;
		this.statusTask=statusTask;
		this.dateTask=dateTask;
	}
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public String getDescriptionTask() {
		return descriptionTask;
	}
	public void setDescriptionTask(String descriptionTask) {
		this.descriptionTask = descriptionTask;
	}
	public String getStatusTask() {
		return statusTask;
	}
	public void setStatusTask(String statusTask) {
		this.statusTask = statusTask;
	}
	public Date getDateTask() {
		return dateTask;
	}
	public void setDateTask(Date dateTask) {
		this.dateTask = dateTask;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
	
}
