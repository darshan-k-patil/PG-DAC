package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.app.core.Customer;
import com.app.core.ServicePlan;
import custom_exceptions.CustomerHandlingException;
import static utils.CustomerValidationRules.*;

public class CustomerManagementSystem {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// initializing phase
			// create empty ArrayList : to store customer references
			List<Customer> customerList = new ArrayList<Customer>();
			boolean exit = false;

			// client servicing phase
			while (!exit) {
				System.out.println("Options 1.Sign up \n2.Sign in " + "\n3.Change Password \n4.Un Suscribe Customer"
						+ "\n5.Display all customer \n0.Exit");
				System.out.println("Choose an Option");
				try {
					switch (sc.nextInt()) {
					case 1: // customer registration
						System.out.println("Enter Customer details : First Name, Last Name,"
								+ " Email, Password, Registration Ammount," + " dob(yr-mon-day), Service plan");
						Customer validCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customerList);
						customerList.add(validCustomer);
						System.out.println("Customer registered....");
						break;
					case 2: // sign in
						System.out.println("Enter email n password");
						String email = sc.next();
						String pwd = sc.next();
						// search customer by email : PK
						int index = customerList.indexOf(new Customer(email));
						if (index == -1)
							throw new CustomerHandlingException("Invalid Email, login failed !!!!!");
						// valid email
						validCustomer = customerList.get(index);
						if (validCustomer.getPassword().equals(pwd))
							System.out.println("Successful Login! , your details" + validCustomer);
						// invalid password
						break;
					case 3:
						System.out.println("Enter email and old password : ");
						email = sc.next();
						pwd = sc.next();
						index = customerList.indexOf(new Customer(email));
						if (index == -1)
							throw new CustomerHandlingException("Invalid Email, login failed !!!!!");
						// valid email
						validCustomer = customerList.get(index);
						if (validCustomer.getPassword().equals(pwd))
							System.out.println("Successful Login! , your details" + validCustomer);
						System.out.println("Enter new password");
						validCustomer.setPassword(sc.next());
						System.out.println("Password changed");
						break;
					case 4:
						System.out.println("Enter email and  password : ");
						email = sc.next();
						pwd = sc.next();
						index = customerList.indexOf(new Customer(email));
						if (index == -1)
							throw new CustomerHandlingException("Invalid Email, login failed !!!!!");
						// valid email
						validCustomer = customerList.get(index);
						if (validCustomer.getPassword().equals(pwd))
							System.out.println("Successful Login! , your details" + validCustomer);
						customerList.remove(index);
					case 5:
						System.out.println("app contents : ");
						for (Customer c : customerList)
							System.out.println(c);
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					// read off pending tockens from the scanner till EOC (end of line)
				}
			}
		}
	}

}
