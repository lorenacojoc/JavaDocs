package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.InjectService;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.service.EmployeeService;
import ro.teamnet.zth.appl.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by Lorena on 7/14/2016.
 */

@MyController(urlPath = "/employees")
public class EmployeeController {
//
//    private  final EmployeeService employeeService = null;
//
//    @InjectService
//    public EmployeeController(EmployeeService employeeService) {
//        employeeService = employeeService;
//    }


    @MyRequestMethod(urlPath = "/all")
    public List<Employee> getAllEmployees(){

        EmployeeService emplService = new EmployeeServiceImpl();
        List<Employee> list = emplService.findAllEmployees();
        return list;
    }

    @MyRequestMethod(urlPath = "/one")
    public Employee getOneEmployee(@MyRequestParam(name="id") Long id){

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.findOneEmployee(id);

        return employee;
    }

    @MyRequestMethod(urlPath = "/delete" ,methodType = "delete")
    public void deleteOneEmployee(@MyRequestParam(name = "id") Long id){

        Employee employee = getOneEmployee(id);
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.deleteEmployee(employee);

    }

    @MyRequestMethod(urlPath = "/put")
    public void saveEmployee(){
        Employee employee = new Employee();
//        employee.setFirstName("Lorena");
//        employee.setLastName("Cojoc");
//        employee.setEmail("jffjksda");
//        java.sql.Date date = new java.sql.Date(20-04-16);
//        employee.setHireDate(date);
        EmployeeDao newEmployee = new EmployeeDao();
        newEmployee.insertEmployee(employee);

    }
}
