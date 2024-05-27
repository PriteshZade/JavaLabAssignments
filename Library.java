import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.start();
    }
}

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void updateBook(int id, String title, String author) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(title);
                book.setAuthor(author);
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void deleteBook(int id) {
        boolean found = false;
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: "
                        + book.getAuthor() + ", Borrowed: " + book.isBorrowed());
            }
        }
    }

    public void checkOutBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("Checked out successfully!");
                } else {
                    System.out.println("Book is already borrowed!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void checkInBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("Checked in successfully!");
                } else {
                    System.out.println("Book is already available in the library!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    private Book inputBookDetails(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        return new Book(id, title, author);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. List All Books");
            System.out.println("5. Check Out Book");
            System.out.println("6. Check In Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBook(inputBookDetails(scanner));
                    break;
                case 2:
                    System.out.print("Enter Book ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String author = scanner.nextLine();
                    updateBook(id, title, author);
                    break;
                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    id = scanner.nextInt();
                    deleteBook(id);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.print("Enter Book ID to check out: ");
                    id = scanner.nextInt();
                    checkOutBook(id);
                    break;
                case 6:
                    System.out.print("Enter Book ID to check in: ");
                    id = scanner.nextInt();
                    checkInBook(id);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please enter a number between 1 and 7.");
                    break;
            }
        }
    }
}
