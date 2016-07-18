package ro.teamnet.zth.appl.service;


import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;


import java.util.List;

/**
 * Created by Lorena on 7/15/2016.
 */
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public List<Department> findAllDepartments() {
        DepartmentDao dep = new DepartmentDao();
        List<Department> depList = dep.findAllDepartments();

        return depList;
    }
}
