package com.registerlogin.model;

public class Employee {
	private int 	id ;
	private String	name ;
	private String 	password;
	private String 	ssn; 
	private String 	email;
	private String 	phone;
	private String 	bank ;
	private String 	qualification;
	private String 	income ;
	
	
	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param ssn
	 * @param email
	 * @param phone
	 * @param bank
	 * @param qualification
	 * @param income
	 */
	public Employee(int id, String name, String password, String ssn, String email, String phone, String bank,
			String qualification, String income) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.bank = bank;
		this.qualification = qualification;
		this.income = income;
	}
	/**
	 * @param name
	 * @param ssn
	 * @param email
	 * @param phone
	 * @param bank
	 * @param qualification
	 * @param income
	 */
	public Employee(String name, String ssn, String email, String phone, String bank, String qualification,
			String income) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.bank = bank;
		this.qualification = qualification;
		this.income = income;
	}
	public Employee() {
		
	}
	
	/**
	 * @param name
	 * @param password
	 * @param ssn
	 * @param email
	 * @param phone
	 * @param bank
	 * @param qualification
	 * @param income
	 */
	public Employee(String name, String password, String ssn, String email, String phone, String bank,
			String qualification, String income) {
		super();
		this.name = name;
		this.password = password;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.bank = bank;
		this.qualification = qualification;
		this.income = income;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + ", ssn=" + ssn + ", email=" + email
				+ ", phone=" + phone + ", bank=" + bank + ", qualification=" + qualification + ", income=" + income
				+ "]";
	}
}
