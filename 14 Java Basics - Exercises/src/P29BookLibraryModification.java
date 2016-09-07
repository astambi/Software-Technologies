import java.text.*;
import java.util.*;
import java.util.stream.Collectors;

public class P29BookLibraryModification {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Book> books = getBooks(scan);
        Date releaseDate = getReleaseDate(scan);
        Map<Date, ArrayList<String>> titlesByDate = getTitlesByDate(books, releaseDate);
        printTitlesByReleaseDate(titlesByDate);
    }

    private static void printTitlesByReleaseDate(Map<Date, ArrayList<String>> titlesByDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        for (Date date : titlesByDate.keySet()) {
            ArrayList<String> titlesOrdered = titlesByDate.get(date)
                    .stream()
                    .sorted( (t1, t2) -> t1.compareTo(t2))
                    .collect(Collectors.toCollection(ArrayList<String>::new));
            for (String title : titlesOrdered)
                System.out.printf("%s -> %s\n", title, formatter.format(date));
        }
    }

    private static Map<Date,ArrayList<String>> getTitlesByDate(ArrayList<Book> books, Date releaseDate) {
        Map<Date, ArrayList<String>> titlesByDate = new TreeMap<>(); // by date ASC
        for (Book book : books) {
            Date bookDate = book.releaseDate;
            if (bookDate.after(releaseDate)) {
                ArrayList<String> listTitles = new ArrayList<>();
                if (!titlesByDate.containsKey(bookDate)) {
                    listTitles.add(book.title);
                }
                else {
                    listTitles.addAll(titlesByDate.get(bookDate));
                    listTitles.add(book.title);
                }
                titlesByDate.put(bookDate, listTitles);
            }
        }
        return titlesByDate;
    }

    private static Date getReleaseDate(Scanner scan) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = formatter.parse(scan.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static ArrayList<Book> getBooks(Scanner scan) {
        int count = Integer.parseInt(scan.nextLine());
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] bookData = scan.nextLine().split("\\s");
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = null;
            try {
                date = formatter.parse(bookData[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            books.add(new Book(bookData[0], bookData[1], bookData[2], date,
                    bookData[4], Double.parseDouble(bookData[5])));
        }
        return books;
    }

    static class Book {
        private String title;
        private String author;
        private String publisher;
        private Date releaseDate;
        private String isbn;
        private Double price;

        private Book(String title, String author, String publisher, Date releaseDate, String isbn, Double price) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.releaseDate = releaseDate;
            this.isbn = isbn;
            this.price = price;
        }
    }
}