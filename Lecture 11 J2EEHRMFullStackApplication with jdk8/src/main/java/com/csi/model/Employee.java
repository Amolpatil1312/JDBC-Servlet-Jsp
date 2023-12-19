package com.csi.model;

import java.util.Date;
import java.util.Objects;

public class Employee {

	private int empId;

	private String empName;

	private String empAddress;

	private String empState;

	private double empSalary;

	private long empContactNumber;

	private String empGender;

	private String empDept;

	private Date empDOB;

	private long empUID;

	private String empPanCard;

	private String empEmailId;

	private String empPassword;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String empAddress, String empState, double empSalary,
			long empContactNumber, String empGender, String empDept, Date empDOB, long empUID, String empPanCard,
			String empEmailId, String empPassword) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empState = empState;
		this.empSalary = empSalary;
		this.empContactNumber = empContactNumber;
		this.empGender = empGender;
		this.empDept = empDept;
		this.empDOB = empDOB;
		this.empUID = empUID;
		this.empPanCard = empPanCard;
		this.empEmailId = empEmailId;
		this.empPassword = empPassword;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public long getEmpContactNumber() {
		return empContactNumber;
	}

	public void setEmpContactNumber(long empContactNumber) {
		this.empContactNumber = empContactNumber;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	public long getEmpUID() {
		return empUID;
	}

	public void setEmpUID(long empUID) {
		this.empUID = empUID;
	}

	public String getEmpPanCard() {
		return empPanCard;
	}

	public void setEmpPanCard(String empPanCard) {
		this.empPanCard = empPanCard;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empAddress, empContactNumber, empDOB, empDept, empEmailId, empGender, empId, empName,
				empPanCard, empPassword, empSalary, empState, empUID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empAddress, other.empAddress) && empContactNumber == other.empContactNumber
				&& Objects.equals(empDOB, other.empDOB) && Objects.equals(empDept, other.empDept)
				&& Objects.equals(empEmailId, other.empEmailId) && Objects.equals(empGender, other.empGender)
				&& empId == other.empId && Objects.equals(empName, other.empName)
				&& Objects.equals(empPanCard, other.empPanCard) && Objects.equals(empPassword, other.empPassword)
				&& Double.doubleToLongBits(empSalary) == Double.doubleToLongBits(other.empSalary)
				&& Objects.equals(empState, other.empState) && empUID == other.empUID;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empState="
				+ empState + ", empSalary=" + empSalary + ", empContactNumber=" + empContactNumber + ", empGender="
				+ empGender + ", empDept=" + empDept + ", empDOB=" + empDOB + ", empUID=" + empUID + ", empPanCard="
				+ empPanCard + ", empEmailId=" + empEmailId + ", empPassword=" + empPassword + "]";
	}

}
