package main.pashkouski.kiryl.p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.pashkouski.kiryl.p1.domain.Employee;
import pashkouski.kiryl.p1.util.ConnectionFactory;

public class LoginDAOImpl implements LoginDAO {
	private static String getEmployeeLoginQuery = "select * from trms_db.employee where employee_id = (select employee_id from trms_db.employee_login where username = ? and password = ?)";

	public Employee getEmployeeByLogin(String username, String password) {

			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt;
			
			Employee e = new Employee();
			
			System.out.println("Retrieving information about employee >>>");
			try {
				stmt = connection.prepareStatement(getEmployeeLoginQuery);
				stmt.setString(1, username);
				stmt.setString(2, password);
				
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					e.setId(result.getInt("employee_id"));
					e.setFirstName(result.getString("first_name"));
					e.setLastName(result.getString("last_name"));
					e.setEmail(result.getString("email"));
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
	}
