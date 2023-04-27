package application;


import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import java.util.List;

public class Program1 {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 findById");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("=== TEST 2 findAll");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("=== TEST 3 insert");
        dep = new Department(null, "D3");
        departmentDao.insert(dep);
        System.out.println("Insert completed! Id = " + dep.getId());





    }
}
