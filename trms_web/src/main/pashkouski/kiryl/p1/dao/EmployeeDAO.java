package main.pashkouski.kiryl.p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.pashkouski.kiryl.p1.domain.Employee;
import pashkouski.kiryl.p1.util.ConnectionFactory;

public class EmployeeDAO implements EmployeeDAOImpl {
	
	private static String saveEmployeeQuery = "insert into trms_db.employee (last_name, first_name) values (?, ?)";
	private static String getEmployeeQuery = "select * from trms_db.employee where last_name = ?, first_name = ?";
	private static String getAllEmployeeQuery = "select * from trms_db.employee";

	public void saveEmployee(Employee e) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		
		System.out.println("Saving new employee >>>");
		
		try {
			stmt = connection.prepareStatement(saveEmployeeQuery);
			stmt.setString(1, e.getLastName());
			stmt.setString(2, e.getFirstName());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public Employee getEmployee(String lastName, String firstName) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		
		Employee e = new Employee();
		
		System.out.println("Getting information about employee >>>");
		try {
			stmt = connection.prepareStatement(getEmployeeQuery);
			stmt.setString(1,  lastName);
			stmt.setString(2, firstName);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				e.setLastName(result.getString("last_name"));
				e.setFirstName(result.getString("first_name"));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return e;
	}

	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	public List<Employee> getEmployeeList() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		List<Employee> employeeList = new ArrayList<Employee>();
		
		System.out.println("Getting information about employee >>>");
		try {
			stmt = connection.prepareStatement(getAllEmployeeQuery);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				
				Employee e = new Employee();
				e.setFirstName(result.getString("first_name"));
				e.setLastName(result.getString("last_name"));
				e.setEmail(result.getString("email"));
				employeeList.add(e);
				
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return employeeList;

	}

}
