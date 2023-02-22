package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FishReportDetails;
import model.FishWeightLocationRep;
import model.Fishers;

/**
 * Servlet implementation class EditListDetailServlet
 */
@WebServlet("/editListDetailServlet")
public class EditListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		FishRepDetailHelper dao = new FishRepDetailHelper();
		ReportHelper lih = new ReportHelper();
		fisherRepHelper sh = new fisherRepHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		FishReportDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newReportName = request.getParameter("reportName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String fisherName = request.getParameter("fisherName");
		
		//find our add the new shopper
		Fishers newFisher = sh.findFisher(fisherName);
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year),
			Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<FishWeightLocationRep> selectedItemsInList = new ArrayList<FishWeightLocationRep>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out .println(selectedItems[i]);
				FishWeightLocationRep c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			
			listToUpdate.setListOfFish(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<FishWeightLocationRep> selectedItemsInList = new
			ArrayList<FishWeightLocationRep>();
			listToUpdate.setListOfFish(selectedItemsInList);
		}
		
		listToUpdate.setReportName(newReportName);
		listToUpdate.setReportDate(ld);
		listToUpdate.setFisher(newFisher);
		dao.updateReport(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);	}

}
