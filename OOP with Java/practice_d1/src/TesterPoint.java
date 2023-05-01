import java.util.Scanner;

public class TesterPoint {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter co-ordinates x and y : ");
		Point2D P1=new Point2D(sc.nextDouble(), sc.nextDouble());
		
		System.out.println("Enter co-ordinates x and y : ");
		Point2D P2=new Point2D(sc.nextDouble(), sc.nextDouble());
		
		System.out.println(P1.getDetails());
		System.out.println(P2.getDetails());
		
		System.out.println("Check eual status : "+P1.isEqual(P1, P2));
		
		System.out.println("Distance : "+P1.distance(P1, P2));
	}

}
