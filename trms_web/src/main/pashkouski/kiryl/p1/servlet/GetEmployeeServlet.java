package main.pashkouski.kiryl.p1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.pashkouski.kiryl.p1.dao.EmployeeDAO;
import main.pashkouski.kiryl.p1.dao.LoginDAOImpl;
import main.pashkouski.kiryl.p1.domain.Employee;

public class GetEmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EmployeeDAO employeeDAO = new EmployeeDAO ();
	LoginDAOImpl loginDAO = new LoginDAOImpl ();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String string = request.getReader().readLine();
		
		string = string.replaceAll("\"", "");
		int n = string.indexOf(',');
		String username = string.substring(1, n);
		System.out.println(username);
		String password = string.substring(n+1, string.length() - 1);
		System.out.println(password);

		System.out.println(request.getParameter("username"));
		Employee e = loginDAO.getEmployeeByLogin(username, password);
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(e));
	}
}
