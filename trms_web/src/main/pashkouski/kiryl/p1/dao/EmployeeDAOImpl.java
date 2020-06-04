package main.pashkouski.kiryl.p1.dao;

import java.util.List;

import main.pashkouski.kiryl.p1.domain.Employee;

public interface EmployeeDAOImpl {
	
	public void saveEmployee (Employee e);
	public Employee getEmployee (String lastName, String firtstName);
	public void updateEmployee (Employee e);
	public List<Employee> getEmployeeList ();
	
	// to be added..

}
