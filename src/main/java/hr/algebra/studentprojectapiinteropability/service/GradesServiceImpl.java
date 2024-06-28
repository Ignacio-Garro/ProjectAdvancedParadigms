package hr.algebra.studentprojectapiinteropability.service;

import hr.algebra.studentprojectapiinteropability.domain.Grades;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradesServiceImpl implements GradesService {
    private List<Grades> GradesList = new ArrayList<>();

    public List<Grades> getAllGrades() {
        return GradesList;
    }

    public Optional<Grades> getGradesById(Long id) {
        return GradesList.stream().filter(grades -> grades.getId().equals(id)).findFirst();
    }

    public void addGrades(Grades grades) {
        GradesList.add(grades);
    }

    public void updateGrades(Long id, Grades updatedGrades) {
        getGradesById(id).ifPresent(Grades -> {
            Grades.setBiologyGrade(updatedGrades.getBiologyGrade());
            Grades.setEnglishGrade(updatedGrades.getEnglishGrade());
            Grades.setMathGrade(updatedGrades.getMathGrade());
            Grades.setHistoryGrade(updatedGrades.getHistoryGrade());
            Grades.setGeographyGrade(updatedGrades.getGeographyGrade());
        });
    }

    public void deleteGrades(Long id) {
        GradesList.removeIf(grades -> grades.getId().equals(id));
    }
}
