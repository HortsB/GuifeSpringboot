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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reminder")
public class Reminder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReminder;
	@NotNull(message = "Añadir un indicador")
	@Column(name = "timeReminder", nullable = false)
	private String timeReminder;
	@SuppressWarnings("static-access")
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME.TIMESTAMP)
	private Date alarmReminder;
	@ManyToOne
	@JoinColumn(name = "idTask")
	private Task task;

	public Reminder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reminder(int idReminder, String timeReminder, Date alarmReminder) {
		super();
		// TODO Auto-generated constructor stub
		this.idReminder = idReminder;
		this.timeReminder = timeReminder;
		this.alarmReminder = alarmReminder;

	}

	public int getIdReminder() {
		return idReminder;
	}

	public void setIdReminder(int idReminder) {
		this.idReminder = idReminder;
	}

	public String getTimeReminder() {
		return timeReminder;
	}

	public void setTimeReminder(String timeReminder) {
		this.timeReminder = timeReminder;
	}

	public Date getAlarmReminder() {
		return alarmReminder;
	}

	public void setAlarmReminder(Date alarmReminder) {
		this.alarmReminder = alarmReminder;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
