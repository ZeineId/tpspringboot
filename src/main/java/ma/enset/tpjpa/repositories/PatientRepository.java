package ma.enset.tpjpa.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import ma.enset.tpjpa.entitites.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	
	public List<Patient> findByNomContains(String name);
	

	public Patient findById(Integer i);
	
	public List<Patient> findByMalade(boolean b);
	
	public List<Patient> findByNomContainsAndMalade(String name, boolean b);

	public void deleteById(Integer i);
	
	//public void updateById(Integer i);


	public boolean existsById(Integer i);


}

