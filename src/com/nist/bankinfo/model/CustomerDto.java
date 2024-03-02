package com.nist.bankinfo.model;

public class CustomerDto {
public	String name,address,gender;
public	int age;
public	long phoneNumber, accountNumber;
public	double balance;
public  CustomerDto(String name, String address, String gender, int age, long phoneNumber, long accountNumber, double balance) {
	this.name= name;
	this.address= address;
	this.gender=gender;
	this.age=age;
	this.phoneNumber=phoneNumber;
	this.accountNumber=accountNumber;
	this.balance=balance;
	
	
}
public void deposit(double amount) {
	balance=balance+amount;
}
public void withdraw(double amount) {
	balance=balance-amount;
}
}

