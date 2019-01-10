package com.attendence;

//This class to include all basic functions for the node
public class EmployeeNode {
	
	int empId;
	int attCount;
	
	EmployeeNode left, right;	
	
	public EmployeeNode(int empId) 
	{
		super();
		this.empId  = empId;
		this.attCount = 1;
		this.left = null;
		this.right = null;
	}
	
	/* Function to set left node */
    public void setLeft(EmployeeNode n)
    {
        left = n;
    }
    /* Function to set right node */ 
    public void setRight(EmployeeNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public EmployeeNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public EmployeeNode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setEmpId(int empId)
    {
    	this.empId = empId;
    }
    /* Function to get data from node */
    public int getEmpId()
    {
        return empId;
    }     
	
    public int getAttCount() {
		return attCount;
	}

	public void setAttCount(int attCount) {
		this.attCount = attCount;
	}

	@Override
	public String toString() {
		return "EmployeeNode [empId=" + empId + ", attCount=" + attCount + "]";
	}

	
	
	
}
