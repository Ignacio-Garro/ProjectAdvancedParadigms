package hr.algebra.studentprojectapiinteropability.service;

import hr.algebra.studentprojectapiinteropability.domain.Grades;

import java.util.List;
import java.util.Optional;

public interface GradesService {
    public List<Grades> getAllGrades();

    public Optional<Grades> getGradesById(Long id);

    public void addGrades(Grades student);

    public void updateGrades(Long id, Grades updatedStudent);

    public void deleteGrades(Long id);
}
