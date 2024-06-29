package hr.algebra.studentprojectapiinteropability;

import hr.algebra.studentprojectapiinteropability.domain.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(9));
    }
    @Test
    public void testGetStudentById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Doe")); // Adjust expected values as per your data
    }
}
