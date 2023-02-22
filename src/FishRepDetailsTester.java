import model.FishReportDetails;
import model.Fishers;

import java.time.LocalDate;
import java.util.List;

import controller.FishRepDetailHelper;
import controller.fisherRepHelper;

public class FishRepDetailsTester {

	public static void main(String[] args) {
		
		Fishers Matt = new Fishers("Matt");
		fisherRepHelper frh = new fisherRepHelper();
		
		frh.insertFishers(Matt);
		
		FishRepDetailHelper frdh = new FishRepDetailHelper();
		FishReportDetails jaggersReport = new FishReportDetails("Jagger's Report", LocalDate.now(), Matt);
		
		frdh.insertNewListDetails(jaggersReport);
		
		List<FishReportDetails> allLists = frdh.getLists();
		for (FishReportDetails s: allLists) {
			System.out.println(s.toString());
		}

	}

}
