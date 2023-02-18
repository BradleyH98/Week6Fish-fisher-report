package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FishWeightLocationRep;

/**
 * Servlet implementation class addItemsServlet
 */
@WebServlet("/addItemsServlet")
public class addItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addItemsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fishName = request.getParameter("fish");
		String fishWeight = request.getParameter("weight");
		String river = request.getParameter("river");


		FishWeightLocationRep fwl = new FishWeightLocationRep(fishName, fishWeight, river);
		ReportHelper dao = new ReportHelper();
		dao.insertItem(fwl);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
