package main.pashkouski.kiryl.p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.pashkouski.kiryl.p1.domain.Manager;
import pashkouski.kiryl.p1.util.ConnectionFactory;

public class ManagerDAOImpl implements ManagerDAO {
	
	private static String getManagerLoginQuery = "select * from trms_db.manager where manager_id = (select manager_id from trms_db.manager_login where username = ? and password = ?)";

	public void saveManger(Manager m) {
		// TODO Auto-generated method stub
		
	}

	public Manager getManager(String lastName, String firtstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Manager getManagerByLogin(String username, String password) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		
		Manager m = new Manager();
		
		System.out.println("Retrieving information about manager >>>");
		try {
			stmt = connection.prepareStatement(getManagerLoginQuery);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				m.setId(result.getInt("manager_id"));
				m.setFirstName(result.getString("first_name"));
				m.setLastName(result.getString("last_name"));
				m.setTitle(result.getString("title"));
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
		
		return m;
	}

	public void updateEmployee(Manager m) {
		// TODO Auto-generated method stub
		
	}

	public Manager getEmployeeByLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
