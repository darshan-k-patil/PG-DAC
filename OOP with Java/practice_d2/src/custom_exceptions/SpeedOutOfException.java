package custom_exceptions;

@SuppressWarnings("serial")
public class SpeedOutOfException extends Exception 
{
	
	public SpeedOutOfException(String mesg)
	{
		super(mesg);
	}

}
