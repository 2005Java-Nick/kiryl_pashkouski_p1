package main.pashkouski.kiryl.p1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.pashkouski.kiryl.p1.dao.RequestDAO;
import main.pashkouski.kiryl.p1.dao.RequestDAOImpl;
import main.pashkouski.kiryl.p1.domain.Request;

/**
 * Servlet implementation class RequestList
 */
@WebServlet("/RequestList")
public class RequestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestList() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    RequestDAO requestDAO = new RequestDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Request> requestList = requestDAO.getRequestList();
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.getWriter().write(new ObjectMapper().writeValueAsString(requestList));
		System.out.println("Sending data to web page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
