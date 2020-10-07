import java.util.ArrayList;
	import java.util.Scanner;
	import java.io.*;
	public class baseball_homework_analyzer {
		public static int showMenuAndGetChoice(Scanner sc) {
			 System.out.println("Which league would you like to see (enter at bottom)?");
			    System.out.println("1. Al East");
			    System.out.println("2. AL Central");
			    System.out.println("3. Al West");
			    System.out.println("4. NL East");
			    System.out.println("5. NL Central");
			    System.out.println("6. NL West");
			    System.out.println("7. Overall Stats");
			    System.out.println("8. None - I'm done!");
			int choice = sc.nextInt();
			return choice;
		}
		public static double getAverage(String line) {
			String[] parts = line.split("\t");
			double avg = (Integer.parseInt(parts[1]) + 
					Integer.parseInt(parts[2]) + Integer.parseInt(parts[2]))/2.0;
			return avg;
		}
		public static void printStats(ArrayList<String> wins) {
			String [] parts;
			double avg;
			for (String win : wins) {
				parts = win.split("\t");
				avg = getAverage(win);
				System.out.printf("%-10s%6.2f\n",parts[0],avg);
			}
		}
		public static void insertByAverage(ArrayList<String> all, String line) {
			double thisAvg = getAverage(line);
			double otherAvg;
			int pos = -1;
			for (int i = 0; i < all.size(); i++) {
				otherAvg = getAverage(all.get(i));
				if (thisAvg > otherAvg) {     
					pos = i;
					break;   // leaves the loop because the insert location
				}
			}
			if (pos < 0) {
				all.add(line);  // append at the bottom of the list
			} else {
				all.add(pos,line);  // insert the new League (line) at location pos
			}
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter name of file: ");
			String fname = sc.nextLine();
			//what it could possibly read
			ArrayList<String> alEast = new ArrayList<String>();
			ArrayList<String> alCentral = new ArrayList<String>();
			ArrayList<String> alWest = new ArrayList<String>();
			ArrayList<String> nlEast= new ArrayList<String>();
			ArrayList<String> nlCentral = new ArrayList<String>();
			ArrayList<String> nlWest = new ArrayList<String>();
			ArrayList<String> overallStats = new ArrayList<String>();
			ArrayList<String> target = null;
			// option 8
			String line;
			String[] parts;
			String stand;
			boolean canGoAhead;
			int choice;
			try {
				Scanner fsc = new Scanner(new File(fname));
				while (fsc.hasNextLine()) {
					line = fsc.nextLine();
					parts = line.split("\t");
					if (parts[0].equalsIgnoreCase("LEAGUE")) {
						stand = parts[1].toUpperCase();
						if (stand.equalsIgnoreCase("AL East")) {
							target = alEast ;
						} else if (stand.equalsIgnoreCase("AL Central")) {
							target = alCentral;
						} else if (stand.equalsIgnoreCase("AL West")) {
							target = alWest;
						} else if (stand.equalsIgnoreCase("NL East")) {
							target = nlEast;
						} else if (stand.equalsIgnoreCase("NL Central")) {
							target = nlCentral;
						} else if (stand.equalsIgnoreCase("NL West")) {
							target = nlWest;
						}
					} else {
						target.add(line);
						insertByAverage(overallStats,line);
					}
				}
				fsc.close();
				canGoAhead = true;
			} catch (Exception ex) {
				System.out.println("Couldn't read the file.");
				ex.printStackTrace();
				canGoAhead = false;
			}
			if (canGoAhead) {
				do {
					choice = showMenuAndGetChoice(sc);
					if (choice == 1) {
						printStats(alEast);
					} else if (choice == 2) {
						printStats(alCentral);
					} else if (choice == 3) {
						printStats(alWest);
					} else if (choice == 4) {
						printStats(nlEast);
					} else if (choice == 5) {
						printStats(nlCentral);
					} else if (choice == 6) {
						printStats(nlWest);
						
						
					} else if (choice == 7) {
						for (String team : overallStats) {
							System.out.println(team);
						}
					}
				} while (choice != 8);
			}	
		}
	}


