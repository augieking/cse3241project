import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    public static ArrayList<Entity> entityList = new ArrayList<>();
    public static ArrayList<Music> musicList = new ArrayList<>();
    public static ArrayList<Movie> movieList = new ArrayList<>();
    public static ArrayList<Audiobook> audiobookList = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();

    public static void printEntityList(ArrayList listName) {

        for (int i = 0; i < listName.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(listName.get(i));
        }

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

    public static void addMusic(Scanner input) {
        int year;
        int length;
        String albumName;
        String songName;
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

        Music music = new Music(year, length, albumName, songName, artists);
        musicList.add(music);
        entityList.add(music);

        //TEST
        System.out.println("id: " + music.id);
        System.out.println("year: " + music.year);
        System.out.println("length: " + music.length);
        System.out.println("albumName: " + music.albumName);
        System.out.println("songName: " + music.songName);
        for (int i = 0; i < artists.size(); i++) {
            System.out.println("arist: " + music.artists.get(i));
        }
        //TEST

    }

    public static void editMusic(Scanner input) {
        int year;
        int length;
        String albumName;
        String songName;
        ArrayList<String> artists = new ArrayList<>();

        printEntityList(musicList);

        System.out.print(
                "Enter the number corresponding to the music you want to update (must be int): ");
        int index = Integer.parseInt(input.nextLine()) - 1;
        Music music = musicList.get(index);

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

        music.update(year, length, albumName, songName, artists);

        //TEST
        System.out.println("id: " + music.id);
        System.out.println("year: " + music.year);
        System.out.println("length: " + music.length);
        System.out.println("albumName: " + music.albumName);
        System.out.println("songName: " + music.songName);
        for (int i = 0; i < artists.size(); i++) {
            System.out.println("arist: " + music.artists.get(i));
        }
        //TEST

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
        movieList.add(movie);
        entityList.add(movie);
    }

    public static void editMovie(Scanner input) {

        int year;
        String director;
        String genre;
        String title;
        int length;
        ArrayList<Actor> actors = new ArrayList<>();

        printEntityList(movieList);

        System.out.print(
                "Enter the number corresponding to the movie you want to update (must be int): ");
        int index = Integer.parseInt(input.nextLine()) - 1;
        Movie movie = movieList.get(index);

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

        movie.update(year, director, genre, title, length, actors);
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
        System.out.print(
                "Enter the year the audiobook was released (must be int): ");
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

            System.out.print("Would you like to enter an actor (y/n): ");
            YN = input.nextLine();
        }

        Audiobook audiobook = new Audiobook(year, title, genre, chapters,
                length, authors);
        audiobookList.add(audiobook);
        entityList.add(audiobook);
    }

    public static void editAudiobook(Scanner input) {

        int year;
        String title;
        String genre;
        int chapters;
        int length;
        ArrayList<String> authors = new ArrayList<>();

        printEntityList(audiobookList);

        System.out.print(
                "Enter the number corresponding to the movie you want to update (must be int): ");
        int index = Integer.parseInt(input.nextLine()) - 1;
        Audiobook audiobook = audiobookList.get(index);

        System.out.print(
                "Enter the year the audiobook was released (must be int): ");
        year = Integer.parseInt(input.nextLine());
        System.out.print("Enter the title of the audiobook: ");
        title = input.nextLine();
        System.out.print("Enter the genre of the audiobook: ");
        genre = input.nextLine();
        System.out.print(
                "Enter the year the audiobook was released (must be int): ");
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

            System.out.print("Would you like to enter an actor (y/n): ");
            YN = input.nextLine();
        }

        audiobook.update(year, title, genre, chapters, length, authors);
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
                check = checkEntity(search, 1);
                if (check != -1) {
                    Music music = musicList.get(check);
                    System.out.println(music.toString());
                } else {
                    System.out.println("\"" + search
                            + "\" does not exist in the records.");
                }
                break;
            case "B":
                System.out
                        .print("Type the name of the movie you wish to see: ");
                search = input.nextLine();
                check = checkEntity(search, 2);
                if (check != -1) {
                    Movie movie = movieList.get(check);
                    System.out.println(movie.toString());
                }
                break;
            case "C":
                System.out.print(
                        "Type the name of the audiobook you wish to see: ");
                search = input.nextLine();
                check = checkEntity(search, 3);
                if (check != -1) {
                    Audiobook audiobook = audiobookList.get(check);
                    System.out.println(audiobook.toString());
                }
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
        System.out.print("Enter the number of physical copies ordered (must be int): ");
        numPhysCopies = Integer.parseInt(input.nextLine());
        System.out.print("Enter price (must be double): ");
        price = Double.parseDouble(input.nextLine());
        System.out.print(
                "Enter the arrival date (January 2, 2010): ");
        String dateString = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        arrivalDate = LocalDate.parse(dateString, formatter);
        
        Order order = new Order(numDigCopies, numPhysCopies, price,
            arrivalDate, media);
        
        orders.add(order); 
        
        System.out.println(order);
        
        

    }

    public static int selectType(Scanner input) {

        System.out.println("1. Music");
        System.out.println("2. Movie");
        System.out.println("3. Audiobook");
        System.out.print("Select a type of record to order: ");
        int subChoice = Integer.parseInt(input.nextLine());

        return subChoice;
    }
}
