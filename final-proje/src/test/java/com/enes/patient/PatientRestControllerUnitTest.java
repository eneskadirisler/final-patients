package com.enes.patient;

import com.enes.patient.entity.Patient;
import com.enes.patient.service.PatientService;
import com.enes.patient.web.request.GeneralRequest;
import com.enes.patient.web.request.PatientRemoveRequest;
import com.enes.patient.web.request.PatientSaveRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PatientRestControllerUnitTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAll() throws Exception {
        mockMvc.perform(get("/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.size").value("5"));
    }

    @Test
    void findByCode() throws Exception {

        GeneralRequest request = new GeneralRequest();
        request.setRequestType("Code-1");

        mockMvc.perform(post("/patient-by-code").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.size").value("1"));
    }

    @Test
    void findByLastName() throws Exception {

        GeneralRequest request = new GeneralRequest();
        request.setRequestType("Yilmaz");

        mockMvc.perform(post("/patient-by-lastname").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.size").value("3"));
    }

    @Test
    void findByFirstName() throws Exception {

        GeneralRequest request = new GeneralRequest();
        request.setRequestType("Veli");

        mockMvc.perform(post("/patient-by-firstname").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.size").value("1"));
    }

    @Test
    void findByDiagnosis() throws Exception {

        GeneralRequest request = new GeneralRequest();
        request.setRequestType("Covid-19");

        mockMvc.perform(post("/patient-by-diagnosis").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.size").value("1"));
    }

    @Test
    void save() throws Exception {
        PatientSaveRequest request = new PatientSaveRequest();
        request.setCode("Code-3");
        request.setDiagnosis("Cancer");
        request.setFirstName("Optim");
        request.setLastName("Heysem");


        mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"));
    }

    @Test
    void remove() throws Exception {
        PatientRemoveRequest request =  new PatientRemoveRequest();
        request.setCode("Code-1");


        mockMvc.perform(post("/remove").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"));

    }

    @BeforeEach
    void init() {
        Patient p1 = new Patient();
        p1.setId(1L);
        p1.setFirstName("Veli");
        p1.setLastName("Yilmaz");
        p1.setCode("Code-1");
        p1.setDiagnosis("Covid-19");

        patientService.save(p1);

        Patient p2 = new Patient();
        p2.setId(2L);
        p2.setFirstName("Ersoy");
        p2.setLastName("Yilmaz");
        p2.setCode("Code-2");
        p2.setDiagnosis("Covid-19-Var");

        patientService.save(p2);
    }

}
