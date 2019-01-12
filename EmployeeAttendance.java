package com.attendence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeAttendance {

	public static void main(String[] args) {

		EmpBT empBT = new EmpBT();
		EmployeeNode employeeNode = null;
		Scanner empOperation = new Scanner(System.in);
		char ch;
		System.out.println("Loading... ");
		/* Perform Employee operations */
		do {
			System.out.println("\n Employee Operations \n");
			System.out.println("\n ################### \n");
			System.out.println("1. INSERT ");
			System.out.println("2. HEADCOUNT");
			System.out.println("3. SEARCH");
			System.out.println("4. ATTENDENCE");
			System.out.println("5. FREQUENT VISITOR");
			System.out.println("6. DATA BY RANGE");

			int choice = empOperation.nextInt();
			switch (choice) {
			case 1:
				employeeNode = insertEmployeeFromFile("input.txt", empBT, employeeNode);
				break;

			case 2:
				int headCount = empBT.getHeadcount(employeeNode);
				System.out.println("\n Head Count = " + headCount);
				break;

			case 3:
				System.out.println("\nEnter Employee id: ");
				int searchId = empOperation.nextInt();
				boolean isPresent = empBT.searchID(employeeNode, searchId);
				System.out.println("\n Employee with id = " + searchId + "entered  in Organisation : " + isPresent);
				break;

			case 4:
				System.out.println("\nEnter Employee id: ");
				int inputId = empOperation.nextInt();
				int howOften = empBT.howOften(employeeNode, inputId);
				System.out.println(
						"\n Employee with id = " + inputId + " entered " + howOften + " times in Organisation");
				break;

			case 5:
				EmployeeNode employee = empBT.frequentVisitor(employeeNode);
				System.out.println("\nFrequent Visitor : " + employee);
				break;

			case 6:
				System.out.println("\nEnter lower limit for range: ");
				int low = empOperation.nextInt();
				System.out.println("\nEnter upper limit for range: ");
				int upper = empOperation.nextInt();
				empBT.printRangePresent(employeeNode, low, upper);
				break;

			default:
				System.out.println("\nInvalid Operation");
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = empOperation.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		empOperation.close();
	}

	/* Reading employee from input file */

	public static EmployeeNode insertEmployeeFromFile(String path, EmpBT empBT, EmployeeNode emp) {
		File file = new File(path);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				emp = empBT.readEmployees(emp, Integer.parseInt(text));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		return emp;
	}
}
