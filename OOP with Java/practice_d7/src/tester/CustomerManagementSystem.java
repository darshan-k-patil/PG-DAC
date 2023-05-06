package tester;
//darshan patil darsh@123 dkp 1000 2001-01-03 2023-01-20 silver 
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.app.core.Customer;
import com.app.core.ServicePlan;
import custom_exceptions.CustomerHandlingException;
import static utils.CustomerValidationRules.*;
import static utils.CMSUtils.populateList;
import utils.CMSUtils.*;

public class CustomerManagementSystem {
	public static void main(String[] args) throws CustomerHandlingException {
		try (Scanner sc = new Scanner(System.in)) {
			// initializing phase
			// create empty ArrayList : to store customer references
			List<Customer> customerList = populateList();
			boolean exit = false;

			// client servicing phase
			while (!exit) {
				System.out.println("Options 1.Sign up \n2.Sign in " + "\n3.Change Password \n4.Un Suscribe Customer"
						+ "\n5.Display all customer \n6.sort customers as per email "
						+ "\n7. sort customers as per dob and regAmount"
						+ "\n8.Delete customer by plan \n9.Pay Subsription \nRemove customers whose"
						+ " plan is expired more than 3 years \n0.Exit");
				System.out.println("Choose an Option");
				try {
					switch (sc.nextInt()) {
					case 1: // customer registration
						System.out.println("Enter Customer details : First Name, Last Name,"
								+ " Email, Password, Registration Ammount," + " dob(yr-mon-day), Service plan");
						Customer validCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), sc.next(), customerList);
						customerList.add(validCustomer);
						System.out.println("Customer registered....");
						break;
					case 2: // sign in
						System.out.println("Enter email n password");
						validCustomer = customerLogin(sc.next(), sc.next(), customerList);
						System.out.println(validCustomer);
						break;
					case 3:// change password
						System.out.println("Enter email, old password, new password : ");
						validCustomer = customerLogin(sc.next(), sc.next(), customerList);
						// => valid login
						validCustomer.setPassword(sc.next());
						break;
					case 4:
						System.out.println("Enter email, old password: ");
						validCustomer = customerLogin(sc.next(), sc.next(), customerList);
						customerList.remove(validCustomer);
					case 5:
						System.out.println("app contents : ");
						for (Customer c : customerList)
							System.out.println(c);
						break;
					case 6:
						System.out.println("sorted customers as per email");
						Collections.sort(customerList);
						break;
					case 7:
						// "sort customers as per dob and regAmount"
						Collections.sort(customerList, new Comparator<Customer>() // entire inner class definition
						{
							@Override
							public int compare(Customer c1, Customer c2) {
								// dob based
								int ret = c1.getDob().compareTo(c2.getDob());
								if (ret == 0) {
									// reg amount based sorting
//									if (c1.getRegistrationAmount()<c2.getRegistrationAmount())
//											return -1;
//									if(c1.getRegistrationAmount() == c2.getRegistrationAmount())
//										return 0;
//									return 1;
									return ((Double) c1.getRegistrationAmount()).compareTo(c2.getRegistrationAmount());
								}
								return ret;
							}
						});

						break;
					case 8:
//						System.out.println("Enter Service Plan and registration ammount");
//						ServicePlan plan = parseValidatePlanAndRegAmount(sc.next(), sc.nextDouble());

						break;
					case 9:
						System.out.println("Enter email n password");
						validCustomer = customerLogin(sc.next(), sc.next(), customerList);
						//int period = Period.between(validCustomer.getRegDate(), LocalDate.now()).getMonths();
						long period = Period.between(validCustomer.getRegDate(), LocalDate.now()).toTotalMonths();
						System.out.println(period);
						if (period >= 3) {
							System.out.println("Wanna update subscription plan? enter yes or no");
							String a = sc.next().toLowerCase();
							if (a.equals("yes"))
								validCustomer.setRegDate(LocalDate.now());
							System.out.println("Amount paid");
							
						}
						break;
					case 10:
						Iterator<Customer> itr = customerList.iterator();
						while(itr.hasNext())
						{
							validCustomer = itr.next();
							period = Period.between(validCustomer.getRegDate(), LocalDate.now()).toTotalMonths();
							if (period >= 3) {
								itr.remove();
							}
						}
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					// read off pending tokens from the scanner till EOC (end of line)
				}
			}
		}
	}

}
