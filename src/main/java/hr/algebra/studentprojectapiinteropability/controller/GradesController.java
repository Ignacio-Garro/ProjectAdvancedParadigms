package hr.algebra.studentprojectapiinteropability.controller;

import hr.algebra.studentprojectapiinteropability.domain.Grades;
import hr.algebra.studentprojectapiinteropability.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
public class GradesController {
    @Autowired
    private GradesService gradesService;



    /**
     * GET /grades
     * Example: GET http://localhost:8080/grades
     */
    @GetMapping
    public List<Grades> getAllGrades() {

        return gradesService.getAllGrades();
    }



    /**
     * GET /grades/{id}
     * Example: GET http://localhost:8080/grades/1
     */
    @GetMapping("/{id}")
    public Optional<Grades> getGradesById(@PathVariable Long id) {

        return gradesService.getGradesById(id);
    }



    /**
     * POST /grades
     * Example:
     * POST http://localhost:8080/grades
     * Body:
     * {
     *     "id": 1,
     *     "mathGrade": 1;
     *     "geographyGrade": 1;
     *     "HistoryGrade": 1;
     *     "EnglishGrade": 1;
     *     "BiologyGrade": 1;
     * }
     */
    @PostMapping
    public void addGrades(@RequestBody Grades grades) {

        gradesService.addGrades(grades);
    }



    /**
     * PUT /grades/{id}
     * Example:
     * PUT http://localhost:8080/grades/1
     * Body:
     * {
     *     "mathGrade": 1;
     *     "geographyGrade": 1;
     *     "HistoryGrade": 1;
     *     "EnglishGrade": 1;
     *     "BiologyGrade": 1;
     * }
     */
    @PutMapping("/{id}")
    public void updateGrades(@PathVariable Long id, @RequestBody Grades grades) {

        gradesService.updateGrades(id, grades);
    }



    /**
     * DELETE /grades/{id}
     * Example: DELETE http://localhost:8080/grades/1
     */
    @DeleteMapping("/{id}")
    public void deleteGrades(@PathVariable Long id) {

        gradesService.deleteGrades(id);
    }
}
