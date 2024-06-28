package hr.algebra.studentprojectapiinteropability;

import hr.algebra.studentprojectapiinteropability.domain.Student;
import hr.algebra.studentprojectapiinteropability.service.StudentService;
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
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Test
	public void testGetAllStudents() throws Exception {
		Mockito.when(studentService.getAllStudents()).thenReturn(Arrays.asList(
				new Student(1L, "John Doe", "john.doe@example.com", "1.jpg"),
				new Student(2L, "Jane Doe", "jane.doe@example.com","2.jpg")
		));

		mockMvc.perform(get("/students"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("John Doe"))
				.andExpect(jsonPath("$[1].name").value("Jane Doe"));
	}

	@Test
	public void testGetStudentById() throws Exception {
		Mockito.when(studentService.getStudentById(1L)).thenReturn(Optional.of(new Student(1L, "John Doe", "john.doe@example.com", "1.jpg")));

		mockMvc.perform(get("/students/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("John Doe"));
	}

	@Test
	public void testAddStudent() throws Exception {
		Student newStudent = new Student(null, "John Doe", "john.doe@example.com", "1.jpg");

		mockMvc.perform(post("/students")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
				.andExpect(status().isOk());

		Mockito.verify(studentService, Mockito.times(1)).addStudent(any(Student.class));
	}


	@Test
	public void testUpdateStudent() throws Exception {
		mockMvc.perform(put("/students/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\":\"John Doe Updated\",\"email\":\"john.doe.updated@example.com\"}"))
				.andExpect(status().isOk());

		Mockito.verify(studentService, Mockito.times(1)).updateStudent(anyLong(), any(Student.class));
	}

	@Test
	public void testDeleteStudent() throws Exception {
		mockMvc.perform(delete("/students/1"))
				.andExpect(status().isOk());

		Mockito.verify(studentService, Mockito.times(1)).deleteStudent(1L);
	}





}
