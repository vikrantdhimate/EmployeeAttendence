package com.attendence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeAttendance 
{

	public static void main(String[] args) {
				
		EmpBT empBT  = new EmpBT();
		EmployeeNode employeeNode = null;
        Scanner empOperation = new Scanner(System.in);               
        char ch;
        
        /*  Perform Employee operations  */
        do    
        {
            System.out.println("\nEmployee Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. Get Headcount");
            System.out.println("3. Search Employee");
            System.out.println("4. How Often");            
            System.out.println("5. Frequent Visitor"); 
            System.out.println("6. printRangePresent"); 
 
            int choice = empOperation.nextInt();            
            switch (choice)
            {
	            case 1 : 	                
	                employeeNode = insertEmployeeFromFile("input.txt", empBT, employeeNode);                    
	                break;
	            case 2:
	            	int headCount = empBT.getHeadcount(employeeNode);
	            	System.out.println("headCount = "+headCount);
	            	break;
	            case 3:
	            	Scanner employeeid = new Scanner(System.in);
	            	System.out.println("\nEnter Employee id: ");
	            	int searchId = employeeid.nextInt();
	            	boolean isPresent = empBT.searchID(employeeNode, searchId);
	            	System.out.println("isPresent = "+isPresent);
	            	break;
	            case 4:
	            	int howOften = empBT.howOften(employeeNode, 121);
	            	System.out.println("howOften = "+howOften);
	            	break;	            
	            case 5:
	            	EmployeeNode employee = empBT.frequentVisitor(employeeNode);
	            	System.out.println("Frequent Visitor " + employee);
	            	break;
	            case 6:
	            	empBT.printRangePresent(employeeNode,20,225);
	            	break;
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = empOperation.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y'); 
	}
	
	/* Reading employee from input file */

	public static EmployeeNode insertEmployeeFromFile(String path, EmpBT empBT, EmployeeNode employeeNode) 
	{		
		File file = new File(path);
		BufferedReader reader = null;

		try 
		{
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) 
			{
				employeeNode = empBT.readEmployees(employeeNode, Integer.parseInt(text));
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (reader != null) 
				{
					reader.close();
				}
			} 
			catch (IOException e) 
			{
			}
		}
		return employeeNode;

	}
}
