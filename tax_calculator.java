package tax_calculator;

import java.util.Scanner;
//Custom exceptions
class CountryNotValidException extends Exception
{
	public CountryNotValidException(String msg) 
	{
		super(msg);
	}
}
//Custom exceptions
class EmployeeNameInvalidException extends Exception
{
	public EmployeeNameInvalidException(String msg) 
	{
		super(msg);
	}
}
//Custom exceptions
class TaxNotEligibleException extends Exception
{
	public TaxNotEligibleException(String msg) 
	{
		super(msg);
	}
}

public class tax_calculator
{
	// Class variables
	String empname;
	boolean isIndian;
	double empsalary,Taxamount;
	// Method to input employee details
	public void input()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Entre your Name=");
		empname=sc.next();
		System.out.println("Are you indian(True/False)");
		isIndian=sc.nextBoolean();
		System.out.println("Enter your Salary");
		empsalary=sc.nextDouble();
	}
	 // Method to calculate tax
	public void calculate_tax() throws Exception
	{	
		// Checking for invalid employee name
		if(empname==null)
		{
			throw new EmployeeNameInvalidException("The employee name cannot be empty");

		}
		// Checking if employee is Indian
		if(isIndian==false)
		{
			throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
		}
		// Calculating tax based on salary ranges
		if(empsalary>100000)
		{
			Taxamount=empsalary*8/100;
		}
		else if(empsalary>50000 && empsalary<=100000)
		{
			Taxamount=empsalary*6/100;
		}
		else if(empsalary>30000 && empsalary<=50000)
		{
			Taxamount=empsalary*5/100;
		}
		else if(empsalary>10000 && empsalary<=30000)
		{
			Taxamount=empsalary*4/100;
		}
		else
		{
			// Employee does not need to pay tax
			throw new TaxNotEligibleException("The employee does not need to pay tax");
		}
		System.out.println("The Tax Amount for your salary will be="+Taxamount);
	}
	// Main method
	public static void main(String[] args) throws Exception
	{
		// Creating object of tax_calculator class
		tax_calculator sobj=new  tax_calculator();
		// Calling input method to get employee details
		sobj.input();
		 // Calling calculate_tax method to calculate tax
		sobj.calculate_tax();
		
	}

}
