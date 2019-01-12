package com.attendence;

public class EmpBT {
	EmployeeNode employee;

	public EmpBT() {
		employee = null;
	}

	public boolean isEmpty() {
		return employee == null;
	}

	/*
	 * This function reads the ids of employees entering the organization. One
	 * employee id can be populated per line (in the input text file) indicating
	 * their entry into the organization. The input data can be used to populate the
	 * tree. Use a trigger function to call this recursive function from the root
	 * node.
	 */
	EmployeeNode readEmployees(EmployeeNode emp, int id) {
		if (emp == null) {
			return new EmployeeNode(id);
		}

		if (id == emp.getEmpId()) {
			int attCount = emp.getAttCount() + 1;
			emp.setAttCount(attCount);
			return emp;
		}

		if (id > emp.getEmpId()) {
			emp.right = readEmployees(emp.right, id);
		} else {
			emp.left = readEmployees(emp.left, id);
		}
		return emp;
	}

	/*
	 * This function counts the number of unique IDs stored in the tree. Use a
	 * trigger function to call this recursive function from the root node.
	 */
	int getHeadcount(EmployeeNode emp) {
		int count = 1;
		if (emp.left != null) {
			count += getHeadcount(emp.getLeft());
		}
		if (emp.right != null) {
			count += getHeadcount(emp.getRight());
		}

		return count;
	}

	/*
	 * This function searches whether a particular employees has entered the
	 * organization or not. The function returns true if the employees ID is found,
	 * else it returns false. Use a trigger function to call this recursive function
	 * from the root node
	 */
	boolean searchID(EmployeeNode emp, int id) {
		if (emp.getEmpId() == id)
			return true;

		if (id < emp.getEmpId() && emp.getLeft() != null) {
			return searchID(emp.getLeft(), id);

		}
		if (id > emp.getEmpId() && emp.getRight() != null) {
			return searchID(emp.getRight(), id);
		}
		return false;

	}

	/*
	 * This function returns how often the employee id entered the organization. The
	 * function returns the count of the number of times the employee entered the
	 * organization. Use a trigger function to call this recursive function from the
	 * root node
	 */

	int howOften(EmployeeNode emp, int id) {
		if (emp.getEmpId() == id) {
			return emp.getAttCount();
		}
		if (id < emp.getEmpId() && emp.getLeft() != null) {
			return howOften(emp.getLeft(), id);
		}
		if (id > emp.getEmpId() && emp.getRight() != null) {
			return howOften(emp.getRight(), id);
		}
		return 0;

	}

	void traverse(EmployeeNode emp) {
		if (emp != null) {
			System.out.println("emp = " + emp.getEmpId() + "-" + emp.getAttCount());
		}
		if (emp.left != null)
			traverse(emp.left);
		if (emp.right != null)
			traverse(emp.right);
	}

	/*
	 * This function searches for the employee who has entered the most number of
	 * times and returns the node for that employee id. Use a trigger function to
	 * call this recursive function from the root node. For the sake of the
	 * assignment, you need to display any one of the employee ids if there are more
	 * than one employee who have entered the maximum number of times. For example,
	 * if employee id 22 and 23 have both visited 3 times, the output should show
	 * either 22 or 23.
	 */
	EmployeeNode frequentVisitor(EmployeeNode emp) {

		EmployeeNode temp = emp;
		if (temp != null) {
			if (temp.left != null && temp.left.getAttCount() >= temp.getAttCount())
				temp = frequentVisitor(temp.left);

			else if (temp.right != null && temp.right.getAttCount() >= temp.getAttCount())
				temp = frequentVisitor(temp.right);

		}
		return temp;
	}

	/*
	 * Given signature is void printRangePresent(Employees emp, int id1, int id2)
	 * But I am not sure what is Employees and why we need so removing.
	 * 
	 * This function prints the ids in the range id1 to id2 and how often they have
	 * entered the organization in a file name output.txt. For this purpose, the
	 * tree needs to be traversed; the id and frequency of the employees in the
	 * range must be printed. If the ID is found in the BT, its frequency cannot be
	 * zero as the person had entered the organization at least once.
	 */
	void printRangePresent(EmployeeNode emp, int id1, int id2) {
		if (emp != null && emp.getEmpId() > id1 && emp.getEmpId() < id2) {
			System.out.println("emp = " + emp.getEmpId() + "-" + emp.getAttCount());
		}
		if (emp.getLeft() != null)
			printRangePresent(emp.left, id1, id2);
		if (emp.getRight() != null)
			printRangePresent(emp.right, id1, id2);
	}
}
