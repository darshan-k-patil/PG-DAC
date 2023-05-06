package utils;
//darshan patil darsh@123 dkp 1000 2001-01-03 2023-01-20 silver 
//utkarsh rane utu@123 usr 2000 2001-01-03 gold 
//aniket gonjare ani@123 anig 5000 2001-01-03 diamond 
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
	//add a static method to invoke all validation rules
	public static Customer validateAllInputs(String firstname, String lastName, String email, String password,
			double registrationAmount, String dob, String plan, List<Customer> customerList)
			throws CustomerHandlingException {
		
		checkForDuplicate(email, customerList);
		LocalDate validDob=parseAndValidateDob(dob);
		ServicePlan  servicePlan =parseValidatePlanAndRegAmount(plan,registrationAmount);
		//validatePlanAndAmount(registrationAmount, plan);
		return new Customer(firstname, lastName, email,password, registrationAmount,validDob, servicePlan);

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
	
	
	public static ServicePlan parseValidatePlanAndRegAmount(String planName, double regAmount) throws CustomerHandlingException, IllegalArgumentException {
		ServicePlan servicePlan = ServicePlan.valueOf(planName.toUpperCase());
		// => plan is valid
		if (servicePlan.getPlanCost() != regAmount)
			throw new CustomerHandlingException("Invalid registration amount for the chosen plan");
		return servicePlan;

	}

	//add a static method for customer's age validation
	public static LocalDate parseAndValidateDob(String dob) throws CustomerHandlingException {
		//parsing
		LocalDate date = LocalDate.parse(dob);
		// => parsing successful
		int ageInYears = Period.between(date, LocalDate.now()).getYears();
		if (ageInYears < 21)
			throw new CustomerHandlingException("You are Underage!!!!");
		return date;
	}
}
