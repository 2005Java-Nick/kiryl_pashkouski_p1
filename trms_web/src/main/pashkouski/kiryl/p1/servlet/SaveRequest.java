package main.pashkouski.kiryl.p1.servlet;

import java.io.IOException;
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
 * Servlet implementation class SaveRequest
 */
@WebServlet("/SaveRequest")
public class SaveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
    Request r = new Request ();
    RequestDAO requestDAO = new RequestDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		r.setLastName(request.getParameter("lastname"));
		r.setFirstName(request.getParameter("firstname"));
		r.setEventName(request.getParameter("eventtype"));
		r.setDate(request.getParameter("date"));
		r.setRequestedAmount(request.getParameter("amount"));
		
		
		requestDAO.saveRequest(r);
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		response.getWriter().write(new ObjectMapper().writeValueAsString("Saved!"));
		
	}

}
