package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by Lorena on 7/14/2016.
 */

@MyController(urlPath = "/employees")
public class EmployeeController {

    @MyRequestMethod(urlPath = "/all")
    public String getAllEmployees(){
        String allEmployees = "allEmployees";
        return  allEmployees;
    }

    @MyRequestMethod(urlPath = "/one")
    public String getOneEmployee(){
        String oneRandomEmployee = "oneRandomEmployee";
        return oneRandomEmployee;
    }
}
