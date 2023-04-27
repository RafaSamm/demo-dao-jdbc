package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test 1 seller finById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2 seller finByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3 seller findAll ===");
        list = sellerDao.findAll();
        list.forEach(System.out::println);


        System.out.println("\n=== Test 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== Test 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        seller.setEmail("martha@gmail.com");
        sellerDao.update(seller);
        System.out.println("Update completed!");





        System.out.println("\n=== Test 6: seller delete ===");
        System.out.print("Enter the code test ID: ");
        int id = tc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");


    }
}
