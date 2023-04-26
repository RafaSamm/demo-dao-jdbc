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


public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test 1 seller finById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2 seller finByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        list.forEach(System.out::println);

    }
}
