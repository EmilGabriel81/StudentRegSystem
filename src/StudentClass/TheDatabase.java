package StudentClass;

import java.sql.*;

public class TheDatabase {

	private SchoolManagement theSchool;
//	private String varFname;
//	private String varLname;
//	private String varId;
//	private String varCourse;
//	private String varEmail;
//	private String varAddress;
	
	

	public static Connection getConnection() throws Exception {
		try {

			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/my_project";
			String username = "root";
			String password = "";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;

		} catch (Exception e) {
			System.out.println("Something went Wrong:" + e);
		}
		return null;
	}

	public static void createTable() throws Exception {

		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS student"
					+ "(id int NOT NULL AUTO_INCREMENT, firstname varchar(255), lastname varchar(255),idschool varchar(255),course varchar(255),email varchar(255),address varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();
			// We create the table if it doesn`t already exist.
		} catch (Exception e) {
			System.out.println("We have encountered some problems:" + e);
		} finally {
			System.out.println("Functtion complete");
		}
	}

	public static void postFromAccounting() throws Exception{
        
     try {
          SchoolManagement theSchool = new SchoolManagement("uni");
         for(Student stud : theSchool.getAccountingCourse()) {
        	String varFname = stud.getFirstName();
        	String varLname = stud.getLastName();
        	String varId = stud.getStudentId();
        	String varCourse = stud.getCourse();
        	String varEmail = stud.getEmail();
        	String varAddress = stud.getAddress();
        	 Connection con = getConnection();
        	 PreparedStatement posted = con.prepareStatement("INSERT INTO student (firstname, lastname, idschool, course, email, address) VALUES ('"+varFname+"','"+varLname+"','"+varId+"','"+varCourse+"','"+varEmail+"','"+varAddress+"')");
        	  posted.executeUpdate();
         }
     }catch (Exception e) {System.out.println("Problems Detected:"+e);}
     finally {
		System.out.println("Insertion from Accounting Completed Successfully");
	}
	
	
	}	
	
 public static void postFromBusiness() throws Exception{
	        
		     try {
		          SchoolManagement theSchool = new SchoolManagement("uni");
		         for(Student stud : theSchool.getBusinessCourse()) {
		        	String varFname = stud.getFirstName();
		        	String varLname = stud.getLastName();
		        	String varId = stud.getStudentId();
		        	String varCourse = stud.getCourse();
		        	String varEmail = stud.getEmail();
		        	String varAddress = stud.getAddress();
		        	 Connection con = getConnection();
		        	 PreparedStatement posted = con.prepareStatement("INSERT INTO student (firstname, lastname, idschool, course, email, address) VALUES ('"+varFname+"','"+varLname+"','"+varId+"','"+varCourse+"','"+varEmail+"','"+varAddress+"')");
		        	  posted.executeUpdate();
		         }
		     }catch (Exception e) {System.out.println("Problems Detected:"+e);}
		     finally {
				System.out.println("Insertion from Business Completed Successfully");
			}
			
			
			}	
 public static void postFromComputing() throws Exception{
     
     try {
          SchoolManagement theSchool = new SchoolManagement("uni");
         for(Student stud : theSchool.getComputingCourse()) {
        	String varFname = stud.getFirstName();
        	String varLname = stud.getLastName();
        	String varId = stud.getStudentId();
        	String varCourse = stud.getCourse();
        	String varEmail = stud.getEmail();
        	String varAddress = stud.getAddress();
        	 Connection con = getConnection();
        	 PreparedStatement posted = con.prepareStatement("INSERT INTO student (firstname, lastname, idschool, course, email, address) VALUES ('"+varFname+"','"+varLname+"','"+varId+"','"+varCourse+"','"+varEmail+"','"+varAddress+"')");
        	  posted.executeUpdate();
         }
     }catch (Exception e) {System.out.println("Problems Detected:"+e);}
     finally {
		System.out.println("Insertion from Computing Completed Successfully");
	}

 }
}
