package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Lorena on 7/8/2016.
 */
public class EntityManagerImplTest {

    EntityManagerImpl entityManager = new EntityManagerImpl();
    static Department dep = new Department();

    @Test
    public void testGetNextIdVal() throws SQLException, ClassNotFoundException {
        EntityManagerImpl entity = new EntityManagerImpl();
        Department dep = new Department();
        Long val = entity.getNextIdVal(EntityUtils.getTableName(Department.class), "department_id");
        assertNotNull(val);

    }


    @Test
    public void dFindAll() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        List<Department> oldDeps = entityManager.findAll(Department.class);
        //add new dep
        dep.setDepartmentName("test unitar");
        entityManager.insert(dep);
        List<Department> newDeps = entityManager.findAll(Department.class);

        assertEquals(oldDeps.size(), newDeps.size() - 1);
    }

    @Test
    public void eFindById() throws ClassNotFoundException, SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Integer id = 10;
        Department rezultat = entityManager.findById(Department.class, id.longValue());
        Assert.assertNotNull(rezultat);
    }

    @Test
    public void aTestInsert() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        dep.setDepartmentName("test unitar");
        entityManager.insert(dep);

        assertEquals(entityManager.findById(Department.class, Long.valueOf(dep.getId())), dep);
    }
}
