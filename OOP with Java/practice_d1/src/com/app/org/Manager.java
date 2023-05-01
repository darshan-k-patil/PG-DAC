package com.app.org;

public class Manager extends Employee 
{
	private double perfBonus;
	public Manager(int empid, String name, int deptid, double basicSalary, double perfBonus)
	{
		super(empid, name, deptid, basicSalary);
		this.perfBonus=perfBonus;
	}
	
	@Override
	public double computeNetSalary()
	{
		return this.perfBonus+super.basicSalary;
	}
	@Override
	public String toString() {
		return   super.toString()+ "\nperfBonus=" + perfBonus + "\nnet Salary=" +this.computeNetSalary();
	}

	public double getPerfBonus() {
		return perfBonus;
	}
	
}
