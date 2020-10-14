package StudentClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SchoolManagement {

	//private ForeignStudent forStudent;
	private Student student;
	private String name;
	private int initialAmount;
	private int secondAmount;
	private int lastAmount;
	private int remainingBalance;
	//*********************************************************
	private final static String YES = "Y";
	private final static String ACCOUNTING ="a";
	private final static String BUSINESS ="b";
	private final static String COMPUTING ="c";
	//**********************************************************
	private final static String ACCCOURSE = "Accounting";
	private final static String BUSCOURSE = "Business";
	private final static String COMCOURSE = "Computing";
	
	
	
	
    





	private static ArrayList<Student> enrolledStudents = new ArrayList();// List with the Students of the college
	private static ArrayList<Student> computingCourse = new ArrayList();// The Computing Array
	private static ArrayList<Student> accountingCourse = new ArrayList();// The Accounting Array
	private static ArrayList<Student> businessCourse = new ArrayList();// The Business Array

	public SchoolManagement(String name) {
		this.name = name;

	}

	public void addStudent() {

		// This are the students added in the enrollment schema not on a particular
		// course
		student = new Student();
		enrolledStudents.add(student);
		System.out.println("|************************************************************************************|");
		System.out.println("|\tStudent enrolled successfuly                                                       ");
		System.out.println("|************************************************************************************|");
	}

	public void printEnrolled() {
		
		// Printing all the students in the college
		for (int i = 0; i < enrolledStudents.size(); i++) {
			System.out.println("|************************************************************************************|");
			System.out.println("|\tThe enrolled students are :\n" + 
			        "\n\tFirst Name :"+"  "+enrolledStudents.get(i).getFirstName() +//First Name
					"\n\tLast Name :"+"  "+ enrolledStudents.get(i).getLastName() +//Last Name
					"\n\tId :" + "  " + enrolledStudents.get(i).getStudentId()+//Id
					"\n\tStatus :"+"  "+enrolledStudents.get(i).getIsForeign()+//Status;Home/Foreign
			         "\n\tCourse :"+" "+enrolledStudents.get(i).getCourse()+//Course
			         "\n\tEmail :"+"  "+enrolledStudents.get(i).getEmail()+//Email
			         "\n\tAddress :"+"  "+enrolledStudents.get(i).getAddress()+//Address
			         "\n\tBalance :"+"  "+enrolledStudents.get(i).getBalance()+"\n");//End
			
			System.out.println("|************************************************************************************|");
			// showStudentsOnCourse();

		}
		showAllCourses();//it will link you to the method where you see all the students
		
	}
	
	public static Student findStudent(String searchName,ArrayList<Student>genericArray) {
		
		for(Student standardStd : genericArray) {
			if(standardStd.getLastName().equalsIgnoreCase(searchName)) {
				
				return standardStd;
			}
		}
		return null;
	}
	
	

	public static ArrayList<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public static ArrayList<Student> getComputingCourse() {
		return computingCourse;
	}

	public static ArrayList<Student> getAccountingCourse() {
		return accountingCourse;
	}

	public static ArrayList<Student> getBusinessCourse() {
		return businessCourse;
	}

	public void addStudentsOnCourse() {
		// This method is responsible with adding students to a certain Course
		System.out.println("|************************************************************************************|");
		System.out.println(
				"|\tAvailable Modules:" + "\nPress:\n\t A) Accounting\n\t B) Business\n\t C) Computing\n 0)Quit");
		System.out.println("|************************************************************************************|");
		Scanner scan = new Scanner(System.in);
		String choseYourCourse = scan.nextLine();

		switch (choseYourCourse) {

		case COMPUTING:
			// <Computing Course>
			enrollToComputing();
			System.out.println("|************************************************************************************|");
			System.out.println("|\tYou have been added to Computing                                                  |");
			System.out.println("|************************************************************************************|");
			// </Computing Course>
			break;
		case ACCOUNTING:
			// <Accounting>
			enrollToAccounting();
			System.out.println("|************************************************************************************|");
			System.out.println("|\tYou have been added to Accounting                                                 |");
			System.out.println("|************************************************************************************|");
			// </Accounting>
			break;
		case BUSINESS:
			// <Business>
			enrollToBusiness();
			System.out.println("|************************************************************************************|");
			System.out.println("|\tYou have been added to Business                                                   |");
			System.out.println("|************************************************************************************|");
			// </Business>
			break;

		default:
			System.out.println("This is not a valid option");
			break;
		}
	}

//<enroll Methods>***************************************************************
	public void enrollToComputing() {

		student = new Student();
		student.setCourse(COMCOURSE);
		computingCourse.add(student);
		// Student added to the computing module
		// We will save the data by writing it into a file

	}

	public void enrollToAccounting() {
		student = new Student();
		student.setCourse(ACCCOURSE);
		accountingCourse.add(student);
		// Student added to the Accounting module
		// We will save the data by writing it into a file

	}

	public void enrollToBusiness() {
		student = new Student();
		student.setCourse(BUSCOURSE);
		businessCourse.add(student);
		// Student added to the Business module
		// We will save the data by writing it into a file

	}

//</Enroll Methods>****************************************************************


	public void showAllCourses() {

		System.out.println("|************************************************************************************|");
		System.out.println("|\tShow all students from each course ?                                         |");
		System.out.println("|               [Y / N]\n                                                            |");
		System.out.println("|************************************************************************************|");
		Scanner scan = new Scanner(System.in);
		String viewCourses = scan.nextLine();

		if (viewCourses.equalsIgnoreCase(YES)) {
                //This one is broken,i need to fix it
			// <Menu>
			enterYourChoice();
			// </MenuCourses>

		} else{
			return;// </FirstIfStatement>
		}

		viewCourses = scan.nextLine();
		if (viewCourses.equalsIgnoreCase(ACCOUNTING)) {
			showTheCourse(accountingCourse);
			//showAccountingCourse();
		} else if (viewCourses.equalsIgnoreCase(BUSINESS)) {
			showTheCourse(businessCourse);
			//showBusinessCourse();
		}else if (viewCourses.equalsIgnoreCase(COMPUTING)) {
			showTheCourse(computingCourse);
			//showComputingCourse();
		}else {
			System.out.println("Character "+viewCourses+") is not a valid choice");
     
        }


	}
	public void showTheCourse(ArrayList<Student>viewAllCourses) {
		//we pass our ArrayList in the viewAllCourses
		for (int i = 0; i < viewAllCourses.size(); i++) {
			System.out.println("|************************************************************************************|");
			System.out.println("|\tStudents on the course:\n"+
					"\n\tFirst Name :"+"  "+viewAllCourses.get(i).getFirstName() +//First Name
					"\n\tLast Name :"+"  "+viewAllCourses.get(i).getLastName() +//Last Name
					"\n\tId :" + "  " +viewAllCourses.get(i).getStudentId()+//Id
					"\n\tStatus :"+"  "+viewAllCourses.get(i).getIsForeign()+//Status;Home/Foreign
			         "\n\tCourse :"+" "+viewAllCourses.get(i).getCourse()+//Course
			         "\n\tEmail :"+"  "+viewAllCourses.get(i).getEmail()+//Email
			         "\n\tAddress :"+"  "+viewAllCourses.get(i).getAddress()+//Address
			         "\n\tBalance :"+"  "+viewAllCourses.get(i).getBalance()+"\n");//End
			System.out.println("|************************************************************************************|");
			
		}
		System.out.println("\tThe number of students registered on this course is :"+viewAllCourses.size());
	}//Method that takes a generic Arraylist and prints all the courses

	
	public void deleteTheStudent(String checkedName , ArrayList<Student>checkedArray) {
		
		Iterator<Student> itr = checkedArray.iterator();
		while(itr.hasNext()) {
			Student itrStudent = (Student)itr.next();
			if(itrStudent.getLastName().equalsIgnoreCase(checkedName)) {
				checkedArray.remove(itrStudent);
				System.out.println("First Name: "+itrStudent.getFirstName()+"\n "
				                    +"Last Name: "+itrStudent.getLastName()+"\n"
				                    +"ID: "+itrStudent.getStudentId()+"\n\n"
				                    +" has been succesfuly removed from this course");
				return;
			}
		}
	}
		
	public void payYourFees(String yourName,ArrayList<Student>anotherArraylist) {
		
		for(int i=0;i<anotherArraylist.size();i++) {
			Scanner scan = new Scanner(System.in);
			Student studentToPay=anotherArraylist.get(i);
			if(studentToPay.getLastName().contains(yourName)&&studentToPay.getIsForeign()==true) {
				System.out.println("Available options :" + "\nPress:\n\t A) Pay a fee of 2000£ \n\t B) Pay a fee of 4000£\n\t C) Pay the entire amount of 6000£\n 0)Quit\n");
				System.out.println("Enter an amount:");
				int amount = scan.nextInt();
				// the fees to be paid
				 initialAmount = 2000;
				 secondAmount = 4000;
				 lastAmount = 6000;
				 if(amount == initialAmount && studentToPay.getBalance()<6000) {
					 studentToPay.setBalance(initialAmount);
					 System.out.println("you have a deposit of: "+initialAmount+"£");
					 break;
				 }else if (amount==secondAmount && studentToPay.getBalance()<6000) {
					 studentToPay.setBalance(secondAmount);
					 System.out.println("you have a deposit of: "+secondAmount+"£");
					 break;
				}else if (amount ==lastAmount && studentToPay.getBalance()<6000) {
					System.out.println("you have a deposit of: "+lastAmount+"£");
					break;
				} else
				 {
					System.out.println("Operation not valid");
					break;	
				}
				//The end of the if statement with the options for the foreign Student
			}else if(studentToPay.getLastName().contains(yourName)&&studentToPay.getIsForeign()==false){	
				System.out.println("Available options :" + "\nPress:\n\t A) Pay a fee of 1000£ \n\t B) Pay a fee of 2000£\n\t C) Pay the entire amount of 3000£\n 0)Quit");
				System.out.println("Enter an amount:");
				int anAmount = scan.nextInt();
				initialAmount = 1000;
				secondAmount = 2000;
				lastAmount = 3000;
				if(anAmount == initialAmount&&studentToPay.getBalance()<3000) {
					 studentToPay.setBalance(initialAmount);
					 System.out.println("you have a deposit of: "+initialAmount);
				     break;
				     }else if (anAmount==secondAmount&&studentToPay.getBalance()<3000) {
				    	 studentToPay.setBalance(secondAmount);
						 System.out.println("you have a deposit of: "+secondAmount);
						break;
					}else if (anAmount==lastAmount&&studentToPay.getBalance()<3000) {
						studentToPay.setBalance(lastAmount);
						System.out.println("you have a deposit of: "+lastAmount);
						break;
					}else {
						System.out.println("Operation not valid!");
						break;
					}
			  }
				   
		}
	
		
	}
	
	public void showReports() {
		
		int accountingSize = accountingCourse.size();
		int businessSize = businessCourse.size();
		int computingSize = computingCourse.size();
		
        if( accountingSize >= businessSize && accountingSize >= computingSize)
            System.out.println("Accounting course is the most popular with "+accountingSize+" students enrolled\n");
        else if (businessSize >= accountingSize && businessSize >= computingSize)
            System.out.println("Business course is the most popular with "+businessSize+" students enrolled\n");
        else
            System.out.println("Computing course is the most popular with "+computingSize+" students enrolled\n");
        //************************************
        if( accountingSize <= businessSize && accountingSize <= computingSize)
            System.out.println("The less populard Accounting with "+accountingSize+" students enrolled\n");
        else if (businessSize <= accountingSize && businessSize <= computingSize)
            System.out.println("The less popular is Business with "+businessSize+" students enrolled\n");
        else
            System.out.println("The less popular is Computing with "+computingSize+" students enrolled\n");
	
	}
	
public void enterYourChoice() {
	System.out.println("|************************************************************************************|");
	System.out.println("|                 Enter your choice:\n                                                ");
	System.out.println("  A) Accounting\n" + "  B) Business\n" + "  C) Computing\n"+ "  0) Quit"               );
	System.out.println("|************************************************************************************|");
}
	

//************************************************File Management************************************************


// <The File Writers>******************************************************
public void printFileAccounting() throws IOException {

	// The PrintWriter and The file always outside the for loop otherwise
	// you are overwriting the file over and over again
	File accountingFile = new File("AccountingData.txt");
	
	
	FileWriter fileWriter = new FileWriter(accountingFile,true);
	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	PrintWriter prtWriter = new PrintWriter(bufferedWriter);

	for (Student st : accountingCourse) {
		prtWriter.println("Students First Name :" + st.getFirstName() + "\n" + "Students Last Name : "
				+ st.getLastName() + "\n" + "Students ID : " + st.getStudentId() + "\n" + "\n" + "");
	}
	prtWriter.close();// this one outside the loop as well
	bufferedWriter.close();
	fileWriter.close();

}// File Reading from the Accounting file with all the students

public void printFileBusiness() throws IOException {
	File businessFile = new File("BusinessData.txt");
	PrintWriter prtWriter = new PrintWriter(businessFile);// Business File
	for (Student st : businessCourse) {
		prtWriter.println("Students First Name :" + st.getFirstName() + "\n" + "Students Last Name : "
				+ st.getLastName() + "\n" + "Students ID : " + st.getStudentId() + "\n" + "\n" + "");
	}
	prtWriter.close();// this one outside the loop as well

}

public void printFileComputing() throws IOException {
	File computingFile = new File("ComputingData.txt");
	PrintWriter prtWriter = new PrintWriter(computingFile);// Computing File
	for (Student st : computingCourse) {
		prtWriter.println("Students First Name :" + st.getFirstName() + "\n" + "Students Last Name : "
				+ st.getLastName() + "\n" + "Students ID : " + st.getStudentId() + "\n" + "\n" + "");
	}
	prtWriter.close();// this one outside the loop as well

}

// </File Writers>*********************************************************

//<File Readers>***********************************************************
public void readFileAccounting() {

	try {
		FileReader fileReader = new FileReader("AccountingData.txt");
		BufferedReader buffReader = new BufferedReader(fileReader);
		String textLine = "";
		try {
			while ((textLine = buffReader.readLine()) != null) {

				System.out.println(textLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void readFileBusiness() {
	try {
		FileReader fileReader = new FileReader("BusinessData.txt");
		BufferedReader buffReader = new BufferedReader(fileReader);
		String textLine = "";
		try {
			while ((textLine = buffReader.readLine()) != null) {

				System.out.println(textLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public void readFileComputing() {
	try {
		FileReader fileReader = new FileReader("ComputingData.txt");
		BufferedReader buffReader = new BufferedReader(fileReader);
		String textLine = "";
		try {
			while ((textLine = buffReader.readLine()) != null) {

				System.out.println(textLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//</File Readers>**************************************************************************************************



//**********************************Good Methods That work but Redundant Coding**************************



//public void showAccountingCourse() {
//// We are dealing with the Accounting course
//// We are listing all the students in the course
//for (int i = 0; i < accountingCourse.size(); i++) {
//	System.out.println("|************************************************************************************|");
//	System.out.println("|\tStudents on Accounting:\n"+
//			"\n\tFirst Name :"+"  "+accountingCourse.get(i).getFirstName() +//First Name
//			"\n\tLast Name :"+"  "+accountingCourse.get(i).getLastName() +//Last Name
//			"\n\tId :" + "  " +accountingCourse.get(i).getStudentId()+//Id
//			"\n\tStatus :"+"  "+accountingCourse.get(i).getIsForeign()+//Status;Home/Foreign
//	         "\n\tCourse :"+" "+accountingCourse.get(i).getCourse()+//Course
//	         "\n\tEmail :"+"  "+accountingCourse.get(i).getEmail()+//Email
//	         "\n\tAddress :"+"  "+accountingCourse.get(i).getAddress()+//Address
//	         "\n\tBalance :"+"  "+accountingCourse.get(i).getBalance()+"\n");//End
//	System.out.println("|************************************************************************************|");
//	
//}
////readFileAccounting();
//System.out.println("\tThe number of students registered on Accounting is :"+accountingCourse.size());
//}
//
//public void showBusinessCourse() {
//// We are dealing with the Business course
//// We are listing all the students in the course
//for (int i = 0; i < businessCourse.size(); i++) {
//	System.out.println("|************************************************************************************|");
//	System.out.println("|\tStudents on Business :\n" + 
//			"\n\tFirst Name :"+"  "+businessCourse.get(i).getFirstName() +//First Name
//			"\n\tLast Name :"+"  "+businessCourse.get(i).getLastName() +//Last Name
//			"\n\tId : " + "  " +businessCourse.get(i).getStudentId()+//Id
//			"\n\tStatus :"+"  "+businessCourse.get(i).getIsForeign()+//Status;Home/Foreign
//	         "\n\tCourse :"+" "+businessCourse.get(i).getCourse()+//Course
//	         "\n\tEmail :"+"  "+businessCourse.get(i).getEmail()+//Email
//	         "\n\tAddress :"+"  "+businessCourse.get(i).getAddress()+//Address
//	         "\n\tBalance :"+"  "+businessCourse.get(i).getBalance()+"\n");//End
//	System.out.println("|************************************************************************************|");
//}
////readFileBusiness();
//System.out.println("\tThe number of students registered on Business is :"+businessCourse.size());
//}
//
//public void showComputingCourse() {
//
//// We are dealing with the Computing course
//// We are listing all the students in the course
//for (int i = 0; i < computingCourse.size(); i++) {
//	System.out.println("|************************************************************************************|");
//	System.out.println("|\tStudents on Computing :\n" + 
//			"\n\tFirst Name :"+"  "+computingCourse.get(i).getFirstName() +//First Name
//			"\n\tLast Name :"+"  "+computingCourse.get(i).getLastName() +//Last Name
//			"\n\tId :" + "  " +computingCourse.get(i).getStudentId()+//Id
//			"\n\tStatus :"+"  "+computingCourse.get(i).getIsForeign()+//Status;Home/Foreign
//	         "\n\tCourse :"+" "+computingCourse.get(i).getCourse()+//Course
//	         "\n\tEmail :"+"  "+computingCourse.get(i).getEmail()+//Email
//	         "\n\tAddress :"+"  "+computingCourse.get(i).getAddress()+//Address
//	         "\n\tBalance :"+"  "+computingCourse.get(i).getBalance()+"\n");//End
//	System.out.println("|************************************************************************************|");
//}
////readFileComputing();
//System.out.println("\tThe number of students registered on Computing is :"+computingCourse.size());
//}

//**************************************************************************************************************
//public void isEnrolled(String aName) {
//// This method works just fine but i need to fix the println from if statements
////System.out.println("Enter Students surname:\n");
////Scanner scanner = new Scanner(System.in);
////aName = scanner.nextLine();
//for (int i = 0; i < this.enrolledStudents.size(); i++) {
//	Student verifiedStudent = this.getEnrolledStudents().get(i);
//	if (verifiedStudent.getLastName().equalsIgnoreCase(aName)) {
//		System.out.println("Student Information:\n");
//		System.out.println(" First Name: " + verifiedStudent.getFirstName() + "\n"
//				+ " Last Name: " + verifiedStudent.getLastName() + "\n" + " ID: "
//				+ verifiedStudent.getStudentId() + "\n"+
//				" balance: "+verifiedStudent.getBalance()+"\n");
//		if(verifiedStudent.getIsForeign()==true) {
//			System.out.println("The student is from abroad");
//			break;
//		}else {
//			System.out.println("The student is from Home");
//		}
//		System.out.println("Is enrolled at the college:");
//	} else if (!verifiedStudent.getLastName().equalsIgnoreCase(aName)) {
//		System.out.println("No Match");
//		break;
//		
//	}
//		
//}
//}// </isEnrolled>
//**************************************************************************************************************


//public void deleteStudent(String stDel) {
//
//Scanner scan = new Scanner(System.in);
//System.out.println("Enter the course :" + "\nPress:\n\t A) Accounting\n\t B) Business\n\t C) Computing\n 0)Quit\n");
//String rvOption = scan.nextLine();
//if(rvOption.equalsIgnoreCase(ACCOUNTING)) {
//	Iterator<Student> itr = accountingCourse.iterator();
//	while(itr.hasNext()) {
//		Student itrStudent = (Student)itr.next();
//		if(itrStudent.getLastName().equalsIgnoreCase(stDel)) {
//			accountingCourse.remove(itrStudent);
//			System.out.println(itrStudent.getFirstName()+itrStudent.getLastName()
//			                   +" has been succesfuly removed from this course");
//			return;
//		}else {
//			System.out.println("Student "+itrStudent.getFirstName()+
//					                      itrStudent.getLastName() + 
//					                      " not found on this course!");
//		}
//	}//Delete from accounting**************************************************************************************
//}else if (rvOption.equalsIgnoreCase(BUSINESS)) {
//	Iterator<Student> itr = businessCourse.iterator();
//	while(itr.hasNext()) {
//		Student itrStudent = (Student)itr.next();
//		if(itrStudent.getLastName().equalsIgnoreCase(stDel)) {
//			businessCourse.remove(itrStudent);
//			System.out.println(itrStudent.getFirstName()+itrStudent.getLastName()
//			                   +" has been succesfuly removed from this course");
//			return;
//		}else {
//			System.out.println("Student "+itrStudent.getFirstName()+
//					                      itrStudent.getLastName() + 
//					                      " not found on this course!");
//		}
//	}//Delete from Business******************************************************************************************
//}else if (rvOption.equalsIgnoreCase(COMPUTING)) {
//	Iterator<Student> itr = computingCourse.iterator();
//	while(itr.hasNext()) {
//		Student itrStudent = (Student)itr.next();
//		if(itrStudent.getLastName().equalsIgnoreCase(stDel)) {
//			computingCourse.remove(itrStudent);
//			System.out.println(itrStudent.getFirstName()+itrStudent.getLastName()
//			                   +" has been succesfuly removed from this course");
//			return;
//		}else {
//			System.out.println("Student "+itrStudent.getFirstName()+
//					                      itrStudent.getLastName() + 
//					                      " not found on this course!");
//		}
//	}//Delete from Computing*****************************************************************************************
//}else {
//Iterator<Student> itr = enrolledStudents.iterator();
//while(itr.hasNext()) {
//Student itrStudent = (Student)itr.next();
//if(itrStudent.getLastName().equalsIgnoreCase(stDel)) {
//	enrolledStudents.remove(itrStudent);
//	System.out.println(itrStudent.getFirstName()+itrStudent.getLastName()
//	                   +" has been succesfuly removed from this course");
//	return;
//}else {
//	System.out.println("Student "+itrStudent.getFirstName()+
//			                      itrStudent.getLastName() + 
//			                      " not found on this course!");
//}
//}//While loop
//}//Else block
//


// <Failed Methods>************************************************************************************************

//public void deletStudentEnrollment(String stDeLete) {
//	Iterator<Student> itrEnrollment = enrolledStudents.iterator();
//	while(itrEnrollment.hasNext()) {
//		Student itrStudent = (Student)itrEnrollment.next();
//		if(itrStudent.getLastName().equalsIgnoreCase(stDeLete)) {
//			enrolledStudents.remove(itrStudent);
//			System.out.println(itrStudent.getFirstName()+itrStudent.getLastName()
//			                   +" has been succesfuly removed from this course");
//			break;
//			
//		}
//		
// }
//}




//	public void showStudentsOnCourse() {
//		System.out.println("|****************************************************|");
//		System.out.println("|     Would you like to see a particular course ?    |");
//		System.out.println("|********************* =Yes / No= *******************|");
//		System.out.println("|****************************************************|");
//		Scanner scan = new Scanner(System.in);
//		String option = scan.nextLine();
//		if(option.equalsIgnoreCase("Yes")) {
//			boolean quit = false;
//			String yourchoice = "q";
//			while(!quit) {
//				System.out.println("|****************************************************|");
//				System.out.println("|                 Enter your choice:\n               |");
//				System.out.println("|       1) Computing\n"
//						                + " 2) Accounting\n"
//						                + " 3) Business                                  |");
//				System.out.println("|====================================================|");
//				switch (yourchoice) {
//				case "q":
//					quit = true;
//					
//					
//				}
//			}
//		}
//		
//	}


//************************************************************************************

//*************************************************************************************************

//	public Student searchStudent(String studentName) {
//		for(int i = 0 ; i < enrolledStudents.size() ; i++) {
//			Student verifiedStudent = this.getEnrolledStudents().get(i);
//			if(verifiedStudent.equals(studentName)) {
//				return verifiedStudent;
//			}
//			
//		}
//		return null;
//	}
//	

//	public Student findUsingEnhancedForLoop() {
//		System.out.println("Enter a name:\n");
//		Scanner scanner = new Scanner(System.in);
//		String aName= scanner.nextLine();
//		for(Student student : this.enrolledStudents) {
//			if(student.getFirstName().contains(aName)) {
//				return student;
//			}
//		}
//		return null;
//	}





//</Failed Methods>*************************************************************************************************
//

}


