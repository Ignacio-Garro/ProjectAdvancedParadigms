package hr.algebra.studentprojectapiinteropability.datainitializer;

import hr.algebra.studentprojectapiinteropability.domain.Grades;
import hr.algebra.studentprojectapiinteropability.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hr.algebra.studentprojectapiinteropability.domain.Student;
import hr.algebra.studentprojectapiinteropability.service.StudentService;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GradesService GradeService;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(
                1L,
                "Doe",
                "doe@gmail.com",
                "1.jpg");

        Student student2 = new Student(
                2L,
                "Joe",
                "joe@gmail.com",
                "2.jpg");

        Student student3 = new Student(
                3L,
                "Moe",
                "moe@gmail.com",
                "3.jpg");

        Student student4 = new Student(
                4L,
                "Alice",
                "alice@gmail.com",
                "4.jpg");

        Student student5 = new Student(
                5L,
                "Bob",
                "bob@gmail.com",
                "5.jpg");

        Student student6 = new Student(
                6L,
                "Charlie",
                "charlie@gmail.com",
                "6.jpg");

        Student student7 = new Student(
                7L,
                "David",
                "david@gmail.com",
                "7.jpg");

        Student student8 = new Student(
                8L,
                "Eve",
                "eve@gmail.com",
                "8.jpg");

        Student student9 = new Student(
                9L,
                "Frank",
                "frank@gmail.com",
                "9.jpg");


        Grades grades1 = new Grades(
                1L,
                85, // mathGrade
                90, // geographyGrade
                78, // historyGrade
                88, // englishGrade
                92  // biologyGrade
        );

        Grades grades2 = new Grades(
                2L,
                75, // mathGrade
                85, // geographyGrade
                80, // historyGrade
                82, // englishGrade
                88  // biologyGrade
        );

        Grades grades3 = new Grades(
                3L,
                90, // mathGrade
                95, // geographyGrade
                85, // historyGrade
                89, // englishGrade
                94  // biologyGrade
        );

        Grades grades4 = new Grades(
                4L,
                70, // mathGrade
                65, // geographyGrade
                60, // historyGrade
                75, // englishGrade
                70  // biologyGrade
        );

        Grades grades5 = new Grades(
                5L,
                88, // mathGrade
                80, // geographyGrade
                82, // historyGrade
                90, // englishGrade
                86  // biologyGrade
        );

        Grades grades6 = new Grades(
                6L,
                92, // mathGrade
                89, // geographyGrade
                88, // historyGrade
                95, // englishGrade
                90  // biologyGrade
        );

        Grades grades7 = new Grades(
                7L,
                78, // mathGrade
                76, // geographyGrade
                75, // historyGrade
                80, // englishGrade
                82  // biologyGrade
        );

        Grades grades8 = new Grades(
                8L,
                85, // mathGrade
                87, // geographyGrade
                90, // historyGrade
                85, // englishGrade
                88  // biologyGrade
        );

        Grades grades9 = new Grades(
                9L,
                65, // mathGrade
                70, // geographyGrade
                68, // historyGrade
                72, // englishGrade
                70  // biologyGrade
        );



        // Insert initial students into the database
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);
        studentService.addStudent(student5);
        studentService.addStudent(student6);
        studentService.addStudent(student7);
        studentService.addStudent(student8);
        studentService.addStudent(student9);

        GradeService.addGrades(grades1);
        GradeService.addGrades(grades2);
        GradeService.addGrades(grades3);
        GradeService.addGrades(grades4);
        GradeService.addGrades(grades5);
        GradeService.addGrades(grades6);
        GradeService.addGrades(grades7);
        GradeService.addGrades(grades8);
        GradeService.addGrades(grades9);

        System.out.println("Initial data inserted into the database.");
    }
}