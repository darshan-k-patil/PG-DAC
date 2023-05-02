package practice_d3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		LocalDateTime today=LocalDateTime.now();
		System.out.println(today);
		
		
		System.out.println("enter expiry date in format yyyy/MM/dd");
		LocalDate expdate=LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("expiry date date is : "+expdate);
		
		System.out.println("enter date in format dd/MM/yyyy");
		//LocalDate date=LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		//String date1=date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		LocalDate date=LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println("is date between expiry date ? "+Period.between(date, expdate));
		System.out.println("is date between expiry date ? "+date.isAfter(expdate));
		
		
//		System.out.println("enter number of days of expiring");
//		System.out.println("expiry date is : "+date.plusDays(sc.nextLong()));
		
		
	}

}
