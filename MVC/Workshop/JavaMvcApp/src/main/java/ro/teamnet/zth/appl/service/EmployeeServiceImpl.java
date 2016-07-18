package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by Lorena on 7/15/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> findAllEmployees() {

        EmployeeDao empl = new EmployeeDao();
        List<Employee> emplList = empl.getAllEmployees();

        return emplList;
    }

    @Override
    public Employee findOneEmployee(Long id) {

        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(id);
        return employee;
    }



}
