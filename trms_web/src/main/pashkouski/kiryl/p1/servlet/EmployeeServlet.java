package main.pashkouski.kiryl.p1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.pashkouski.kiryl.p1.dao.EmployeeDAO;
import main.pashkouski.kiryl.p1.domain.Employee;

public class EmployeeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmployeeDAO employeeDAO = new EmployeeDAO ();
	Employee e = new Employee ();
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<p>Servlet starts here</p>");
		String lastName = request.getParameter("lname");
		String firstName = request.getParameter("fname");
		e.setFirstName(firstName);
		e.setLastName(lastName);
		pw.println("<p>First Name: " + e.getFirstName() + "</p>");
		pw.println("<p>Last Name: " + e.getLastName() + "</p>");
		
		employeeDAO.saveEmployee(e);
		
		pw.println("<html><body><b>Successfully Inserted"
                + "</b></body></html>");
	}

}
