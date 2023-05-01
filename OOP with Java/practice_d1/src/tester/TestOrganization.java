package tester;

import java.util.Scanner;

import com.app.org.Employee;
import com.app.org.Manager;
import com.app.org.Worker;

public class TestOrganization {

	public static void main(String[] args) {
		int i = 0;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = sc.nextInt();
		Employee[] emp = new Employee[size];

		System.out.println("1.hire manager");
		System.out.println("2.hire worketr");
		System.out.println("3.display all info");
		System.out.println("4.display net salary");

		do {
			System.out.println("Enter choice : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				if (i < size) {
					System.out.println("Enter empid, name, deptid, basicSalary, perfBonus");
					emp[i] = new Manager(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextDouble());
//					System.out.println(emp[i]);
					i++;
				} else {
					System.out.println("array is full");
				}
				break;
			case 2:
				if (i < size) {
					System.out
							.println("Enter Worker Details--empid, name, deptid, basicSalary, hoursWorked, hourlyRate");
					emp[i] = new Worker(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt(),
							sc.nextInt());
//					System.out.println(emp[i]);
					i++;
				}
				break;
			case 3:
				for (Employee e : emp) {
					if (e != null) {
						System.out.println(e);
					}
				}
				break;
			case 4:
				for (Employee e : emp) {
					if (e != null) {
						System.out.println(e.computeNetSalary());
					}
				}
				break;
			default:
				System.out.println("exit");
				break;
			}
//		
//		
		} while (choice != 5);
	}

}
