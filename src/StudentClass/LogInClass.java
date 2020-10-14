package StudentClass;

import java.util.Scanner;

public class LogInClass {
	
	private static int count=2;
	private static Scanner logInScan;
	private static final String username = "Admin";
	private static final String password = "123";
	private String hisUsername;
	private String hisPassword;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         logInOperation();
		
		
	}
	public static void logInOperation() {
		System.out.println("\n");
		System.out.println("          ==========================================================");
		System.out.println("          |                                                        |");
		System.out.println("          |                         Welcome!                       |");
		System.out.println("          |                                                        |");
		System.out.println("          |             Enter your username and password           |");
		System.out.println("          |                                                        |");
		System.out.println("          |                                                        |");
		System.out.println("          ==========================================================");
		
		System.out.println("Username : \n");
		logInScan = new Scanner(System.in);
		String hisUsername = logInScan.nextLine();
		System.out.println("Password : \n");
		String hisPassword = logInScan.nextLine();
		
		if(!hisUsername.equalsIgnoreCase(username)&&!hisPassword.equalsIgnoreCase(password)) {
			System.out.println("Try Again!\nAttemps remaining :" +count);
			count--;
			while(count!=-1) {
				logInOperation();	
			}
			
		}else {
			Main mainMenu = new Main();
			mainMenu.main(null);
		}
		             }
		
	}

