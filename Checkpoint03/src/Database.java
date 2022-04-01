import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {

    //REQUIREMENTS FOR CONNECTING TO DATABASE
    private static String DATABASE = "Checkpoint4.db";
    private static Connection c;

    /**
     * Connects to the database if it exists, creates it if it does not, and
     * returns the connection object.
     *
     * @param databaseFileName
     *            the database file name
     * @return a connection object to the designated database
     */
    public static Connection initializeDB() {
        String url = "jdbc:sqlite:" + DATABASE;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out
                        .println("The driver name is " + meta.getDriverName());
                System.out.println(
                        "The connection to the database was successful.");
            } else {
                System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out
                    .println("There was a problem connecting to the database.");
        }
        return conn;
    }

    public static void databaseCall(String sql) {
    	Connection conn = c;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value);
                if (i < columnCount) {
                    System.out.print(",  ");
                }
            }
            System.out.print("\n");
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                    if (i < columnCount) {
                        System.out.print(",  ");
                    }
                }
                System.out.print("\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        System.out.println("Establishing connection...");
        Connection connection = initializeDB();
        c = connection;

        Scanner input = new Scanner(System.in);

        System.out.println("A: Add Record into Database");
        System.out.println("B: Update Record in Database");
        System.out.println("D: Delete Record in Database");
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
                case "D":
                	Menu.deleteRecord(input);
                	break;
                case "S":
                    Menu.searchRecord(input);
                    break;
                case "O":
                    //Menu.orderItems(input);
                    break;
                default:
                    break;
            }
            System.out.println("A: Add Record into Database");
            System.out.println("B: Update Record in Database");
            System.out.println("D: Delete Record in Database");
            System.out.println("S: Search a Record in the Database");
            System.out.println("O: Order New Items");
            System.out.println("Q: Quit");
            System.out.print("How to you wish to proceed?: ");
            choice = input.nextLine();
        }
    }
}
