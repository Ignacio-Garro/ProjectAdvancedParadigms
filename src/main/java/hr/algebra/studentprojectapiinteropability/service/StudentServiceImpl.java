package hr.algebra.studentprojectapiinteropability.service;

import hr.algebra.studentprojectapiinteropability.domain.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(Long id, Student updatedStudent) {
        getStudentById(id).ifPresent(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setImagePath(updatedStudent.getImagePath());
        });
    }

    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
