package StudentClass;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    //</The colours>**************************************
	private final static String ACCOUNTING ="a";
	private final static String BUSINESS ="b";
	private final static String COMPUTING ="c";
	private final static String GENERAL = "g";
	//</colours>*******************************************
	private static String yourMove;
	private final static String YES = "Y";
	private final static String NO = "n";
	private static boolean exit = false;
	private static Scanner sc = new Scanner(System.in);
	private static SchoolManagement schoolMng = new SchoolManagement("Roehampton");

	public static void main(String[] args) {

		// Student s1 = new Student();
		SchoolManagement school = new SchoolManagement("Roehampton");
		
		//boolean exit = false;
		int option = 0;

		printInstructions();
		

		while (!exit) {
			System.out.println("|************************************************************************************|");
			System.out.println("|\tEnter your choice from the Menu: \n                                            ");
			System.out.println("|\t1) Options\t0) Quit                                                      |");
			System.out.println("|====================================================================================|");
			System.out.println("\n");
			System.out.println(" ");
			// <Scanner>
			option = sc.nextInt();
            //</Scanner>
			switch (option) {
                //Away we go :)
			case 0:
				saveAndExit();
				System.out.println("\n");
				//exit = true;
				// We are setting the boolean to quit the program
				break;
			case 1:
				printInstructions();//The Main Menu instructions
				break;
			case 2:
				school.addStudent();
				System.out.println(" ");
				break;
			case 3:
				System.out.println("|************************************************************************************|");
				System.out.println("|\tEnrolled Students:                                                           |");
				System.out.println("|************************************************************************************|");
				school.printEnrolled();//The List with All the enrolled Students
				break;
			case 4:
				System.out.println("|************************************************************************************|");
				System.out.println("|\tAdd student on a course:                                                     |");
				System.out.println("|************************************************************************************|");
				school.addStudentsOnCourse();
				break;
			case 5:
				System.out.println("|************************************************************************************|");
				System.out.println("|\tFind a student in the college                                                |");
				System.out.println("|************************************************************************************|");
				//school.findStudent();
				lookForStudent();
				//schoolMng.findUsingEnhancedForLoop();
				//Testing all this methods was a nightmare :D
				  //school.isEnrolled();
				break;
				
			case 6:
				System.out.println("|************************************************************************************|");
				System.out.println("|\tRemove a student from a course                                                |");
				System.out.println("|************************************************************************************|");
				removeStudent();
				break;
				
			case 7:
				makePayments();
				break;
			case 8:
				showManagementReports();
				break;
				default: 
					System.out.println("");
					System.out.println("PLEASE ENTER A VALID CHOICE!");
					System.out.println("");
				
				break;
				//
			}//End of Switch

		}

	}

	



public static void lookForStudent() {
	SchoolManagement uni = new SchoolManagement("Name");
	Student someStudent;
	System.out.println("Enter Students Surname:\n");
	Scanner scanner = new Scanner(System.in);
	String aName = scanner.nextLine();
	System.out.println("|************************************************************************************|");
	System.out.println("|\nChoose where to search :" + "\nPress:\n\t A) Accounting\n\t B) Business\n\t C) Computing\n\t G) General List");
	System.out.println("|************************************************************************************|");
	Scanner scan = new Scanner(System.in);
	String whereTo = scan.nextLine();
	switch (whereTo) {
	case ACCOUNTING:
		someStudent=uni.findStudent(aName,uni.getAccountingCourse());
		if(someStudent!=null) {
			printSearchResults(someStudent);//Method that is defined separately
		}else {System.out.println("Your search has not returned any results");return;}
		break;
	case BUSINESS:
		someStudent=uni.findStudent(aName,uni.getBusinessCourse());
		if(someStudent!=null) {
			printSearchResults(someStudent);
		}else {System.out.println("Your search has not returned any results");return;}
        break;
	case COMPUTING:
		someStudent=uni.findStudent(aName,uni.getComputingCourse());
		if(someStudent!=null) {
			printSearchResults(someStudent);//printsearch method
		}else {System.out.println("Your search has not returned any results");return;}
		break;
	case GENERAL:
		someStudent=uni.findStudent(aName,uni.getEnrolledStudents());
		if(someStudent!=null) {
			printSearchResults(someStudent);
		}else {System.out.println("Your search has not returned any results");return;}
		break;
	default:
		break;
	}
	
}

public static void removeStudent() {
	//I can only remove the first one at a time
	SchoolManagement uni = new SchoolManagement("Name");
	Student requiredStudent;
	//String yourMove;
	System.out.println("Enter surname of the student that you want to remove :");
	Scanner scanner = new Scanner(System.in);
	String stdToRemove = scanner.nextLine();
	System.out.println("|************************************************************************************|");
	System.out.println("|\nLocate The Student By Course:" + "\nPress:\n\t A) Accounting\n\t B) Business\n\t C) Computing\n\t G) Enrolled");
	System.out.println("|************************************************************************************|");
	String whichTo =scanner.nextLine();
	switch (whichTo) {
	case ACCOUNTING:
		//delete from the accounting ArrayList
		requiredStudent = uni.findStudent(stdToRemove,uni.getAccountingCourse());
		//printStudentToBeRemoved(requiredStudent, stdToRemove, uni.getAccountingCourse());
		if(requiredStudent!=null) {
		System.out.println("Match found : \n\n\t"+requiredStudent.getFirstName()+" "
		                    +requiredStudent.getLastName()+" ID : "
				            +requiredStudent.getStudentId()+"\n\n"
		                    +"Are you sure you want to delete this student?\n  [Y / N]");
		yourMove = scanner.nextLine();
		if(yourMove.equalsIgnoreCase(YES)&&requiredStudent!=null) {
			uni.deleteTheStudent(stdToRemove, uni.getAccountingCourse());	
		}//first if
		}//second if
		break;
	case BUSINESS:
		// delete from the business ArrayList
		requiredStudent = uni.findStudent(stdToRemove,uni.getBusinessCourse());
		if(requiredStudent!=null) {
			System.out.println("Match found : \n\n\t"+requiredStudent.getFirstName()+" "
			                    +requiredStudent.getLastName()+" ID : "
					            +requiredStudent.getStudentId()+"\n\n"
			                    +"Are you sure you want to delete this student?\n  [Y / N]");
			yourMove = scanner.nextLine();
			if(yourMove.equalsIgnoreCase(YES)&&requiredStudent!=null) {
				uni.deleteTheStudent(stdToRemove, uni.getBusinessCourse());	
			}//first if
			}//second if
		break;
	case COMPUTING:
		// delete from the computing ArrayList
				requiredStudent = uni.findStudent(stdToRemove,uni.getComputingCourse());
				if(requiredStudent!=null) {
					System.out.println("Match found : \n\n\t"+requiredStudent.getFirstName()+" "
					                    +requiredStudent.getLastName()+" ID : "
							            +requiredStudent.getStudentId()+"\n\n"
					                    +"Are you sure you want to delete this student?\n  [Y / N]");
					yourMove = scanner.nextLine();
					if(yourMove.equalsIgnoreCase(YES)&&requiredStudent!=null) {
						uni.deleteTheStudent(stdToRemove, uni.getComputingCourse());	
					}//first if
					}//second if
		break;
	case GENERAL:
		// delete from the enrollment ArrayList
				requiredStudent = uni.findStudent(stdToRemove,uni.getEnrolledStudents());
				if(requiredStudent!=null) {
					System.out.println("Match found : \n\n\t"+requiredStudent.getFirstName()+" "
					                    +requiredStudent.getLastName()+" ID : "
							            +requiredStudent.getStudentId()+"\n\n"
					                    +"Are you sure you want to delete this student?\n  [Y / N]");
					yourMove = scanner.nextLine();
					if(yourMove.equalsIgnoreCase(YES)&&requiredStudent!=null) {
						uni.deleteTheStudent(stdToRemove, uni.getEnrolledStudents());	
					}//first if
					}//second if
		break;
	default:
		System.out.println("Not a valid key!");
		break;
	}
	
}

public static void saveAndExit() {
	System.out.println("|************************************************************************************|");
	System.out.println("|\tSave progress and exit?\n\t[Y / N]                                                 ");
	System.out.println("|************************************************************************************|");
	SchoolManagement uni = new SchoolManagement("name");
	TheDatabase theDb = new TheDatabase();
	Scanner scanner = new Scanner(System.in);
	String saveExit = scanner.nextLine();
	if(saveExit.equalsIgnoreCase(YES)) {
		try {
			System.out.println("|************************************************************************************|");
			System.out.println("|\tGood bye!                                                                    |");
			System.out.println("|************************************************************************************|");
			uni.printFileBusiness();
			uni.printFileAccounting();
			uni.printFileComputing();
			exit=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			theDb.createTable();
			theDb.postFromAccounting();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			theDb.createTable();
			theDb.postFromBusiness();
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			theDb.createTable();
			theDb.postFromComputing();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}else {
		return;
	}
}

public static void makePayments(){
	
	//On this one i need to work next time
	SchoolManagement uni = new SchoolManagement("Name");
	Student anotherStudent;
	System.out.println("Enter the name of the student");
	Scanner scanner = new Scanner(System.in);
	String payForStudent = scanner.nextLine();
	
	System.out.println("|************************************************************************************|");
	System.out.println("|\nLocate The Student By Course:" + "\nPress:\n\t A) Accounting\n\t B) Business\n\t C) Computing\n\t G) Enrolled");
	System.out.println("|************************************************************************************|");
	String whatTo =scanner.nextLine();
	switch (whatTo) {
	case ACCOUNTING:
		anotherStudent = uni.findStudent(payForStudent, uni.getAccountingCourse());
		if(anotherStudent!=null) {
			String hisName = anotherStudent.getLastName();
			uni.payYourFees(hisName,uni.getAccountingCourse());
		}else {return;}
		break;
	case BUSINESS: 
		anotherStudent = uni.findStudent(payForStudent, uni.getBusinessCourse());
		if(anotherStudent!=null) {
			String hisName = anotherStudent.getLastName();
			uni.payYourFees(hisName,uni.getBusinessCourse());
		}else {return;}
		break;
	case COMPUTING:
		anotherStudent = uni.findStudent(payForStudent, uni.getComputingCourse());
		if(anotherStudent!=null) {
			String hisName = anotherStudent.getLastName();
			uni.payYourFees(hisName,uni.getComputingCourse());
		}else {return;}
		break;
	case GENERAL:
		anotherStudent = uni.findStudent(payForStudent, uni.getEnrolledStudents());
		if(anotherStudent!=null) {
			String hisName = anotherStudent.getLastName();
			uni.payYourFees(hisName,uni.getEnrolledStudents());
		}else {return;}
		break;
		
	default:
		break;
	}
	//uni.findStudent(payForStudent);
	//uni.payYourFees(payForStudent);
	
}//makePyments

//Methods that print on the screen

public static void showManagementReports() {
	
	System.out.println("The stats:\n");
	if(schoolMng.getAccountingCourse().size()!=0 ||schoolMng.getBusinessCourse().size()!=0||schoolMng.getComputingCourse().size()!=0) {
		schoolMng.showReports();
	}else {
		System.out.println("There are no registered students on any of the modules\n");
	}
	
}

public static void printInstructions() {
	System.out.println("|************************************************************************************|");
	System.out.println("|-----------------------------BORING FUTURE COLLEGE----------------------------------|");
	System.out.println("|                                  *Main Menu*                                       |");
	System.out.println("|************************************************************************************|");
	System.out.println("|     \n                                                                                     |");
	System.out.println("|   Press :                                                                          |");
	System.out.println("|                                                                                    |");
	System.out.println("| \t1) Print Available Options                                                   |");
	System.out.println("| \t2) Student Enrollment                                                        |");
	System.out.println("| \t3) Print A List With The Enrolled Students                                   |");
	System.out.println("| \t4) Add A Student On A Course                                                 |");
	System.out.println("| \t5) Find A Student In The College                                             |");
	System.out.println("| \t6) Remove A Student                                                          |");
	System.out.println("| \t7) Pay The Fees                                                              |");
	System.out.println("| \t8) Management Report                                                         |");
	System.out.println("| \t0) Save And Exit.                                                            |");
	System.out.println("|                                                                                    |");
	System.out.println("|************************************************************************************|");
	System.out.println("|====================================================================================|");
}// Nothing to fancy ,just the main menu
public static void printSearchResults(Student theStudent) {

	System.out.println("Search Results:\n\n"+
	        "\tFirst Name : "+theStudent.getFirstName()+"\n"//First Name
            +"\tLast Name : "+theStudent.getLastName()+"\n"//Last Name
            +"\tStudent ID : "+theStudent.getStudentId()+"\n"//Student Id
            +"\tThe Course : " +theStudent.getCourse()+"\n"//Get the Course
            +"\tEmail : "+theStudent.getEmail()+"\n"//Get The Email Address
            +"\tAddress : "+theStudent.getAddress()+"\n"//Get The Address
            +"\tBalance : "+theStudent.getBalance()+"\n"//Balance
            );//i will use this method to on all the arraylist in order to code less and to keep everything clean
}// 

public static void printStudentToBeRemoved(Student requiredToRemove,String stdToBeRemoved,ArrayList<Student>tmpArraylist) {
	
	String yourMove;
	if(requiredToRemove!=null) {
		System.out.println("Match found : \n\n\t"+requiredToRemove.getFirstName()+" "
		                    +requiredToRemove.getLastName()+" ID : "
				            +requiredToRemove.getStudentId()+"\n\n"
		                    +"Are you sure you want to delete this student?\n  [Y / N]");
		yourMove = sc.nextLine();
		if(yourMove.equalsIgnoreCase(YES)&&requiredToRemove!=null) {
			schoolMng.deleteTheStudent(stdToBeRemoved, tmpArraylist);	
		   }else if(yourMove.equalsIgnoreCase(NO)) {
			   printInstructions();
		   }
	 }//if Statement
	
}

}//Main Class
