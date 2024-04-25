package ma.enset.tpjpa;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Date;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import ma.enset.tpjpa.entitites.Patient;
import ma.enset.tpjpa.repositories.PatientRepository;
import ma.enset.tpjpa.service.PatientService;

@SpringBootTest
class TpJpaApplicationTests {

	    @Mock
	    private PatientRepository patientRepository;

	    @InjectMocks
	    private PatientService patientService;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testGetAllPatients() {
	        // Créer des données de test
	        Patient patient1 = new Patient(null,"test",new Date(), 200, true);
	        Patient patient2 = new Patient(null,"test2", new Date(), 400, false);
	        List<Patient> patients = Arrays.asList(patient1, patient2);

	     // Définir le comportement du mock pour la méthode findAll() du repository
	        when(patientRepository.findAll()).thenReturn(patients);

	        // Appeler la méthode à tester
	        List<Patient> retrievedPatients = patientService.findAlll();

	        assertEquals(2, retrievedPatients.size());
	        assertEquals("test", retrievedPatients.get(0).getNom());
	        assertEquals(400, retrievedPatients.get(1).getScore());
	        
	    }
}
