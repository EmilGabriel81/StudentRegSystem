package StudentClass;

import java.util.Scanner;

public class Student {
	
	private final static String Yes = "Y";
	private SchoolManagement schManagement;
	private String firstName;
	private String lastName;
	private String email;
	private String studentId;
	private String Course;
	private String dateOfBirth;
	private String Address;
	private int balance;
	private boolean isForeign;
	private String Foreigner;
	
	public Student(int balance) {
		if(balance >0 || balance<6000) {
			this.balance=balance;
		}
		
	}
	
	



	public Student() {
		Scanner scan = new Scanner(System.in);
		//<firts name>
	    System.out.println("Enter Students First Name :\n");
	    this.firstName = scan.nextLine();
	    //</first name>
	    //<last name>
		System.out.println("Enter Students Last Name :\n");
		this.lastName = scan.nextLine();//last Name
		//</last Name>
		//This method that tells us if Student is from abroad
		 this.isForeign = isForeign;
		 foreigner();
       //<The Course>
		 this.Course = Course;
		//System.out.println("Enter the Course :\n");
		//this.Course = scan.nextLine();//The Course
		//</Course>
		System.out.println("Enter the Email :\n");
		this.email = scan.nextLine();//The Email
		//</Email>
		System.out.println("Enter the Address :\n");
		this.Address = scan.nextLine();//The Address
		//</The Address>
		//<Balance>
		this.balance=balance;
		//<SetStudentId Method>	
		this.studentId = studentId;
		setStudentId();
		System.out.println("|************************************************************************************|");
		System.out.println("|\t Hello "+firstName+" "+lastName+" Your ID is: "+studentId+"                        ");
		System.out.println("|************************************************************************************|");
		//<SetStudentID
//		System.out.println("Proceed with a first transaction?:\n");
//	    this.remainingBalance = scan.nextInt();
		
		}
	

	public String setStudentId() {
	
		int max = 1000;
		int min = 100;
		int range = max - min + 1;
		int random = (int)(Math.random() * range) + min;
		this.studentId = random+lastName;
		return studentId;
	}

	


	public void foreigner() {
		System.out.println("|************************************************************************************|");
		System.out.println("|\tIs the student a Foreigner ?                                                 |");
		System.out.println("|\t[Y / N]                                                                      |");
		System.out.println("|************************************************************************************|");
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		if(option.equalsIgnoreCase(Yes)) {
			isForeign = true;
		}else {
			isForeign = false;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public boolean getIsForeign() {
		return isForeign;
	}

	public boolean setForeign(boolean isForeign) {
		
		//I still have to work on this one
		//To be continued
		this.isForeign = isForeign;
		System.out.println("|************************************************************************************|");
		System.out.println("|\tIs the student a Foreigner ?                                                 |");
		System.out.println("|\t[Y / N]                                                                      |");
		System.out.println("|************************************************************************************|");
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		if(option.equalsIgnoreCase(Yes)) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance += balance;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getCourse() {
		return Course;
	}





	public void setCourse(String course) {
		Course = course;
	}





	public String getAddress() {
		return Address;
	}





	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	//<Failed Methods>*****************************************************************************************
//	public int remainsToBePaid(int amount){
//		// I need to find a way to fix this
//		
//		
//		if(isForeign) {
//			
//			initialAmount=2000;
//			secondAmount=4000;
//			lastAmount=6000;
//			
//		}else {
//			
//			initialAmount=1000;
//			secondAmount=2000;
//		    lastAmount=3000;
//			
//		}
//			if(amount==initialAmount) {
//				this.remainingBalance = lastAmount-initialAmount;
//				System.out.println(this.remainingBalance);
//				return this.remainingBalance;
//				
//			}else if (amount==secondAmount) {
//				this.remainingBalance = lastAmount-secondAmount;
//				System.out.println(this.remainingBalance);
//				return this.remainingBalance;
//				
//			}else if (amount==lastAmount) {
//				this.remainingBalance=lastAmount;
//				System.out.println(this.remainingBalance);
//				return this.remainingBalance;
//		
//			}else {
//        System.out.println("Please enter a valid amount\n"
//        		           +"Your transaction hasn`t been approved");
//        
//		}
//		return 0;
//	
//	}

	
//***************************************************8
	
//	public int remainsToBePaid(int amount){
//		// I need to find a way to fix this
//		
//		
//		if(isForeign) {
//			
//			initialAmount=2000;
//			secondAmount=4000;
//			lastAmount=6000;
//			
//		}else {
//			
//			initialAmount=1000;
//			secondAmount=2000;
//		    lastAmount=3000;
//			
//		}
//			if(amount==initialAmount) {
//				this.remainingBalance = lastAmount-initialAmount;
//				System.out.println(this.remainingBalance);
//				return this.remainingBalance;
//				
//			}else if (amount==secondAmount) {
//				this.remainingBalance = lastAmount-secondAmount;
//				System.out.println(this.remainingBalance);
//				return this.remainingBalance;
//				
//			}else if (amount==lastAmount) {
//				this.remainingBalance=lastAmount;
//				System.out.println(this.remainingBalance);
//				return this.remainingBalance;
//		
//			}else {
//        System.out.println("Please enter a valid amount\n"
//        		           +"Your transaction hasn`t been approved");
//        
//		}
//		return 0;
//	
//	}
//
//	public int getRemainingBalance() {
//		return this.remainingBalance;
//	}
	
}
