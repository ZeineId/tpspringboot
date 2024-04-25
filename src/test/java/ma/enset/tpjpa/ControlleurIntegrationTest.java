package ma.enset.tpjpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ControlleurIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllPatients() throws Exception {
        mockMvc.perform(get("/patients/liste"))
                .andExpect(status().isOk());
    }

  

    @Test
    public void testAddPatient() throws Exception {
        mockMvc.perform(post("/patients/ajouter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\":\"zeine\",\"datNaissance\":\"1990-01-01\",\"score\":100,\"malade\":true}"))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdatePatient() throws Exception {
        mockMvc.perform(put("/patients/modifier/1")
    	.contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\":\"John Doe\",\"datNaissance\":\"1990-01-01\",\"score\":100,\"malade\":true}"))
                .andExpect(status().isOk());
    }


    @Test
    public void testDeletePatient() throws Exception {
        mockMvc.perform(delete("/patients/supprimer/1"))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(get("/patients/user"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAdmin() throws Exception {
        mockMvc.perform(get("/patients/admin"))
                .andExpect(status().isOk());
    }

}
