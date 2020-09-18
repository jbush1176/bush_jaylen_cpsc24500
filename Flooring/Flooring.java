package FlooringPackage;

public class Flooring {
	
	double area;
	double price;

	public static void main (String[]args) {
		System.out.println("Flooring");
		
		double Floor1 = 10 * 12;
		double Floor2 = 10 * 12 * .5;
		double Floor3 = 13 * 20;
		double Sum = (Floor1 + Floor2 + Floor3) * 1.2;
		
		double boardArea = 2.5 * .5;
		
		double boardsNeeded = Sum / boardArea;
		
		boardsNeeded = Math.ceil(boardsNeeded);
		double packagesNeeded = boardsNeeded / 6;
		packagesNeeded = Math.ceil(packagesNeeded);
		
		System.out.println("So, we will need to buy this many packages: " + packagesNeeded);
		double Price = calcCost(packagesNeeded);
		System.out.println("Cost: $" + Price + " Dollars");
	}
//calculate number of packages
		
	public static double calcCost(double packages) {
		
		double Price = 24.99 * packages;
		return Price;
	
	}
}
