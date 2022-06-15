package pe.edu.upc.Guife_Springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Guife_Springboot.entities.Activity;

@Repository
public interface IActivityRepository extends JpaRepository<Activity, Integer>{

}
