import java.util.Random;
public class CircleCalc {
	public static void main(String[] args) {
	Random rand = new Random();
	int radius = rand.nextInt(1000);
	double a = Area(radius);
	double c = Circumference(radius);
	System.out.println(a);
	System.out.println("Circumference" + c);}

public static double Area(int radius){
	double a = 3.14 * radius;
			return a;
}

public static double Circumference(int radius) {
		double c = 2*3.14*radius;
	return c;
}
}