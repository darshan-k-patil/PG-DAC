package tester;

import java.text.ParseException;
import java.util.Scanner;

import custom_exceptions.LicenseExpiredException;
import custom_exceptions.SpeedOutOfException;

import static utils.VehicleValidationRules.*;
public class TestCustomException {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter running speed");
			validateSpeed(sc.nextInt());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(".......");
		} 
		try
		{
			System.out.println("Enter date in format yyyy-MM-dd");
			validateLicense(sc.next());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(".......");
		} 
		finally
		{
			System.out.println("Bye...");
			sc.close();
		}
		
	}

}
