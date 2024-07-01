package hr.algebra.studentprojectapiinteropability.controller;

import hr.algebra.studentprojectapiinteropability.domain.Grades;
import hr.algebra.studentprojectapiinteropability.service.BaseService;
import hr.algebra.studentprojectapiinteropability.service.GradesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradesController extends BaseController<Grades> {

    @Autowired
    private GradesServiceImpl gradesServiceImpl;

    @Override
    protected BaseService<Grades> getService() {
        return gradesServiceImpl;
    }
}
