package hr.algebra.studentprojectapiinteropability;

import hr.algebra.studentprojectapiinteropability.controller.GradesController;
import hr.algebra.studentprojectapiinteropability.domain.Grades;
import hr.algebra.studentprojectapiinteropability.service.GradesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GradesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GradesService gradesService;

    @Test
    public void testGetAllGrades() throws Exception {
        Mockito.when(gradesService.getAllGrades()).thenReturn(Arrays.asList(
                new Grades(1L, 1, 1, 1, 1, 1),
                new Grades(2L, 2, 2, 2, 2, 2)
        ));

        mockMvc.perform(get("/grades"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].mathGrade").value(1))
                .andExpect(jsonPath("$[1].geographyGrade").value(2));
    }

    @Test
    public void testGetGradesById() throws Exception {
        Mockito.when(gradesService.getGradesById(1L)).thenReturn(Optional.of(new Grades(1L, 1, 1, 1, 1, 1)));

        mockMvc.perform(get("/grades/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mathGrade").value(1));
    }

    @Test
    public void testAddGrades() throws Exception {
        Grades newGrades = new Grades(99L, 1, 1, 1, 1, 1);

        // Ignore stubs from DataInitializer
        Mockito.ignoreStubs(gradesService);

        mockMvc.perform(post("/grades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"mathGrade\":1,\"geographyGrade\":1,\"historyGrade\":1,\"englishGrade\":1,\"biologyGrade\":1}"))
                .andExpect(status().isOk());

        Mockito.verify(gradesService, Mockito.times(1)).addGrades(any(Grades.class));
    }

    @Test
    public void testUpdateGrades() throws Exception {
        mockMvc.perform(put("/grades/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"mathGrade\":1,\"geographyGrade\":1,\"historyGrade\":1,\"englishGrade\":1,\"biologyGrade\":1}"))
                .andExpect(status().isOk());

        Mockito.verify(gradesService, Mockito.times(1)).updateGrades(anyLong(), any(Grades.class));
    }

    @Test
    public void testDeleteGrades() throws Exception {
        mockMvc.perform(delete("/grades/1"))
                .andExpect(status().isOk());


        Mockito.verify(gradesService, Mockito.times(1)).deleteGrades(1L);
    }
}