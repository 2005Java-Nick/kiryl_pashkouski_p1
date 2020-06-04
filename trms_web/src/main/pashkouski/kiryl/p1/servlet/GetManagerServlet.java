package main.pashkouski.kiryl.p1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.pashkouski.kiryl.p1.dao.ManagerDAOImpl;
import main.pashkouski.kiryl.p1.domain.Employee;
import main.pashkouski.kiryl.p1.domain.Manager;

/**
 * Servlet implementation class GetManagerServlet
 */
@WebServlet("/GetManagerServlet")
public class GetManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ManagerDAOImpl managerDAO = new ManagerDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String string = request.getReader().readLine();
		
		string = string.replaceAll("\"", "");
		int n = string.indexOf(',');
		String username = string.substring(1, n);
		System.out.println(username);
		String password = string.substring(n+1, string.length() - 1);
		System.out.println(password);

		
		Manager m = managerDAO.getManagerByLogin(username, password);
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(m));
	}

}
