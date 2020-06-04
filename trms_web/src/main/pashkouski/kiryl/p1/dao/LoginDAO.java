package main.pashkouski.kiryl.p1.dao;

import main.pashkouski.kiryl.p1.domain.Employee;

public interface LoginDAO {
	
	public Employee getEmployeeByLogin (String username, String password);

}
