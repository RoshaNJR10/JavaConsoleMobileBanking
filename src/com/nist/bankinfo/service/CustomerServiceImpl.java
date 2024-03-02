package com.nist.bankinfo.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.nist.bankinfo.model.CustomerDto;

public class CustomerServiceImpl implements CustomerService {
	Scanner scInt=new Scanner(System.in);
	Scanner scString=new Scanner(System.in);
	Scanner scDouble=new Scanner(System.in);
	Scanner scLong=new Scanner(System.in);
	Scanner scChar=new Scanner(System.in);
	
	
	static long accountNumber=100;
	ArrayList<CustomerDto> customerList=new ArrayList<CustomerDto>();
	
	@Override
    public int main() {
        System.out.println("****************Welcome to NJR Bank***************");
        System.out.println("1. Create Account");
        System.out.println("2. View Customer Details");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw ");
        System.out.print("Enter your choice:");
        return scInt.nextInt();
    }

    @Override
    public void startProgram() {
        char ch;

        do {
            int choice = main();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewDetails();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("==================================================================================================");
            System.out.println("Do you want to continue?(y/n)");
            ch = Character.toLowerCase(scChar.next().charAt(0));
        } while (ch == 'y');
    }

	
	@Override
	public void createAccount() {
		try {
		System.out.println("Enter name:");
		String name=scString.nextLine();
		
		System.out.println("Enter address:");
		String address= scString.nextLine();
		
		System.out.println("Enter gender:");
		String gender= scString.nextLine();
		
		System.out.println("Enter your age:");
		int age=scInt.nextInt();
		
		System.out.println("Enter phoneNumber:");
		long phoneNumber= scLong.nextLong();
		
		System.out.println("Account Successfully Created!! Your account number is"+accountNumber);
		CustomerDto customer= new CustomerDto(name, address, gender, age, phoneNumber, accountNumber++, 0.0);
		customerList.add(customer);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	@Override
	public void viewDetails() {
	
		System.out.print("Enter the account number to be searched:");
		long accNo = scLong.nextLong();
		boolean found= false;
		int index=0;
		for (int i = 0; i < customerList.size(); i++) {
			if(accNo==customerList.get(i).accountNumber) {
				found=true;
				index=i;
			}
		}	
		if(found) {
			System.out.println("Name is "+ customerList.get(index).name);
			System.out.println("Address is "+ customerList.get(index).address);
			System.out.println("Age is "+ customerList.get(index).age);
			System.out.println("Gender is "+ customerList.get(index).gender);
			System.out.println("Phone Number is "+ customerList.get(index).phoneNumber);
			System.out.println("Account Number is "+ customerList.get(index).accountNumber);
			System.out.println("Balance is "+ customerList.get(index).balance);
			
		}else {
			System.out.println("Customer not found. Create account");		
		}	
	}

	@Override
	public void deposit() {
		System.out.print("Enter account number to be deposited:");
		long accno=scLong.nextLong();
		int index=0;
		boolean found=false;
		for(int i=0; i<customerList.size();i++) {
			if(accno==customerList.get(i).accountNumber) {
				found=true;
				index=i;
			}
		}
		if(found) {
			System.out.print("Enter the amount to be deposited:");
			double amount=scDouble.nextDouble();
			customerList.get(index).deposit(amount);
			System.out.println("Amount Successfully Deposited!!!");
		}else {
			System.out.println("Account Number is not in the list.");
		}
	}

	@Override
	public void withdraw() {
		System.out.print("Enter account number to withdraw:");
		long accno=scLong.nextLong();
		int index=0;
		boolean found=false;
		for(int i=0; i<customerList.size();i++) {
			if(accno==customerList.get(i).accountNumber) {
				found=true;
				index=i;
			}
		}
		if(found) {
			System.out.print("Enter balance to bo withdraw:");
			double amount=scDouble.nextDouble();
			if(amount<= customerList.get(index).balance) {
				customerList.get(index).withdraw(amount);
				System.out.println("Amount Successfully Withdraw!!!");
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		else {
		System.out.println("Account Number is not in the list.");
	}
		
		
	}
	
	
	public static void main(String[] args) {
		CustomerService cust=new CustomerServiceImpl();
		cust.startProgram();
	}
}
