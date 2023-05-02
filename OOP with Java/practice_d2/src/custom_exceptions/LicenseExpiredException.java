package custom_exceptions;

@SuppressWarnings("serial")
public class LicenseExpiredException extends Exception 
{
	public LicenseExpiredException(String mesg)
	{
		super(mesg);
	}
	
}
