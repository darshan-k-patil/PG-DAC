package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exceptions.CustomerHandlingException;

//no duplicate customer
//registration amount must match with plan
//customers age must be >21
public class CustomerValidationRules {
	// add a static method to invoke all validation rules
	public static Customer validateAllInputs(String firstname, String lastName, String email, String password,
			double registrationAmount, String dob, String regDate, String plan, List<Customer> customerList)
			throws CustomerHandlingException {

		checkForDuplicate(email, customerList);
		LocalDate validDob = parseAndValidateDob(dob);
		ServicePlan servicePlan = parseValidatePlanAndRegAmount(plan, registrationAmount);
		LocalDate validRegDate = parseSubscriptionDate(regDate);
		parseAndValidateSubscriptionDate(regDate);
		// validatePlanAndAmount(registrationAmount, plan);
		return new Customer(firstname, lastName, email, password, registrationAmount, validDob, validRegDate, servicePlan);

	}

	// add static method to check for duplicate
	public static void checkForDuplicate(String newEmail, List<Customer> customerlist)
			throws CustomerHandlingException {
		// 1. wrap email in customer reference
		Customer newCustomer = new Customer(newEmail);
		if (customerlist.contains(newCustomer))
			throw new CustomerHandlingException("Duplicate Email ID, choose new Email !!!!");
		System.out.println("No Duplicate Email found.....!");
	}

//	//add a static method for plan parsing n validation
//	public static ServicePlan parseAndValidatePlan(String planName) throws IllegalArgumentException //optional throws
//	{
//		return ServicePlan.valueOf(planName.toUpperCase());
//	}
//	//add a static method to validate reg amount matching with the plan
//	public static void validateRegAmountForPlan(ServicePlan chosenPlan, double regAmount) throws CustomerHandlingException{
//		//ServicePlan p = ServicePlan.valueOf(plan.toUpperCase());
//		if (chosenPlan.getPlanCost() != regAmount)
//			throw new CustomerHandlingException("registration amount does not match with plan");
//	}

	public static ServicePlan parseValidatePlanAndRegAmount(String planName, double regAmount)
			throws CustomerHandlingException, IllegalArgumentException {
		ServicePlan servicePlan = ServicePlan.valueOf(planName.toUpperCase());
		// => plan is valid
		if (servicePlan.getPlanCost() != regAmount)
			throw new CustomerHandlingException("Invalid registration amount for the chosen plan");
		return servicePlan;

	}

	// add a static method for customer's age validation
	public static LocalDate parseAndValidateDob(String dob) throws CustomerHandlingException {
		//parsing
		LocalDate date = LocalDate.parse(dob);
		// => parsing successful
		int ageInYears = Period.between(date, LocalDate.now()).getYears();
		if (ageInYears < 21)
			throw new CustomerHandlingException("You are Underage!!!!");
		return date;
	}
	
	//add a static method customer's login
		public static Customer customerLogin(String email, String pass, List<Customer> custList) throws CustomerHandlingException {
			//search customer by email : PK
			int index = custList.indexOf(new Customer(email));
			if(index == -1)
				throw new CustomerHandlingException("Invalid Email, login failed!!!!!");
			//valid email
			Customer validCustomer = custList.get(index);
			if(! validCustomer.getPassword().equals(pass))
				throw new CustomerHandlingException("Invalid Password, login failed!!!!!");
			return validCustomer;
		}
		
	//add a static method to check last Subscription Paid Date;
	public static LocalDate parseAndValidateSubscriptionDate(String regDate) throws CustomerHandlingException {
			//parsing
			LocalDate rdate = LocalDate.parse(regDate);
			//=> parsing successful
			int period = Period.between(rdate, LocalDate.now()).getMonths();
			if(period > 3)
				throw new CustomerHandlingException("Pay Subscription!!!!");
			return rdate;	
		}
	
	public static LocalDate parseSubscriptionDate(String regDate) throws CustomerHandlingException {
		//parsing
		LocalDate redate = LocalDate.parse(regDate);
		//=> parsing successful
		return redate;	
	}

}

