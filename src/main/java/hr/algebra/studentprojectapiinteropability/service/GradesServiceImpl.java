package hr.algebra.studentprojectapiinteropability.service;

import hr.algebra.studentprojectapiinteropability.domain.Grades;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradesServiceImpl implements BaseService<Grades> {
    private List<Grades> GradesList = new ArrayList<>();

    public List<Grades> getAll() {
        return GradesList;
    }

    public Optional<Grades> getById(Long id) {
        return GradesList.stream().filter(grades -> grades.getId().equals(id)).findFirst();
    }

    public void add(Grades grades) {
        GradesList.add(grades);
    }

    public void update(Long id, Grades updatedGrades) {
        getById(id).ifPresent(Grades -> {
            Grades.setBiologyGrade(updatedGrades.getBiologyGrade());
            Grades.setEnglishGrade(updatedGrades.getEnglishGrade());
            Grades.setMathGrade(updatedGrades.getMathGrade());
            Grades.setHistoryGrade(updatedGrades.getHistoryGrade());
            Grades.setGeographyGrade(updatedGrades.getGeographyGrade());
        });
    }

    public void delete(Long id) {
        GradesList.removeIf(grades -> grades.getId().equals(id));
    }
}
