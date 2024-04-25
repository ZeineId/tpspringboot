package ma.enset.tpjpa.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.enset.tpjpa.entitites.Patient;
import ma.enset.tpjpa.repositories.PatientRepository;
import ma.enset.tpjpa.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientControleur {

	
	//@Autowired
	//private PatientService patientService;
	@Autowired
	//private PatientRepository patientRepository;
  private PatientService patientService;
	
	@GetMapping("/liste")
	public List<Patient> patients(){
		return patientService.findAlll();
	}
	
	@GetMapping("/nom_patient")
	public Patient patientParNom(@RequestBody String nom) {
		return patientService.findByNom(nom);
	}
	
	@PostMapping("/ajouter")
	public void ajout(@RequestBody Patient p) {
		//patientRepository.save(p);
		patientService.save(p);
	}
	
	
	@DeleteMapping("/supprimer/{i}")
	public String supprime(@PathVariable Integer i) {
		patientService.deleteById(i);
		return "fichier supprimer";
	}
	
	
	
	
	@PutMapping("/modifier/{i}")
	public void modifier(@PathVariable Integer i, @RequestBody Patient p) {
		patientService.updateById(i, p);
	}
	
	
	@GetMapping("/user")
	public String getUser() {
		return "Bienvenue utilisateur";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Bienvenue administrateur";
	}
	
	
}
