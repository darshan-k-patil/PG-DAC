/*Create Emp based organization structure --- Emp , Mgr , Worker
All of above classes must be in --com.app.org

1.1 Emp state--- id(int), name, deptId , basicSalary(double)
Accept all of above in constructor arguments.
Methods ---1.To  get emp details -- override toString((inherited from Object class)
1.2. compute net salary ---ret 0
(eg : public double computeNetSalary(){return 0;})

1.2 Mgr state  ---id,name,basic,deptId , perfBonus
Add suitable constructor
Methods ----1. get mgr details :  override toString (inherited from Emp class)
1. compute net salary (formula: basic+perfBonus) -- override computeNetSalary
2. get performance bonus. --add a new method to return bonus.(getter)

1.3 Worker state  --id,name,basic,deptId,hoursWorked,hourlyRate
Methods : 
1. get worker details -- :  override toString. (inherited from Emp class)
2.  compute net salary (formula:  = basic+(hoursWorked*hourlyRate) --override computeNetSalary
3. get hrlyRate of the worker  -- add a new method to return hourly rate of a worker.(getter)

Organize classes in inheritance  hierarchy.

Write TestOrganization in "tester" package.
Create suitable array to store organization details.
Provide following options

1. Hire Manager
I/P : all manager details

2. Hire Worker  
I/P : all worker details

3. Display information of all employees(toString) & display net salary (by invoking computeNetSal), 

4. Exit*/
package com.app.org;

public class Employee 
{
	private int empid, deptid;
	private String name;
	protected double basicSalary;

public Employee(int empid, String name, int deptid, double basicSalary)
{
	this.empid=empid;
	this.deptid=deptid;
	this.name=name;
	this.basicSalary=basicSalary;
}

@Override
public String toString() {
	return "Employee [empid=" + empid + ", deptid=" + deptid + ", name=" + name + ", basicSalary=" + basicSalary + "]";
}

public double computeNetSalary()
{
	return 0;
}

}