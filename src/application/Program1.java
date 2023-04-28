package application;


import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 findById");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("=== TEST 2 findAll");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        /*
        System.out.println("=== TEST 3 insert");
        dep = new Department(null, "D3");
        departmentDao.insert(dep);
        System.out.println("Insert completed! Id = " + dep.getId());

         */

        System.out.println("=== TEST 4 update");
        dep = departmentDao.findById(6);
        dep.setName("HQs");
        departmentDao.update(dep);
        System.out.println("Update completed!");

        System.out.println("=== TEST 5 delete");
        System.out.print("Enter the ID code: ");
        int id = tc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");





    }
}
