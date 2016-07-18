package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.service.DepartmentService;
import ro.teamnet.zth.appl.service.DepartmentServiceImpl;

import java.util.List;

/**
 * Created by Lorena on 7/14/2016.
 */

@MyController(urlPath = "/departments")
public class DepartmentController {

    @MyRequestMethod(urlPath = "/all")
    public List<Department> getAllDepartments(){
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> depList = departmentService.findAllDepartments();
        return depList;
    };
}
