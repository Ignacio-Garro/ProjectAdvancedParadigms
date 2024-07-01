package hr.algebra.studentprojectapiinteropability.controller;

import hr.algebra.studentprojectapiinteropability.domain.Student;
import hr.algebra.studentprojectapiinteropability.service.BaseService;
import hr.algebra.studentprojectapiinteropability.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController<Student> {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Override
    protected BaseService<Student> getService() {
        return studentServiceImpl;
    }
}
