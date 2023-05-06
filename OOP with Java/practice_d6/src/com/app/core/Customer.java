package com.app.core;

import java.time.LocalDate;

/*customer id(int) ,first name, last name (string),email(string),password(string),
 * registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
*/
public class Customer implements Comparable<Customer> {
	private int custid;
	private static int idGenerator;
	private String firstname;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	static {
		idGenerator = 100;
	}

	public Customer(String firstname, String lastName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		this.custid = ++idGenerator;
	}

	public Customer(String email) {
		this.email = email;
	}
//	public Customer(String email, String password) {
//		this.email = email;
//		this.password=password;
//	}

	@Override
	public String toString() {
		return "custid=" + custid + ", firstname=" + firstname + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan;
	}

	// for PK based equality testing
	@Override
	public boolean equals(Object o) {
		System.out.println("in equals method");
		if (o instanceof Customer)
			return this.email.equals(((Customer) o).email);
		//&&this.password.equals(((Customer) o).password
		return false;
	}
	@Override
	public int compareTo(Customer anotherCust)
	{
		System.out.println("in customer : compare to");
		return this.email.compareTo(anotherCust.email);
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

}
