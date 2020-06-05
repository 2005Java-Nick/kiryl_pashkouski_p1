package main.pashkouski.kiryl.p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.pashkouski.kiryl.p1.domain.Request;
import pashkouski.kiryl.p1.util.ConnectionFactory;

public class RequestDAOImpl implements RequestDAO {
	
	private static String insertNewRequest = "insert into trms_db.request (last_name, first_name, event_name, requested_amount, start_date) values (?, ?, ?, ?, ?)";
	private static String getAllRequests = "select * from trms_db.request";
	
	public void saveRequest(Request r) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		
		System.out.println("Saving new request >>>");
		
		try {
			stmt = connection.prepareStatement(insertNewRequest);
			stmt.setString(1, r.getLastName());
			stmt.setString(2, r.getFirstName());
			stmt.setString(3, r.getEventName());
			stmt.setString(4, r.getRequestedAmount());
			stmt.setString(5, r.getDate());
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
	
	public List<Request> getRequestList() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		List<Request> requestList = new ArrayList<Request>();
		
		System.out.println("Getting information about request >>>");
		try {
			stmt = connection.prepareStatement(getAllRequests);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				
				Request r = new Request ();
				r.setFirstName(result.getString("first_name"));
				r.setLastName(result.getString("last_name"));
				r.setEventName(result.getString("event_name"));
				r.setDate(result.getString("start_date"));
				r.setRequestedAmount(result.getString("requested_amount"));

				requestList.add(r);
				
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
		
		return requestList;
	}

}
