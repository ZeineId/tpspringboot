package ma.enset.tpjpa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.enset.tpjpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner{

	
	@Autowired
	private PatientRepository patientRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		patientRepository.save(new Patient(null,"zeine",new Date(),2300,false));
		patientRepository.save(new Patient(null,"toto",new Date(),1000,true));
		patientRepository.save(new Patient(null,"titi",new Date(),2900,true));
		patientRepository.save(new Patient(null,"tata",new Date(),500,false));
		patientRepository.save(new Patient(null,"tata",new Date(),500,false));
		patientRepository.save(new Patient(null,"vde",new Date(),2500,false));

		patientRepository.findAll().forEach(p-> 
		{
	
			System.out.println(p.toString());
		}
				);
		
	System.out.println("*********************");
	
	Patient patient = patientRepository.findById(4L).get();
	System.out.println(patient.getNom());
	
	System.out.println("*********************");
	
	List<Patient> patients = patientRepository.findByNomContains("a");

	patients.forEach(p -> {
		System.out.println(p.toString());
	});
	
	System.out.println("*********************");

	
	List<Patient> patients2 = patientRepository.findByMalade(false);
	
	patients2.forEach(p3 -> {
		System.out.println(p3.toString());
	});
	
	System.out.println("*********************");

	
	
	List<Patient> patients3 = patientRepository.findByNomContainsAndMalade("a" , false);
	
	patients3.forEach(
			p2 ->{
				System.out.println(p2.toString());
			}
			);	
	
	System.out.println("*********************");

	//patientRepository.deleteById(4L);
	
	//pagination : retourne un objet de type Page qui contient  deux patients a partir de la page 0
	Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(0, 2));
	List<Patient> patients4 = pagePatients.getContent();
	patients4.forEach(p -> {
		System.out.println(p.toString());
	});
	
	*/
	
	
}
	
	
}