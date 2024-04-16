package ma.enset.tpjpa.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import ma.enset.tpjpa.entitites.Patient;
import ma.enset.tpjpa.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> findAlll() {
		return patientRepository.findAll();
	}

	public void save(Patient a) {
		patientRepository.save(a);
	}

	@Transactional
	public void deleteById(Integer i) {
		patientRepository.deleteById(i);
	};

	public Patient findByNom(String nom) {
		return patientRepository.findByNom(nom);
	}

	public void updateById(Integer i, Patient p) {
		Patient patient = patientRepository.findById(i);
		if (patient != null) {
			patient.setNom(p.getNom());
			patient.setDatNaissance(p.getDatNaissance());
			patient.setScore(p.getScore());
			patient.setMalade(p.isMalade());
			patientRepository.save(patient);
		} else {
			throw new EntityNotFoundException("Patient not found with id: " + i);
		}

	}

}