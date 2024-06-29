package hr.algebra.studentprojectapiinteropability;

import hr.algebra.studentprojectapiinteropability.domain.Student;
import hr.algebra.studentprojectapiinteropability.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@BeforeEach
	void setup() {
		Mockito.reset(studentService);
	}

	@Test
	public void testGetAllStudents() throws Exception {

		Mockito.when(studentService.getAllStudents()).thenReturn(Arrays.asList(
				new Student(1L, "Doe", "doe@gmail.com", "1.jpg"),
				new Student(2L, "Joe", "joe@gmail.com", "2.jpg"),
				new Student(3L, "Moe", "moe@gmail.com", "3.jpg")
		));

		mockMvc.perform(get("/students")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(3))); // Expecting 3 students
	}

	@Test
	public void testGetStudentById() throws Exception {
		Mockito.when(studentService.getStudentById(1L)).thenReturn(Optional.of(
				new Student(1L, "Doe", "doe@example.com", "1.jpg")));

		mockMvc.perform(get("/students/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Doe"));
	}

	@Test
	public void testDeleteStudent() throws Exception {
		mockMvc.perform(delete("/students/1"))
				.andExpect(status().isOk());

		Mockito.verify(studentService, Mockito.times(1)).deleteStudent(1L);
	}
}
