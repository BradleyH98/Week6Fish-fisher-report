import java.util.List;
import java.util.Scanner;

import controller.ReportHelper;
import model.FishWeightLocationRep;

public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static ReportHelper rp = new ReportHelper();
	
	private static void addAnEntery() {
		System.out.print("Enter a name of a fish: ");
		String fish = in.nextLine();
		System.out.print("Enter the fishes weight: ");
		String weight = in.nextLine();
		System.out.print("Enter a name of a river: ");
		String river = in.nextLine();
		FishWeightLocationRep toAdd = new FishWeightLocationRep(fish, weight, river);
		rp.insertItem(toAdd);
	}
	
	private static void editAnEntery() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Fish");
		System.out.println("2 : Search by River");
		System.out.println("3 : Search by weight");
		int searchBy = in.nextInt();
		in.nextLine();
		List<FishWeightLocationRep> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the fish: ");
			String fishName = in.nextLine();
			foundItems	=	rp.searchForEnteryByFish(fishName);			
		} else if (searchBy == 2 ){
			System.out.print("Enter the river: ");
			String riverName = in.nextLine();
			foundItems	=	rp.searchForEnteryByRiver(riverName);
		} else {
			System.out.print("Enter the weight: ");
			String weight = in.nextLine();
			foundItems	=	rp.searchForEnteryByWeight(weight);
		}
		
		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (FishWeightLocationRep l : foundItems) {
				System.out.println(l.getDataID() + " : " + l.returnReport());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			FishWeightLocationRep toEdit = rp.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getDataID());
			System.out.println("1 : Update Fish Name");
			System.out.println("2 : Update Fish Weight");
			System.out.println("3 : Update River");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Fish Name: ");
				String newFishName = in.nextLine();
				toEdit.setFishName(newFishName);
			} else if (update == 2) {
				System.out.print("New Fish Weight: ");
				String newFishWeight = in.nextLine();
				toEdit.setFishWeight(newFishWeight);
			} else if (update == 3) {
				System.out.print("New River: ");
				String newRiver = in.nextLine();
				toEdit.setRiver(newRiver);
			}

			rp.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}
	
	private static void deleteAnEntery() {
		System.out.print("Enter a name of a fish to delete: ");
		String fish = in.nextLine();
		System.out.print("Enter the fishes weight to delete: ");
		String weight = in.nextLine();
		System.out.print("Enter a name of a river to delete: ");
		String river = in.nextLine();
		FishWeightLocationRep toDelete = new FishWeightLocationRep(fish, weight, river);
		rp.deleteItem(toDelete);
	}
	
	public static void main(String[] args) {
		runMenu();
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Please choose and a subject to enter in for the fish population or location ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an entery");
			System.out.println("*  2 -- Edit an entery");
			System.out.println("*  3 -- Delete an entery");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnEntery();
			} else if (selection == 2) {
				editAnEntery();
			} else if (selection == 3) {
				deleteAnEntery();
			} else if (selection == 4) {
				viewTheList();
			} else {
				rp.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}
	
	private static void viewTheList() {
		List<FishWeightLocationRep>allItems = rp.showAllItems();
		for(FishWeightLocationRep singleItem : allItems) {
			System.out.println(singleItem.getDataID() + " " + singleItem.returnReport());
		}

	}
	
}
