package hr.algebra.studentprojectapiinteropability.service;

import hr.algebra.studentprojectapiinteropability.domain.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements BaseService<Student>{
    private List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public Optional<Student> getById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public void add(Student student) {
        students.add(student);
    }

    public void update(Long id, Student updatedStudent) {
        getById(id).ifPresent(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setImagePath(updatedStudent.getImagePath());
        });
    }

    public void delete(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
