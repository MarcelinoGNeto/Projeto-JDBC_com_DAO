package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== test 01: department findById ==="); //Chama departamento por Id
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== test 02: department findAll ===");  //Chama todos os Departamento
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== test 03: department insert ===");  //Inseri um novo departamento
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());		

		System.out.println("\n=== test 04: department update ===");  //Atualizar um departamento
		department = departmentDao.findById(9);
		department.setName("TV");
		departmentDao.update(department);
		System.out.println("Update Completed");

		System.out.println("\n=== test 05: department delete ===");  //Deleta um departamento
		System.out.println("Enter if for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");

		sc.close();
	}

}
