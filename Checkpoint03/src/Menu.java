import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {

    public static void printEntityList() {

        /*
         * for (int i = 0; i < listName.size(); i++) { System.out.print(i + 1 +
         * ". "); System.out.println(listName.get(i)); }
         */

        // PRINT EVERYTHING IN MEDIA TABLE
    }

    public static void manageUpdate(Scanner input) {

        int num = selectType(input);

        switch (num) {
            case 1:
                editMusic(input);
                break;
            case 2:
                editMovie(input);
                break;
            case 3:
                editAudiobook(input);
                break;
            default:
                break;
        }

    }

    public static void addMusicDatabase(Music music, ArrayList<String> artists) {
    	Connection conn = Database.c;
    	PreparedStatement stmt1 = null;
    	try {
            String sql = "INSERT INTO MUSIC VALUES (?, ?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, music.id.toString());
            stmt1.setString(2, music.songName);
            stmt1.setInt(3, music.length);
            stmt1.setString(4, music.albumName);
            stmt1.setString(5,  music.genreName);
            stmt1.setInt(6,  music.year);
            stmt1.executeUpdate();
            stmt1.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	PreparedStatement stmt2 = null;
    	try {
            String sql = "INSERT INTO MEDIA VALUES (?, ?, ?)";
            stmt2 = conn.prepareStatement(sql);
            stmt2.setString(1, music.id.toString());
            stmt2.setString(2, String.valueOf(music.year));
            stmt2.setString(3, "Music");
            stmt2.executeUpdate();
            stmt2.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	for(int i = 0; i < artists.size(); i++) {
    		String artistName = artists.get(i);
    		PreparedStatement stmt3 = null;
        	try {
                String sql = "INSERT INTO SONGWRITER VALUES (?, ?)";
                stmt3 = conn.prepareStatement(sql);
                stmt3.setString(1, music.id.toString());
                stmt3.setString(2, artistName);
                stmt3.executeUpdate();
                stmt3.close();
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        	PreparedStatement stmt4 = null;
        	try {
                String sql = "INSERT INTO ARTIST VALUES (?)";
                stmt4 = conn.prepareStatement(sql);
                stmt4.setString(1, artistName);
                stmt4.executeUpdate();
                stmt4.close();
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    	}
    }
    
    public static void addMusic(Scanner input) {
        int year;
        int length;
        String albumName;
        String songName;
        String genreName;
        ArrayList<String> artists = new ArrayList<>();

        System.out
                .print("Enter the year the song was released (must be int): ");
        year = Integer.parseInt(input.nextLine());
        System.out.print(
                "Enter the length of the song (in seconds, must be int): ");
        length = Integer.parseInt(input.nextLine());
        System.out.print("Enter the name of the album that the song is on: ");
        albumName = input.nextLine();
        System.out.print("Enter the name of the song: ");
        songName = input.nextLine();
        System.out.print("Enter the genre of the song: ");
        genreName = input.nextLine();

        System.out
                .print("Would you like to enter the name of an artist (y/n): ");
        String YN = input.nextLine();
        while (YN.equals("Y") || YN.equals("y")) {
            System.out.print("Enter the name of the artist: ");
            String artistName = input.nextLine();
            
            
            artists.add(artistName);

            System.out.print("Would you like to enter another artist (y/n): ");
            YN = input.nextLine();
        }

        Music music = new Music(year, length, albumName, songName, genreName,
                artists);

        addMusicDatabase(music, artists);
    }

    public static void editMusic(Scanner input) {
        String songName, columnName, toChange;

        System.out.print(
                "What's the name of the song that you would like to update?: ");
        songName = input.nextLine();

        System.out.print(
                "A: YEAR\nB: LENGTH\nC: ALBUM NAME\nD: GENRE\nWhat column would you like to change?: ");
        String selection = input.nextLine();
        if (selection.equals("A")) {
            columnName = "year";
        } else if (selection.equals("B")) {
            columnName = "length";
        } else if (selection.equals("C")) {
            columnName = "album";
        } else if (selection.equals("D")) {
            columnName = "genre";
        } else {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("What would you like to change " + columnName
                + " to? (if year or length then input must be int): ");
        toChange = input.nextLine();

        if (selection.equals("A") || selection.equals("B")) {
            Database.databaseCall("UPDATE MUSIC SET " + columnName + "= \'"
                    + Integer.parseInt(toChange) + "\' WHERE name = '"
                    + songName + "\';");
        } else {
            Database.databaseCall("UPDATE MUSIC SET " + columnName + "=\'"
                    + toChange + "\' WHERE name = \'" + songName + "\'");
        }
    }
    
    public static void deleteMusic(Scanner input) {
        String musicName;

        System.out.print(
                "What's the name of the song that you would like to delete?: ");
        musicName = input.nextLine();

        Database.databaseCall("DELETE FROM MUSIC WHERE name = \'" + musicName + "\';");
    }

    public static void addMovie(Scanner input) {
        int year;
        String director;
        String genre;
        String title;
        int length;
        ArrayList<Actor> actors = new ArrayList<>();

        System.out
                .print("Enter the year the movie was released (must be int): ");
        year = Integer.parseInt(input.nextLine());
        System.out.print("Enter the director of the movie: ");
        director = input.nextLine();
        System.out.print("Enter the genre of the movie: ");
        genre = input.nextLine();
        System.out.print("Enter the title of the movie: ");
        title = input.nextLine();
        System.out.print(
                "Enter the length of the movie (in minutes, must be int): ");
        length = Integer.parseInt(input.nextLine());

        System.out.print("Would you like to enter an actor (y/n): ");
        String YN = input.nextLine();
        while (YN.equals("Y")) {
            System.out.print("Enter the name of the actor: ");
            String actorName = input.nextLine();
            System.out.print("Enter the role of the actor: ");
            String role = input.nextLine();

            Actor actor = new Actor(actorName);
            actors.add(actor);

            System.out.print("Would you like to enter an actor (y/n): ");
            YN = input.nextLine();
        }

        Movie movie = new Movie(year, director, genre, title, length, actors);
        Database.databaseCall(
                "INSERT INTO MOVIE VALUES (" + movie.toString() + ")");
        Database.databaseCall(
                "INSERT INTO MEDIA VALUES (\'" + movie.id.toString() + "\', \'" + String.valueOf(movie.year) + "\', \'Music\');");
        for(int i = 0; i < movie.actors.size(); i++) {
        	String actorName = movie.actors.get(i).name;
            Database.databaseCall(
                    "INSERT INTO FILM_RELATION VALUES (\'" + movie.id.toString() + "\', \'" + actorName  + "\');");
            Database.databaseCall(
                    "INSERT INTO ACTOR VALUES (\'" + actorName  + "\');");
        }
    }

    public static void editMovie(Scanner input) {
        String movieName, columnName, toChange;

        System.out.print(
                "What's the name of the movie that you would like to update?: ");
        movieName = input.nextLine();

        System.out.print(
                "What column would you like to change?\nA: YEAR\nB: DIRECTOR\nC: GENRE");
        String selection = input.nextLine();
        if (selection.equals("A")) {
            columnName = "year";
        } else if (selection.equals("B")) {
            columnName = "director";
        } else if (selection.equals("C")) {
            columnName = "genre";
        } else {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("What would you like to change " + columnName
                + " to? (if year then input must be int): ");
        toChange = input.nextLine();

        if (selection.equals("A")) {
            Database.databaseCall("UPDATE MOVIE SET " + columnName + "=\'"
                    + Integer.parseInt(toChange) + "\' WHERE name = \'"
                    + movieName + "\';");
        } else {
            Database.databaseCall("UPDATE MOVIE SET " + columnName + "=\'"
                    + toChange + "\' WHERE name = \'" + movieName + "\';");
        }
    }
    
    public static void deleteMovie(Scanner input) {
        String movieName;

        System.out.print(
                "What's the name of the movie that you would like to delete?: ");
        movieName = input.nextLine();

        Database.databaseCall("DELETE FROM MOVIE WHERE name = \'" + movieName + "\';");
    }


    public static void addAudiobook(Scanner input) {
        int year;
        String title;
        String genre;
        int chapters;
        int length;
        ArrayList<String> authors = new ArrayList<>();

        System.out.print(
                "Enter the year the audiobook was released (must be int): ");
        year = Integer.parseInt(input.nextLine());
        System.out.print("Enter the title of the audiobook: ");
        title = input.nextLine();
        System.out.print("Enter the genre of the audiobook: ");
        genre = input.nextLine();
        System.out.print("Enter the number of chapters (must be int): ");
        chapters = Integer.parseInt(input.nextLine());
        System.out.print(
                "Enter the length of the audiobook in minutes (must be int): ");
        length = Integer.parseInt(input.nextLine());

        System.out.print("Would you like to enter an author (y/n): ");
        String YN = input.nextLine();
        while (YN.equals("Y")) {
            System.out.print("Enter the name of the author: ");
            String author = input.nextLine();

            authors.add(author);

            System.out.print("Would you like to enter an author (y/n): ");
            YN = input.nextLine();
        }

        Audiobook audiobook = new Audiobook(year, title, genre, chapters,
                length, authors);
        Database.databaseCall(
                "INSERT INTO AUDIOBOOK VALUES (" + audiobook.toString() + ")");
        Database.databaseCall(
                "INSERT INTO MEDIA VALUES (\'" + audiobook.id.toString() + "\', \'" + String.valueOf(audiobook.year) + "\', \'Music\');");
        for(int i = 0; i < audiobook.authors.size(); i++) {
        	String authorName = audiobook.authors.get(i);
            Database.databaseCall(
                    "INSERT INTO BOOK_AUTHOR VALUES (\'" + audiobook.id.toString() + "\', \'" + authorName  + "\');");
            Database.databaseCall(
                    "INSERT INTO AUTHOR VALUES (\'" + authorName  + "\');");
        }
    }

    public static void editAudiobook(Scanner input) {
        String audiobookName, columnName, toChange;

        System.out.print(
                "What's the name of the audiobook that you would like to update?: ");
        audiobookName = input.nextLine();
        System.out.print(
                "What column would you like to change?\nA: YEAR\nB: LENGTH\nC: CHAPTERS\nD: GENRE");
        String selection = input.nextLine();
        if (selection.equals("A")) {
            columnName = "year";
        } else if (selection.equals("B")) {
            columnName = "length";
        } else if (selection.equals("C")) {
            columnName = "chapters";
        } else if (selection.equals("D")) {
            columnName = "genre";
        } else {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("What would you like to change " + columnName
                + " to? (if year, length, or chapters then input must be int): ");
        toChange = input.nextLine();

        if (selection.equals("A") || selection.equals("B")
                || selection.equals("C")) {
            Database.databaseCall("UPDATE AUDIOBOOK SET " + columnName + "=\'"
                    + Integer.parseInt(toChange) + "\' WHERE name = \'"
                    + audiobookName + "\'");
        } else {
            Database.databaseCall("UPDATE AUDIOBOOK SET " + columnName + "=\'"
                    + toChange + "\' WHERE name = \'" + audiobookName + "\'");
        }
    }
    
    public static void deleteAudiobook(Scanner input) {
        String audiobookName;

        System.out.print(
                "What's the name of the audiobook that you would like to delete?: ");
        audiobookName = input.nextLine();

        Database.databaseCall("DELETE FROM AUDIOBOOK WHERE name = \'" + audiobookName + "\';");
    }

    public static void addRecord(Scanner input) {
        String select = "";
        System.out.println("A: Music");
        System.out.println("B: Movie");
        System.out.println("C: Audiobook");
        System.out.println("D: Back to Menu");
        System.out.print("Select a type to add to record: ");

        select = input.nextLine();

        switch (select) {
            case "A":
                addMusic(input);
                break;
            case "B":
                addMovie(input);
                break;
            case "C":
                addAudiobook(input);
                break;
            case "D":
                return;
            default:
                System.out.println("Invalid selection, please select again.");
                select = "";
                addRecord(input);
                break;
        }
    }
    
    public static void deleteRecord(Scanner input) {
        String select = "";
        System.out.println("A: Music");
        System.out.println("B: Movie");
        System.out.println("C: Audiobook");
        System.out.println("D: Back to Menu");
        System.out.print("Select a type to delete from record: ");

        select = input.nextLine();

        switch (select) {
            case "A":
                deleteMusic(input);
                break;
            case "B":
                deleteMovie(input);
                break;
            case "C":
                deleteAudiobook(input);
                break;
            case "D":
                return;
            default:
                System.out.println("Invalid selection, please select again.");
                select = "";
                addRecord(input);
                break;
        }
    }

    /*
    public static int checkEntity(String name, int type) {
        boolean exists = false;
        int ret = -1;
        switch (type) {
            case 1:
                for (int i = 0; !exists && i < musicList.size(); i++) {
                    Music curr = musicList.get(i);
                    if (curr.songName.equals(name)) {
                        exists = true;
                        ret = i;
                    }
                }
                break;
            case 2:
                for (int i = 0; !exists && i < movieList.size(); i++) {
                    Movie curr = movieList.get(i);
                    if (curr.title.equals(name)) {
                        exists = true;
                        ret = i;
                    }
                }
                break;
            case 3:
                for (int i = 0; !exists && i < audiobookList.size(); i++) {
                    Audiobook curr = audiobookList.get(i);
                    if (curr.title.equals(name)) {
                        exists = true;
                        ret = i;
                    }
                }
                break;
            default:
                break;
        }
        return ret;
    }
    */

    public static void searchRecord(Scanner input) {
        String search = "", select = "";
        System.out.println("A: Music");
        System.out.println("B: Movie");
        System.out.println("C: Audiobook");
        System.out.println("D: Back to Menu");
        System.out.print("Select a type of record to search: ");

        select = input.nextLine();

        int check;
        switch (select) {
            case "A":
                System.out.print("Type the name of the song you wish to see: ");
                search = input.nextLine();
                Database.databaseCall("SELECT * FROM MUSIC WHERE name = \'" + search + "\';");
                break;
            case "B":
                System.out
                        .print("Type the name of the movie you wish to see: ");
                Database.databaseCall("SELECT * FROM MOVIE WHERE name = \'" + search + "\';");
                break;
            case "C":
                System.out.print(
                        "Type the name of the audiobook you wish to see: ");
                search = input.nextLine();
                Database.databaseCall("SELECT * FROM AUDIOBOOK WHERE name = \'" + search + "\';");
                break;
            case "D":
                return;
            default:
                System.out.println("Invalid selection, please select again.");
                select = "";
                searchRecord(input);
                break;
        }

        System.out.print("Do you wish to search again? (y/n): ");
        select = input.nextLine();
        if (select.equals("Y") || select.equals("y")) {
            searchRecord(input);
        } else {
            return;
        }
    }
    
    public static void searchPerson(Scanner input) {}

    /*
    public static void orderItems(Scanner input) {
        int subChoice = selectType(input);
        int index = 0;

        int numDigCopies;
        int numPhysCopies;
        double price;
        LocalDate arrivalDate;
        Entity media = null;

        switch (subChoice) {
            case 1:
                printEntityList(musicList);
                System.out.print(
                        "Enter the number corresponding to the music you want to update (must be int): ");
                index = Integer.parseInt(input.nextLine()) - 1;
                media = musicList.get(index);
                break;
            case 2:
                printEntityList(movieList);
                System.out.print(
                        "Enter the number corresponding to the movie you want to update (must be int): ");
                index = Integer.parseInt(input.nextLine()) - 1;
                media = movieList.get(index);
                break;
            case 3:
                printEntityList(audiobookList);
                System.out.print(
                        "Enter the number corresponding to the audiobook you want to update (must be int): ");
                index = Integer.parseInt(input.nextLine()) - 1;
                media = audiobookList.get(index);
                break;
            default:
                break;
        }

        System.out.print(
                "Enter the number of digital copies ordered (must be int): ");
        numDigCopies = Integer.parseInt(input.nextLine());
        System.out.print(
                "Enter the number of physical copies ordered (must be int): ");
        numPhysCopies = Integer.parseInt(input.nextLine());
        System.out.print("Enter price (must be double): ");
        price = Double.parseDouble(input.nextLine());
        System.out.print("Enter the arrival date (January 2, 2010): ");
        String dateString = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        arrivalDate = LocalDate.parse(dateString, formatter);

        Order order = new Order(media.type, numDigCopies, numPhysCopies, price,
                arrivalDate, media);

        orders.add(order);

        System.out.println(order);

    }
    */

    public static int selectType(Scanner input) {

        System.out.println("1. Music");
        System.out.println("2. Movie");
        System.out.println("3. Audiobook");
        System.out.print("Select a type of record to order: ");
        int subChoice = Integer.parseInt(input.nextLine());

        return subChoice;
    }
}
