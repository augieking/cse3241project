import java.sql.*;
import java.util.Scanner;

public class Database {
	static final String JDBC_DRIVER = "";
	static final String DB_URL = "";
	static final String USER = "";
	static final String PASS = "";
	
    public static void main(String args[]) {
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rSet = null;
    	try 
    	{
    		Class.forName(JDBC_DRIVER);
    		
    		System.out.println("Connecting to database...");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		String sql = "";
    		stmt = conn.prepareStatement(sql);
    		stmt.setInt(1, 1235550987);
    		
    		rSet = stmt.executeQuery();
    		while(rSet.next()) {
    			// EXAMPLE
    			String first = rSet.getString("first");
    			String last = rSet.getString("last");
    			System.out.println("Name: " + last + ", " + first);
    		}
    	}
    	catch(Exception e) 
    	{
    		//handle errors here...
    	}
    	finally 
    	{
    		//if(rSet != null) {rSet.close();}
    		//if(stmt != null) {stmt.close();}
    		//if(conn != null) {conn.close();}  		
    	}
    	
    	
        Scanner input = new Scanner(System.in);

        System.out.println("A: Add Record into Database");
        System.out.println("B: Update Record in Database");
        System.out.println("S: Search a Record in the Database");
        System.out.println("O: Order New Items");
        System.out.println("Q: Quit");
        System.out.print("How to you wish to proceed?: ");
        String choice = input.nextLine();

        while (!(choice.equals("Q"))) {
            switch (choice) {
                case "A":
                    Menu.addRecord(input);
                    break;
                case "B":
                    Menu.manageUpdate(input);
                    break;
                case "S":
                    Menu.searchRecord(input);
                    break;
                case "O":
                    Menu.orderItems(input);
                    break;
                default:
                    break;
            }
            System.out.println("A: Add Record into Database");
            System.out.println("B: Update Record in Database");
            System.out.println("S: Search a Record in the Database");
            System.out.println("O: Order New Items");
            System.out.println("Q: Quit");
            System.out.print("How to you wish to proceed?: ");
            choice = input.nextLine();
        }
    }
}
