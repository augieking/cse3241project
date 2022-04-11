import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UsefulReports {
	
	public static void displayCheckouts(Scanner input) {}
	
	public static void mostPopularActor(Scanner input) {}
	
	public static void mostListenedToArist(Scanner input) {}
	
	public static void mostListenedToAuthor(Scanner input) {}
	
	public static void mostMoviesCheckedOut(Scanner input) {}
	
	public static void tracksByArtistBeforeYear(Scanner input) {}
	
	public static void usefulReports(Scanner input) {
		System.out.println("A: Display all checkouts by a single patron.");
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
