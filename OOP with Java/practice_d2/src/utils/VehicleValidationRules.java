package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import custom_exceptions.LicenseExpiredException;
import custom_exceptions.SpeedOutOfException;

public class VehicleValidationRules {
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	public static SimpleDateFormat sdf;
	static
	{
		MIN_SPEED=40;
		MAX_SPEED=80;
		sdf=new SimpleDateFormat("yyyy-MM-dd");
	}
	public static void validateSpeed(int speed) throws SpeedOutOfException
	{
		if(speed<MIN_SPEED)
			throw new SpeedOutOfException("speed badhao uncle ..... traffic ho raha hain!!!!");
		if(speed>MAX_SPEED)
			throw new SpeedOutOfException("speed kam karo ..... marna hain kya????");
		System.out.println("sahi raftar me jaa rahe ho! ");
	}
	public static Date validateLicense(String date) throws ParseException, LicenseExpiredException
	{
		Date today=new Date();
		Date expDate=sdf.parse(date);
		if(expDate.after(today))
		return expDate;
		throw new LicenseExpiredException("License Expired");
	}
}
