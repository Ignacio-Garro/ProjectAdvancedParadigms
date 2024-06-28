package hr.algebra.studentprojectapiinteropability.dto;

import hr.algebra.studentprojectapiinteropability.domain.Student;

public class StudentDTO {
    private Long id;
    private String name;
    private String email;

    // Default constructor
    public StudentDTO() {}

    // Parameterized constructor
    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
    }

    // Getter and setter methods
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                '}';
    }
}
