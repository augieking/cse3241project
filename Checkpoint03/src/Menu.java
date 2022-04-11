import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void printEntityList(int subChoice) {//TEST FOR COMMIT

        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;

        switch (subChoice) {
            case 1:
                try {
                    String sql = "SELECT * FROM MUSIC";
                    stmt1 = conn.prepareStatement(sql);
                    results = stmt1.executeQuery();
                    ResultSetMetaData meta = results.getMetaData();
                    int columnsNum = meta.getColumnCount();
                    while (results.next()) {
                        for (int i = 1; i <= columnsNum; i++) {
                            if (i > 1) {
                                System.out.print(", ");
                            }
                            String columnValue = results.getString(i);
                            System.out.print(columnValue);
                        }
                        System.out.println("");
                    }

                    if (results != null) {
                        results.close();
                    }
                    if (stmt1 != null) {
                        stmt1.close();
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                try {
                    String sql = "SELECT * FROM MOVIE";
                    stmt1 = conn.prepareStatement(sql);
                    results = stmt1.executeQuery();
                    ResultSetMetaData meta = results.getMetaData();
                    int columnsNum = meta.getColumnCount();
                    while (results.next()) {
                        for (int i = 1; i <= columnsNum; i++) {
                            if (i > 1) {
                                System.out.print(", ");
                            }
                            String columnValue = results.getString(i);
                            System.out.print(columnValue);
                        }
                        System.out.println("");
                    }

                    if (results != null) {
                        results.close();
                    }
                    if (stmt1 != null) {
                        stmt1.close();
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                break;

            case 3:
                try {
                    String sql = "SELECT * FROM AUDIOBOOK";
                    stmt1 = conn.prepareStatement(sql);
                    results = stmt1.executeQuery();
                    ResultSetMetaData meta = results.getMetaData();
                    int columnsNum = meta.getColumnCount();
                    while (results.next()) {
                        for (int i = 1; i <= columnsNum; i++) {
                            if (i > 1) {
                                System.out.print(", ");
                            }
                            String columnValue = results.getString(i);
                            System.out.print(columnValue);
                        }
                        System.out.println("");
                    }
                    if (results != null) {
                        results.close();
                    }
                    if (stmt1 != null) {
                        stmt1.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                break;
        }
    }

    public static void printMediaInstanceList(int subChoice) {

        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;
        String type = convertSubchoice(subChoice);

        try {
            String sql = "SELECT id, type, mediaId, orderNum, format "
                    + "FROM MEDIA_INVENTORY_INSTANCE as m LEFT JOIN CUSTOMER_MEDIA_DUEDATE as c on m.id = c.instanceId "
                    + "WHERE type = ? AND c.instanceId is NULL";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, type);
            results = stmt1.executeQuery();
            ResultSetMetaData meta = results.getMetaData();
            int columnsNum = meta.getColumnCount();
            while (results.next()) {
                for (int i = 1; i <= columnsNum; i++) {
                    if (i > 1) {
                        System.out.print(", ");
                    }
                    String columnValue = results.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }

            if (results != null) {
                results.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printEmployees() {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;

        try {
            String sql = "SELECT * FROM EMPLOYEES";
            stmt1 = conn.prepareStatement(sql);
            results = stmt1.executeQuery();
            ResultSetMetaData meta = results.getMetaData();
            int columnsNum = meta.getColumnCount();
            while (results.next()) {
                for (int i = 1; i <= columnsNum; i++) {
                    if (i > 1) {
                        System.out.print(", ");
                    }
                    String columnValue = results.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
            if (results != null) {
                results.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printCheckedOutMedia() {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;

        try {
            String sql = "SELECT * FROM CUSTOMER_MEDIA_DUEDATE";
            stmt1 = conn.prepareStatement(sql);
            results = stmt1.executeQuery();
            ResultSetMetaData meta = results.getMetaData();
            int columnsNum = meta.getColumnCount();
            while (results.next()) {
                for (int i = 1; i <= columnsNum; i++) {
                    if (i > 1) {
                        System.out.print(", ");
                    }
                    String columnValue = results.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
            if (results != null) {
                results.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printCustomers() {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;

        try {
            String sql = "SELECT * FROM CUSTOMER";
            stmt1 = conn.prepareStatement(sql);
            results = stmt1.executeQuery();
            ResultSetMetaData meta = results.getMetaData();
            int columnsNum = meta.getColumnCount();
            while (results.next()) {
                for (int i = 1; i <= columnsNum; i++) {
                    if (i > 1) {
                        System.out.print(", ");
                    }
                    String columnValue = results.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
            if (results != null) {
                results.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printUnactivatedOrders() {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;

        try {
            String sql = "SELECT * FROM MEDIA_ORDER_INSTANCE WHERE activated = ?";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setInt(1, 0);
            results = stmt1.executeQuery();
            ResultSetMetaData meta = results.getMetaData();
            int columnsNum = meta.getColumnCount();
            while (results.next()) {
                for (int i = 1; i <= columnsNum; i++) {
                    if (i > 1) {
                        System.out.print(", ");
                    }
                    String columnValue = results.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
            if (results != null) {
                results.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int getOrderNumber() {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet results = null;
        int orderNumber = 0;

        try {
            String sql = "SELECT max(orderNum) as orderNum FROM MEDIA_ORDER_INSTANCE";
            stmt1 = conn.prepareStatement(sql);
            results = stmt1.executeQuery();
            while (results.next()) {
                orderNumber = results.getInt("orderNum");
            }
            if (results != null) {
                results.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return orderNumber;
    }

//    public static Entity getItemFromId(String id, int subChoice) {
//        Connection conn = Database.c;
//        PreparedStatement stmt1 = null;
//        PreparedStatement stmt2 = null;
//        Entity entity = null;
//        switch (subChoice) {
//            case 1:
//                int year = 0;
//                int length = 0;
//                String albumName = "";
//                String songName = "";
//                String genreName = "";
//                ArrayList<String> artists = new ArrayList<>();
//
//                try {
//                    String sql = "SELECT name, year, length, genre, album FROM MUSIC WHERE id = ?";
//                    stmt1 = conn.prepareStatement(sql);
//                    stmt1.setString(1, id);
//                    ResultSet results = stmt1.executeQuery();
//                    while (results.next()) {
//                        songName = results.getString("name");
//                        year = results.getInt("year");
//                        length = results.getInt("length");
//                        genreName = results.getString("genre");
//                        albumName = results.getString("album");
//                    }
//
//                    String sql2 = "SELECT artistName FROM SONGWRITER WHERE musicId = ?";
//                    stmt2 = conn.prepareStatement(sql2);
//                    stmt2.setString(1, id);
//                    ResultSet artistSet = stmt2.executeQuery();
//                    while (artistSet.next()) {
//                        artists.add(results.getString("artistName"));
//                    }
//
//                } catch (SQLException e) {
//                    System.out.println(e.getMessage());
//                }
//
//                entity = new Music(year, length, albumName, songName, genreName,
//                        artists);
//
//                break;
//
//            case 2:
//                try {
//                    String sql = "SELECT * FROM MOVIE";
//                    stmt1 = conn.prepareStatement(sql);
//                    ResultSet results = stmt1.executeQuery();
//                    ResultSetMetaData meta = results.getMetaData();
//                    int columnsNum = meta.getColumnCount();
//                    while (results.next()) {
//                        for (int i = 1; i <= columnsNum; i++) {
//                            if (i > 1) {
//                                System.out.print(", ");
//                            }
//                            String columnValue = results.getString(i);
//                            System.out.print(columnValue);
//                        }
//                        System.out.println("");
//                    }
//
//                } catch (SQLException e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//
//            case 3:
//                try {
//                    String sql = "SELECT * FROM AUDIOBOOK";
//                    stmt1 = conn.prepareStatement(sql);
//                    ResultSet results = stmt1.executeQuery();
//                    ResultSetMetaData meta = results.getMetaData();
//                    int columnsNum = meta.getColumnCount();
//                    while (results.next()) {
//                        for (int i = 1; i <= columnsNum; i++) {
//                            if (i > 1) {
//                                System.out.print(", ");
//                            }
//                            String columnValue = results.getString(i);
//                            System.out.print(columnValue);
//                        }
//                        System.out.println("");
//                    }
//
//                } catch (SQLException e) {
//                    System.out.println(e.getMessage());
//                }
//
//                break;
//
//            default:
//                break;
//        }
//        return entity;
//    }

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

    public static void addMusicDatabase(Music music,
            ArrayList<String> artists) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "INSERT INTO MUSIC VALUES (?, ?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, music.id.toString());
            stmt1.setString(2, music.songName);
            stmt1.setInt(3, music.length);
            stmt1.setString(4, music.albumName);
            stmt1.setString(5, music.genreName);
            stmt1.setInt(6, music.year);
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
        for (int i = 0; i < artists.size(); i++) {
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

    public static void editMusicDatabase(String column, String song,
            String change) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "";
            if (column.equals("A")) {
                sql = "UPDATE MUSIC " + "SET YEAR = ? " + "WHERE name = ?";
            } else if (column.equals("B")) {
                sql = "UPDATE MUSIC " + "SET LENGTH = ? " + "WHERE name = ?";
            } else if (column.equals("C")) {
                sql = "UPDATE MUSIC " + "SET ALBUM = ? " + "WHERE name = ?";
            } else {
                sql = "UPDATE MUSIC " + "SET GENRE = ? " + "WHERE name = ?";
            }
            stmt1 = conn.prepareStatement(sql);
            if (column.equals("A") || column.equals("B")) {
                stmt1.setInt(1, Integer.parseInt(change));
            } else {
                stmt1.setString(1, change);
            }
            stmt1.setString(2, song);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

        editMusicDatabase(selection, songName, toChange);
    }

    public static void deleteMusicDatabase(String name) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "DELETE FROM MUSIC WHERE name = ?;";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, name);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMusic(Scanner input) {
        String musicName;

        System.out.print(
                "What's the name of the song that you would like to delete?: ");
        musicName = input.nextLine();

        deleteMusicDatabase(musicName);
    }

    public static void addMovieDatabase(Movie movie, ArrayList<Actor> actors) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "INSERT INTO MOVIE VALUES (?, ?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, movie.id.toString());
            stmt1.setString(2, movie.title);
            stmt1.setInt(3, movie.year);
            stmt1.setString(4, movie.director);
            stmt1.setString(5, movie.genre);
            stmt1.setInt(6, movie.length);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        PreparedStatement stmt2 = null;
        try {
            String sql = "INSERT INTO MEDIA VALUES (?, ?, ?)";
            stmt2 = conn.prepareStatement(sql);
            stmt2.setString(1, movie.id.toString());
            stmt2.setString(2, String.valueOf(movie.year));
            stmt2.setString(3, "Movie");
            stmt2.executeUpdate();
            stmt2.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < actors.size(); i++) {
            Actor actor = actors.get(i);
            PreparedStatement stmt3 = null;
            try {
                String sql = "INSERT INTO FILM_RELATION VALUES (?, ?, ?)";
                stmt3 = conn.prepareStatement(sql);
                stmt3.setString(1, movie.id.toString());
                stmt3.setString(2, actor.name);
                stmt3.setString(3, actor.role);
                stmt3.executeUpdate();
                stmt3.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            PreparedStatement stmt4 = null;
            try {
                String sql = "INSERT INTO ACTOR VALUES (?)";
                stmt4 = conn.prepareStatement(sql);
                stmt4.setString(1, actor.name);
                stmt4.executeUpdate();
                stmt4.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
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
        while (YN.equals("Y") || YN.equals("y")) {
            System.out.print("Enter the name of the actor: ");
            String actorName = input.nextLine();
            System.out.print(
                    "Enter the role of the actor (A for Lead, B for Supporting): ");
            String role = "Supporting Actor";
            if (input.nextLine().equals("A")) {
                role = "Lead Actor";
            }

            Actor actor = new Actor(actorName, role);
            actors.add(actor);

            System.out.print("Would you like to enter an actor (y/n): ");
            YN = input.nextLine();
        }

        Movie movie = new Movie(year, director, genre, title, length, actors);

        addMovieDatabase(movie, actors);
    }

    public static void editMovieDatabase(String column, String movie,
            String change) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "";
            if (column.equals("A")) {
                sql = "UPDATE MOVIE " + "SET year = ? " + "WHERE name = ?";
            } else if (column.equals("B")) {
                sql = "UPDATE MOVIE " + "SET director = ? " + "WHERE name = ?";
            } else {
                sql = "UPDATE MOVIE " + "SET genre = ? " + "WHERE name = ?";
            }
            stmt1 = conn.prepareStatement(sql);
            if (column.equals("A")) {
                stmt1.setInt(1, Integer.parseInt(change));
            } else {
                stmt1.setString(1, change);
            }
            stmt1.setString(2, movie);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editMovie(Scanner input) {
        String movieName, columnName, toChange;

        System.out.print(
                "What's the name of the movie that you would like to update?: ");
        movieName = input.nextLine();

        System.out.print(
                "A: YEAR\nB: DIRECTOR\nC: GENRE\nWhat column would you like to change?: ");
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

        editMovieDatabase(selection, movieName, toChange);
    }

    public static void deleteMovieDatabase(String name) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "DELETE FROM MOVIE WHERE name = ?;";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, name);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMovie(Scanner input) {
        String movieName;

        System.out.print(
                "What's the name of the movie that you would like to delete?: ");
        movieName = input.nextLine();

        deleteMovieDatabase(movieName);
    }

    public static void addAudiobookDatabase(Audiobook audiobook,
            ArrayList<String> authors) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "INSERT INTO AUDIOBOOK VALUES (?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, audiobook.id.toString());
            stmt1.setString(2, audiobook.title);
            stmt1.setString(3, audiobook.genre);
            stmt1.setInt(4, audiobook.chapters);
            stmt1.setInt(5, audiobook.year);
            stmt1.setInt(5, audiobook.length);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        PreparedStatement stmt2 = null;
        try {
            String sql = "INSERT INTO MEDIA VALUES (?, ?, ?)";
            stmt2 = conn.prepareStatement(sql);
            stmt2.setString(1, audiobook.id.toString());
            stmt2.setString(2, String.valueOf(audiobook.year));
            stmt2.setString(3, "Audiobook");
            stmt2.executeUpdate();
            stmt2.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < authors.size(); i++) {
            String authorName = audiobook.authors.get(i);
            PreparedStatement stmt3 = null;
            try {
                String sql = "INSERT INTO BOOK_AUTHOR VALUES (?, ?)";
                stmt3 = conn.prepareStatement(sql);
                stmt3.setString(1, audiobook.id.toString());
                stmt3.setString(2, authorName);
                stmt3.executeUpdate();
                stmt3.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            PreparedStatement stmt4 = null;
            try {
                String sql = "INSERT INTO AUTHOR VALUES (?)";
                stmt4 = conn.prepareStatement(sql);
                stmt4.setString(1, authorName);
                stmt4.executeUpdate();
                stmt4.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
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
        while (YN.equals("Y") || YN.equals("y")) {
            System.out.print("Enter the name of the author: ");
            String author = input.nextLine();

            authors.add(author);

            System.out.print("Would you like to enter an author (y/n): ");
            YN = input.nextLine();
        }

        Audiobook audiobook = new Audiobook(year, title, genre, chapters,
                length, authors);

        addAudiobookDatabase(audiobook, authors);
    }

    public static void editAudiobookDatabase(String column, String audiobook,
            String change) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "";
            if (column.equals("A")) {
                sql = "UPDATE AUDIOBOOK " + "SET year = ? " + "WHERE name = ?";
            } else if (column.equals("B")) {
                sql = "UPDATE AUDIOBOOK " + "SET length = ? "
                        + "WHERE name = ?";
            } else if (column.equals("C")) {
                sql = "UPDATE AUDIOBOOK " + "SET chapters = ? "
                        + "WHERE name = ?";
            } else {
                sql = "UPDATE AUDIOBOOK " + "SET genre = ? " + "WHERE name = ?";
            }
            stmt1 = conn.prepareStatement(sql);
            if (column.equals("A") || column.equals("B")
                    || column.equals("C")) {
                stmt1.setInt(1, Integer.parseInt(change));
            } else {
                stmt1.setString(1, change);
            }
            stmt1.setString(2, audiobook);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editAudiobook(Scanner input) {
        String audiobookName, columnName, toChange;

        System.out.print(
                "What's the name of the audiobook that you would like to update?: ");
        audiobookName = input.nextLine();
        System.out.print(
                "A: YEAR\nB: LENGTH\nC: CHAPTERS\nD: GENRE\nWhat column would you like to change?: ");
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

        editAudiobookDatabase(selection, audiobookName, toChange);
    }

    public static void deleteAudiobookDatabase(String name) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        try {
            String sql = "DELETE FROM AUDIOBOOK WHERE name = ?;";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, name);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAudiobook(Scanner input) {
        String audiobookName;

        System.out.print(
                "What's the name of the audiobook that you would like to delete?: ");
        audiobookName = input.nextLine();

        deleteAudiobookDatabase(audiobookName);
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
     * public static int checkEntity(String name, int type) { boolean exists =
     * false; int ret = -1; switch (type) { case 1: for (int i = 0; !exists && i
     * < musicList.size(); i++) { Music curr = musicList.get(i); if
     * (curr.songName.equals(name)) { exists = true; ret = i; } } break; case 2:
     * for (int i = 0; !exists && i < movieList.size(); i++) { Movie curr =
     * movieList.get(i); if (curr.title.equals(name)) { exists = true; ret = i;
     * } } break; case 3: for (int i = 0; !exists && i < audiobookList.size();
     * i++) { Audiobook curr = audiobookList.get(i); if
     * (curr.title.equals(name)) { exists = true; ret = i; } } break; default:
     * break; } return ret; }
     */

    public static void searchRecordDatabase(String type, String input) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        try {
            String sql = "";
            if (type.equals("MUSIC")) {
                sql = "SELECT * FROM MUSIC WHERE name = ?;";
            } else if (type.equals("MOVIE")) {
                sql = "SELECT * FROM MOVIE WHERE name = ?;";
            } else {
                sql = "SELECT * FROM AUDIOBOOK WHERE name = ?;";
            }
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, input);
            rs = stmt1.executeQuery();
            if (type.equals("MUSIC")) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int length = rs.getInt("length");
                    String album = rs.getString("album");
                    String genre = rs.getString("genre");
                    int year = rs.getInt("year");
                    System.out.println("\nNAME: " + name);
                    System.out.println("LENGTH: " + length);
                    System.out.println("ALBUM: " + album);
                    System.out.println("GENRE: " + genre);
                    System.out.println("YEAR: " + year + "\n");
                }
            } else if (type.equals("MOVIE")) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int year = rs.getInt("year");
                    String director = rs.getString("director");
                    String genre = rs.getString("genre");
                    System.out.println("\nNAME: " + name);
                    System.out.println("YEAR: " + year);
                    System.out.println("DIRECTOR: " + director);
                    System.out.println("GENRE: " + genre + "\n");
                }
            } else {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String genre = rs.getString("genre");
                    int chapters = rs.getInt("chapters");
                    int year = rs.getInt("year");
                    int length = rs.getInt("length");
                    System.out.println("\nNAME: " + name);
                    System.out.println("GENRE: " + genre);
                    System.out.println("CHAPTERS: " + chapters);
                    System.out.println("YEAR: " + year);
                    System.out.println("LENGTH: " + length);
                }
            }
            stmt1.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchRecord(Scanner input) {
        String search = "", select = "";
        System.out.println("A: Music");
        System.out.println("B: Movie");
        System.out.println("C: Audiobook");
        System.out.println("D: Back to Menu");
        System.out.print("Select a type of record to search: ");

        select = input.nextLine();

        switch (select) {
            case "A":
                System.out.print("Type the name of the song you wish to see: ");
                search = input.nextLine();
                searchRecordDatabase("MUSIC", search);
                break;
            case "B":
                System.out
                        .print("Type the name of the movie you wish to see: ");
                search = input.nextLine();
                searchRecordDatabase("MOVIE", search);
                break;
            case "C":
                System.out.print(
                        "Type the name of the audiobook you wish to see: ");
                search = input.nextLine();
                searchRecordDatabase("AUDIOBOOK", search);
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

    public static void searchPersonDatabase(String type, String input) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        try {
            String sql = "";
            if (type.equals("ARTIST")) {
                sql = "SELECT * " + "FROM SONGWRITER, MUSIC "
                        + "WHERE SONGWRITER.artistName = ? AND SONGWRITER.musicId = MUSIC.id;";
            } else if (type.equals("ACTOR")) {
                sql = "SELECT * " + "FROM FILM_RELATION, MOVIE "
                        + "WHERE FILM_RELATION.actorName = ? AND FILM_RELATION.movieId = MOVIE.id;";
            } else {
                sql = "SELECT * " + "FROM BOOK_AUTHOR, AUDIOBOOK "
                        + "WHERE BOOK_AUTHOR.authorName = ? AND BOOK_AUTHOR.bookId = AUDIOBOOK.id;";
            }
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, input);
            rs = stmt1.executeQuery();

            if (type.equals("ARTIST")) {
                while (rs.next()) {
                    String musicName = rs.getString("name");
                    String artistName = rs.getString("artistName");
                    System.out.println("\nSONG: " + musicName);
                    System.out.println("ARTIST: " + artistName + "\n");
                }
            } else if (type.equals("ACTOR")) {
                while (rs.next()) {
                    String movieName = rs.getString("name");
                    String actorName = rs.getString("actorName");
                    String role = rs.getString("role");
                    System.out.println("\nMOVIE: " + movieName);
                    System.out.println("ACTOR: " + actorName);
                    System.out.println("ROLE: " + role + "\n");
                }
            } else {
                while (rs.next()) {
                    String bookName = rs.getString("name");
                    String authorName = rs.getString("authorName");
                    System.out.println("\nAUDIOBOOK: " + bookName);
                    System.out.println("AUTHOR: " + authorName + "\n");
                }
            }
            stmt1.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchPerson(Scanner input) {
        String search = "", select = "";
        System.out.println("A: Artist");
        System.out.println("B: Actor");
        System.out.println("C: Author");
        System.out.println("D: Back to Menu");
        System.out.print("Select a type of person to search: ");

        select = input.nextLine();

        switch (select) {
            case "A":
                System.out
                        .print("Type the name of the Arist you wish to see: ");
                search = input.nextLine();
                searchPersonDatabase("ARTIST", search);
                break;
            case "B":
                System.out
                        .print("Type the name of the Actor you wish to see: ");
                search = input.nextLine();
                searchPersonDatabase("ACTOR", search);
                break;
            case "C":
                System.out
                        .print("Type the name of the Author you wish to see: ");
                search = input.nextLine();
                searchPersonDatabase("AUTHOR", search);
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

    public static void orderItems(Scanner input) {
        int subChoice = selectType(input);

        int orderNumber = getOrderNumber() + 1;
        String type = convertSubchoice(subChoice);
        int numDigCopies;
        int numPhysCopies;
        double price;
        LocalDate arrivalDate;
        String mediaId;
        String employeeId;

        printEntityList(subChoice);
        System.out.println("Enter the id of the item you want to order: ");
        mediaId = input.nextLine();

        System.out.print(
                "Enter the number of digital copies ordered (must be int): ");
        numDigCopies = Integer.parseInt(input.nextLine());
        System.out.print(
                "Enter the number of physical copies ordered (must be int): ");
        numPhysCopies = Integer.parseInt(input.nextLine());
        System.out.print("Enter price (must be double): ");
        price = Double.parseDouble(input.nextLine());
        System.out.print("Enter the arrival date (ex: 2021-06-30): ");
        String dateString = input.nextLine();
        arrivalDate = LocalDate.parse(dateString);

        printEmployees();
        System.out.print("Enter your employee id: ");
        employeeId = input.nextLine();

        Order order = new Order(type, orderNumber, numDigCopies, numPhysCopies,
                price, arrivalDate, mediaId, employeeId, 0);

        orderItemsDatabase(order);

    }

    public static void orderItemsDatabase(Order order) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;

        try {
            String sql = "INSERT INTO MEDIA_ORDER_INSTANCE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, order.mediaId.toString());
            stmt1.setString(2, order.type);
            stmt1.setInt(3, order.orderNumber);
            stmt1.setInt(4, order.numDigCopies);
            stmt1.setInt(5, order.numPhysCopies);
            stmt1.setDouble(6, order.price);
            stmt1.setString(7, order.arrivalDate.toString());
            stmt1.setString(8, order.employeeId.toString());
            stmt1.setInt(9, order.activated);
            stmt1.executeUpdate();
            stmt1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int selectType(Scanner input) {

        System.out.println("1. Music");
        System.out.println("2. Movie");
        System.out.println("3. Audiobook");
        System.out.print("Select a type of record: ");
        int subChoice = Integer.parseInt(input.nextLine());

        return subChoice;
    }

    public static String convertSubchoice(int subchoice) {
        String media = "";
        switch (subchoice) {
            case 1:
                media = "Music";
                break;
            case 2:
                media = "Movie";
                break;
            case 3:
                media = "Audiobook";
                break;
            default:
                break;
        }

        return media;
    }

    public static void processOrder(int orderNum) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        ResultSet results2 = null;

        String type = "";
        String mediaId = "";
        int numDigCopies = 0;
        int numPhysCopies = 0;

        try {
            String sql = "UPDATE MEDIA_ORDER_INSTANCE SET activated = ? WHERE orderNum = ?";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setInt(1, 1);
            stmt1.setInt(2, orderNum);
            stmt1.executeUpdate();
            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            String sql = "SELECT mediaId, type, numDigCopies, numPhysCopies FROM MEDIA_ORDER_INSTANCE WHERE orderNum = ?";
            stmt2 = conn.prepareStatement(sql);
            stmt2.setInt(1, orderNum);
            results2 = stmt2.executeQuery();
            while (results2.next()) {
                mediaId = results2.getString("mediaId");
                type = results2.getString("type");
                numDigCopies = results2.getInt("numDigCopies");
                numPhysCopies = results2.getInt("numPhysCopies");

            }
            if (results2 != null) {
                results2.close();
            }
            if (stmt2 != null) {
                stmt2.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<MediaInstance> instances = new ArrayList<>();
        for (int i = 0; i < numDigCopies; i++) {
            MediaInstance instance = new MediaInstance(type, "Digital", mediaId,
                    orderNum);
            instances.add(instance);
        }
        for (int i = 0; i < numPhysCopies; i++) {
            MediaInstance instance = new MediaInstance(type, "Physical",
                    mediaId, orderNum);
            instances.add(instance);
        }

        for (MediaInstance instance : instances) {
            addInvInstance(instance);
        }
    }

    public static void addInvInstance(MediaInstance instance) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;

        try {
            String sql = "INSERT INTO MEDIA_INVENTORY_INSTANCE VALUES (?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, instance.id.toString());
            stmt1.setString(2, instance.type);
            stmt1.setString(3, instance.mediaId);
            stmt1.setInt(4, instance.orderNum);
            stmt1.setString(5, instance.format);
            stmt1.executeUpdate();

            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void updateInventory(Scanner input) {
        printUnactivatedOrders();
        System.out.print(
                "Enter the order number of the order you want to activate (Column 3): ");
        int orderNum = Integer.parseInt(input.nextLine());
        processOrder(orderNum);

    }

    public static void addCustomer(Scanner input) {
        String email;
        String name;
        String address;
        LocalDate birthDate;
        String employeeId;

        System.out.print("Enter the customer email: ");
        email = input.nextLine();
        System.out.print("Enter the customer name: ");
        name = input.nextLine();
        System.out.print("Enter the customer address: ");
        address = input.nextLine();
        System.out.print("Enter the customer birth date (ex: 2001-06-30): ");
        String dateString = input.nextLine();
        birthDate = LocalDate.parse(dateString);
        printEmployees();
        System.out.print("Enter your employee id: ");
        employeeId = input.nextLine();

        Customer customer = new Customer(email, name, address, birthDate,
                employeeId);

        addCustomerDatabase(customer);

    }

    public static void addCustomerDatabase(Customer customer) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;

        try {
            String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, customer.email);
            stmt1.setString(2, customer.name);
            stmt1.setString(3, customer.address);
            stmt1.setString(4, customer.birthDate.toString());
            stmt1.setString(5, customer.employeeId);
            stmt1.executeUpdate();

            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addEmployee(Scanner input) {
        String name;

        System.out.print("Enter the employee name: ");
        name = input.nextLine();

        Employee employee = new Employee(name);

        addEmployeeDatabase(employee);

    }

    public static void addEmployeeDatabase(Employee employee) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;

        try {
            String sql = "INSERT INTO Employees VALUES (?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, employee.id.toString());
            stmt1.setString(2, employee.name);

            stmt1.executeUpdate();

            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addReview(Scanner input) {

        int subChoice = selectType(input);
        printEntityList(subChoice);
        System.out.print("Enter the media id: ");
        String id = input.nextLine();
        System.out.print("Enter the rating: ");
        int rating = Integer.parseInt(input.nextLine());

        Review review = new Review(id, rating);

        addReviewDatabase(review);

    }

    public static void addReviewDatabase(Review review) {
        Connection conn = Database.c;
        PreparedStatement stmt1 = null;

        try {
            String sql = "INSERT INTO REVIEW VALUES (?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, review.reviewId.toString());
            stmt1.setInt(2, review.rating);
            stmt1.setString(3, review.mediaId);

            stmt1.executeUpdate();

            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void checkOut(Scanner input) {
        int subChoice = selectType(input);
        printMediaInstanceList(subChoice);
        System.out.print(
                "Enter the instance id you want to check out (Column 1): ");
        String id = input.nextLine();
        printCustomers();
        System.out.print("Enter your email: ");
        String email = input.nextLine();
        LocalDate checkoutDate = LocalDate.now();
        LocalDate dueDate = checkoutDate.plusWeeks(3);

        Connection conn = Database.c;
        PreparedStatement stmt1 = null;

        try {
            String sql = "INSERT INTO CUSTOMER_MEDIA_DUEDATE VALUES (?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, email);
            stmt1.setString(2, id);
            stmt1.setString(3, checkoutDate.toString());
            stmt1.setString(4, dueDate.toString());

            stmt1.executeUpdate();

            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void returnMedia(Scanner input) {
        printCheckedOutMedia();
        System.out.println("Enter the id of the media you want to return: ");
        String id = input.nextLine();

        Connection conn = Database.c;
        PreparedStatement stmt1 = null;

        try {
            String sql = "DELETE FROM CUSTOMER_MEDIA_DUEDATE WHERE instanceId = ?";
            stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, id);

            stmt1.executeUpdate();

            if (stmt1 != null) {
                stmt1.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
