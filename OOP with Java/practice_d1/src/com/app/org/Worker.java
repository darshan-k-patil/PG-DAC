package com.app.org;

public class Worker extends Employee 
{
	private int hoursWorked, hourlyRate;
	public Worker(int empid, String name, int deptid, double basicSalary, int hoursWorked, int hourlyRate)
	{
		super(empid, name, deptid, basicSalary);
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
	}
	@Override
	public String toString() {
		return super.toString() + "\nhoursWorked=" + hoursWorked + " \nhourlyRate=" + hourlyRate + "\n netSalary=" + this.computeNetSalary();
	}
	@Override
	public double computeNetSalary()
	{
		return super.basicSalary+(this.hourlyRate*this.hoursWorked);
	}
	public int getHourlyRate() {
		return hourlyRate;
	}
	
}
