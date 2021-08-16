package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== test 01: seller findById ==="); //Chama vendedor por Id
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== test 02: seller findByDepartment ===");  //Chama vendedor por Departamento
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== test 03: seller findAll ===");  //Chama todos os vendedores
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== test 04: seller insert ===");  //Inseri um novo vendedor
		Seller newSeller = new Seller(null, "Gred", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());		
		
		System.out.println("\n=== test 05: seller update ===");  //Inseri um novo vendedor
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== test 06: seller delete ===");  //Deleta um novo vendedor
		System.out.println("Enter if for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
