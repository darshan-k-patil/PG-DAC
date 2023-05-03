package utils;

import java.time.LocalDate;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.VehicleHandlingException;

public class VehicleValidationRules {
	
	//add a static method to invoke all validation rules
	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, double basicPrice, 
			LocalDate manufactureDate, String company, Vehicle[] vehicles)
	{
		
		Color validColor=parseAndValidateColor(vehicleColor);
		return 0;
	}
	
	//add a static method to parse n validate color
	public static Color parseAndValidateColor(String clr)
	{
		return Color.valueOf(clr.toUpperCase());
	}
	
	// add a static method to parse n validate manufactureDate
	public static LocalDate parseAndValidateDate(String date) throws VehicleHandlingException
	{
		LocalDate d1=LocalDate.parse(date);
		LocalDate beginYear=LocalDate.of(LocalDate.now().getYear(), 1, 1);
		if(d1.isAfter(beginYear))
			return d1;
		throw new VehicleHandlingException("Vehicle manufacture date must be after 1st Jan of the curnt year");
	}
	
	// No duplicate vehicles should be added in the showroom :
	public static void checkForDupkicate()
}
