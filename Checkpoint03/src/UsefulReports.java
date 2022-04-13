import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UsefulReports {
	
	public static void displayCheckouts(Scanner input) {
		System.out.print("Enter the email of the patron you want to see the number of checkouts for: ");
		String email = input.nextLine();
		
		Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;
        try {
            String sql = "SELECT COUNT(*) "
            		+ "FROM CUSTOMER_MEDIA_DUEDATE "
            		+ "WHERE email = ?;";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, email);
            results = stmt1.executeQuery();
            System.out.println("\nTOTAL NUMBER OF CHECKOUTS BY " + email + ": " + results.getString(1) + "\n");
            stmt1.close();
            results.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void mostPopularActor(Scanner input) {
		Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;
        try {
            String sql1 = "SELECT F.actorName "
            		+ "FROM FILM_RELATION as F, MEDIA_INVENTORY_INSTANCE as MII "
            		+ "WHERE F.movieId = MII.mediaId AND F.movieId IN( " 
            			+ "SELECT MII.mediaId "
            			+ "FROM MEDIA_INVENTORY_INSTANCE as MII, CUSTOMER_MEDIA_DUEDATE as C, MOVIE as M "
            			+ "WHERE MII.mediaId = M.id "
            			+ "GROUP BY MII.mediaId "
            			+ "ORDER BY MII.orderNum DESC "
            			+ "LIMIT 1);";
            
            stmt1 = conn.prepareStatement(sql1);
            results = stmt1.executeQuery();
            System.out.println();
            System.out.println("MOST POPULAR ACTOR IS: " + results.getString(1));
            System.out.println();
            stmt1.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void mostListenedToArist(Scanner input) {}
	
	public static void mostListenedToAuthor(Scanner input) {}
	
	public static void mostMoviesCheckedOut(Scanner input) {}
	
	public static void tracksByArtistBeforeYear(Scanner input) {
		System.out.print("Enter the name of the ARTIST: ");
		String artist = input.nextLine();
		System.out.print("Enter the YEAR of which you want to find titles before (must be int): ");
		int year = Integer.parseInt(input.nextLine());
		
		Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;
        try {
            String sql = "SELECT * "
            		+ "FROM SONGWRITER, MUSIC "
            		+ "WHERE SONGWRITER.artistName = ? AND SONGWRITER.musicId = MUSIC.id AND MUSIC.year < ?";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, artist);
            stmt1.setInt(2,  year);
            results = stmt1.executeQuery();
            
            System.out.println();
            while(results.next()) {
            	System.out.println(results.getString("name"));
            }
            System.out.println();
            stmt1.close();
            results.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void usefulReports(Scanner input) {
		System.out.println("A: Display total number of checkouts by a single patron.");
		System.out.println("B: Find the most popular ACTOR in the database.");
		System.out.println("C: Find the most listened to ARTIST in the database.");
		System.out.println("D: Find the most listened to AUTHOR in the database.");
		System.out.println("E: Find the patron with the most movies checked out.");
		System.out.println("F: Find the titles of all tracks by ARTIST before YEAR.");
		System.out.println("Q: Go back to Menu.");
		System.out.print("Select an option: ");
		String selection = input.nextLine();
		while(!selection.equals("Q")) {
			switch(selection) {
				case "A":
					displayCheckouts(input);
					break;
				case "B":
					mostPopularActor(input);
					break;
				case "C":
					mostListenedToArist(input);
					break;
				case "D":
					mostListenedToAuthor(input);
					break;
				case "E":
					mostMoviesCheckedOut(input);
					break;
				case "F":
					tracksByArtistBeforeYear(input);
					break;
				case "Q":
					return;
				default:
					System.out.println("Invalid selection, please select an option.");
			}
			System.out.println("A: Display all checkouts by a single patron.");
			System.out.println("B: Find the most popular ACTOR in the database.");
			System.out.println("C: Find the most listened to ARTIST in the database.");
			System.out.println("D: Find the most listened to AUTHOR in the database.");
			System.out.println("E: Find the patron with the most movies checked out.");
			System.out.println("F: Find the titles of all tracks by ARTIST before YEAR.");
			System.out.println("Q: Go back to Menu.");
			System.out.print("Select an option: ");
			selection = input.nextLine();
		}
	}
}
