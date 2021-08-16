package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

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

		
	}

}
