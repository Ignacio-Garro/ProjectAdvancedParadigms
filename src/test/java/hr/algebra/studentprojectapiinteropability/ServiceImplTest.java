package hr.algebra.studentprojectapiinteropability;

import hr.algebra.studentprojectapiinteropability.domain.Grades;
import hr.algebra.studentprojectapiinteropability.domain.Student;
import hr.algebra.studentprojectapiinteropability.service.GradesServiceImpl;
import hr.algebra.studentprojectapiinteropability.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ServiceImplTest {
	//mock the service layer
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentServiceImpl studentServiceImpl;

	@MockBean
	private GradesServiceImpl gradesServiceImpl;

	@BeforeEach
	void setup() {
		Mockito.reset(studentServiceImpl);
	}

	@Test
	public void testGetAllStudents() throws Exception {
		List<Student> students = Arrays.asList(
				new Student(1L, "Doe", "doe@gmail.com", "1.jpg"),
				new Student(2L, "Joe", "joe@gmail.com", "2.jpg"),
				new Student(3L, "Moe", "moe@gmail.com", "3.jpg")
		);

		Mockito.when(studentServiceImpl.getAll()).thenReturn(students);

		mockMvc.perform(get("/students")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(3)));
	}

	@Test
	public void testGetStudentById() throws Exception {
		Student student = new Student(1L, "Doe", "doe@example.com", "1.jpg");

		Mockito.when(studentServiceImpl.getById(1L)).thenReturn(Optional.of(student));

		mockMvc.perform(get("/students/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Doe"));
	}
	@Test
	public void testGetAllGrades() throws Exception {
		List<Grades> grades = Arrays.asList(
				new Grades(1L, 85, 90, 12,88,92),
				new Grades(2L, 54, 45, 78,90,92),
				new Grades(3L, 100, 90, 23,88,87),
				new Grades(3L, 32, 7, 23,12,100)
		);


		Mockito.when(gradesServiceImpl.getAll()).thenReturn(grades);

		mockMvc.perform(get("/grades")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(4)));
	}

	@Test
	public void testGetGradesById() throws Exception {
		Grades grades = new Grades(1L, 85, 90, 12,88,92);

		Mockito.when(gradesServiceImpl.getById(1L)).thenReturn(Optional.of(grades));

		mockMvc.perform(get("/grades/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.mathGrade").value(85));
	}


}
