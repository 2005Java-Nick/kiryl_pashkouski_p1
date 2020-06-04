package main.pashkouski.kiryl.p1.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.pashkouski.kiryl.p1.dao.EmployeeDAO;
import main.pashkouski.kiryl.p1.domain.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner (System.in);
//		Employee emp1 = new Employee();
//		
//		System.out.println("Enter last name:");
//		String answer = scanner.nextLine();
//		
//		emp1.setLastName(answer);
//		System.out.println("Enter first name:");
//		answer = scanner.nextLine();
//		emp1.setFirstName(answer);
		
		EmployeeDAO employeeDAO = new EmployeeDAO ();
//		employeeDAO.saveEmployee(emp1);
//		scanner.close();
		
		List<Employee> list = new ArrayList<Employee>();
		
		list = employeeDAO.getEmployeeList();
		System.out.println(list.get(0));
	}

}
