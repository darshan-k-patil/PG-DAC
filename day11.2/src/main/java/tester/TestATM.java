package tester;

import dependency.HttpTransport;
import dependency.SoapTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		ATMImpl atm=new ATMImpl();
		atm.setMyTransport(new SoapTransport());
		atm.deposit(1000);

	}

}
