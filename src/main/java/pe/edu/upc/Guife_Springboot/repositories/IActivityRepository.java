package pe.edu.upc.Guife_Springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Guife_Springboot.entities.Activity;

@Repository
public interface IActivityRepository extends JpaRepository<Activity, Integer>{
@Query(value="SELECT a.priority_activity,count(t.id_task)\r\n"
			+ "FROM Activity a\r\n"
			+ "INNER JOIN Task t\r\n"
			+ "ON a.id_activity=t.id_activity\r\n"
			+ "WHERE t.status_task='Activo'\r\n"
			+ "GROUP BY  a.priority_activity;",nativeQuery=true)
	public List<String[]>NTaskPerActivity();
}
