package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: Department findById =====");
		Department depart = depDao.findById(2);
		System.out.println(depart);
		
		System.out.println("\n=== TEST 2: Department findAll =====");
		List <Department>list = depDao.findAll();
		for(Department s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 3: Department insert =====");
		Department newdepartment = new Department(4, "tec");
		depDao.insert(newdepartment);
		System.out.println("Inserted! New id = " + newdepartment.getId());
		
		
		System.out.println("\n=== TEST 4: Department update =====");
		depart = depDao.findById(5);
		depart.setName("Martha");
		depDao.update(depart);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: Department delete =====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();


	}

}
