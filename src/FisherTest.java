import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.FishRepDetailHelper;
import model.FishReportDetails;
import model.FishWeightLocationRep;
import model.Fishers;

public class FisherTest {

	public static void main(String[] args) {		
		Fishers Matt = new Fishers("Matt");
		FishRepDetailHelper frh = new FishRepDetailHelper();
		
		FishWeightLocationRep entry1 = new FishWeightLocationRep("Spotted Gar", "7.5", "Des Moines");
		FishWeightLocationRep entry2 = new FishWeightLocationRep("Fresh Water Drum", "9", "Racoon");
		
		List<FishWeightLocationRep> MattsEnteries = new ArrayList<FishWeightLocationRep>();
		MattsEnteries.add(entry1);
		MattsEnteries.add(entry2);
		
		FishReportDetails mattsReport = new FishReportDetails("Matt's Reports", LocalDate.now(), Matt);
		mattsReport.setListOfFish(MattsEnteries);
		
		frh.insertNewListDetails(mattsReport);
		
		List<FishReportDetails> allReports = frh.getLists();
		
		for(FishReportDetails s: allReports) {
			System.out.println(s.toString());
		}
		
	}

}
