import java.io.*;
import java.util.*;

class Librarian {
    private List<String> members = new ArrayList<>();
    private List<String> books = new ArrayList<>();
    private int bookIdCounter = 1;
    private int generateUniqueBookId() {
        return bookIdCounter++;
    }

    void abc() {
        System.out.println("1. Register a member\n" +
                "2. Remove a member\n" +
                "3. Add a book\n" +
                "4. Remove a book\n" +
                "5. View all members along with their books and fines to be paid\n" +
                "6. View all books\n" +
                "7. Back");
    }
    private int RandomMemberId() {
        int randomId;
//        do {
            randomId = new Random().nextInt(1000000) + 1;
//        } while (isMemberIdUsed(randomId)); // Check if the ID is already in use
        return randomId;
    }

    void register() throws IOException {
        FileWriter writer = new FileWriter("data.txt", true);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("enter age");
        String age = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String ph_no = scanner.nextLine();
        int newMemberId = RandomMemberId();
        String data = name + "!" + age + "<" + ph_no + ">" + " Member ID: " + newMemberId;
        members.add(data);
        System.out.println("Data appended successfully for the new member with ID: " + newMemberId);
    }
    void removeMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Member ID to remove: ");
        int memberIdToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        members.removeIf(line -> line.contains("Member ID: " + memberIdToRemove));
        System.out.println("Member with Member ID: " + memberIdToRemove + " has been removed.");
    }

    void book_add() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter author name");
        String author = scanner.nextLine();
        System.out.println("no of copies");
        int number = scanner.nextInt();
        int bookId = generateUniqueBookId();
        String dat = bookId + "!" + title + "<" + author + ">" + number;
        books.add(dat);
        System.out.println("Book Added Successfully! with id: "+ bookId);
    }
    void remove_book() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book ID to remove: ");
        int bookIdToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        books.removeIf(line -> {
            String[] bookInfo = line.split("[!<>]");
            int id = Integer.parseInt(bookInfo[0]);
            return id == bookIdToRemove;
        });

        System.out.println("Book with ID: " + bookIdToRemove + " has been removed.");
    }


    void view_book() {
        for (String line : books) {
            String[] bookInfo = line.split("[!<>]");
            String title = bookInfo[1];
            String author = bookInfo[2];
            int copies = Integer.parseInt(bookInfo[3]);
            int bkid = Integer.parseInt(bookInfo[0]);
            System.out.println("Book ID: "+ bkid + "\nTitle: " + title + "\nAuthor: " + author + "\nCopies: " + copies + "\n");
        }
    }






    void view_book_fine() throws IOException {

    }

    }


class Member {
    void abc() {
        System.out.println("List Available Books\n" +
                "1. List My Books\n" +
                "2. Issue book\n" +
                "3. Return book\n" +
                "4. Pay Fine\n" +
                "5. Back");
    }
    void list_book(){

    }

    void issue_book() throws IOException{

    }
    void return_book() throws IOException{

    }
    void pay_fine() throws IOException{

    }


}

public class Main {
    public static void main(String[] args) {
        System.out.println("Library Portal Initialized….");
        System.out.println("---------------------------------\n");
        System.out.println("1. Enter as a librarian");
        System.out.println("2. Enter as a member");
        System.out.println("3. Exit");
        Librarian lib = new Librarian();
        Member mem = new Member();
        Scanner input1 = new Scanner(System.in);
        int p = input1.nextInt();
        int c=1;
        int b=1;
        while (c==1) {

            switch (p) {
                case 1:
                    while(b==1) {
                        lib.abc();
                        Scanner inp = new Scanner(System.in);
                        switch (inp.nextInt()) {
                            case 1:
                                try {
                                    lib.register();
                                } catch (IOException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                }
                                break;
                            case 2:
                                lib.removeMember();

                                break;
                            case 3:
                                try {
                                    lib.book_add();
                                } catch (IOException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                }
                                break;
                            case 4:
                                try {
                                    lib.remove_book();
                                } catch (IOException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                }
                                break;
                            case 5:
                                try {
                                    lib.view_book_fine();
                                } catch (IOException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                }
                                break;
                            case 6:

                                    lib.view_book();

                                break;
                            case 7:
                                b=2;
                                break;
                            default:
                                System.out.println("invalid input. try again");
                        }
                    }
                    break;
                case 2:

                    mem.abc();
                    Scanner inp2 = new Scanner(System.in);
                    while(b==1) {
                        switch (inp2.nextInt()) {
                            case 1:
                                mem.list_book();
                                break;
                            case 2:
                                try {
                                    mem.issue_book();
                                } catch (IOException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                }
                                break;
                            case 3:
                                try {
                                    mem.return_book();
                                } catch (IOException e) {
                                    System.out.println("An error occurred: " + e.getMessage());

                                }
                                break;
                            case 4:
                                try {
                                    mem.pay_fine();
                                } catch (IOException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                }
                                break;
                            case 5:
                                b=2;
                                break;
                            default:
                                System.out.println("invalid input. try again");
                        }
                    }
                    break;
                case 3:
                    c=2;
                    break;
            }
            if (b==2) {
                Scanner input = new Scanner(System.in);
                System.out.println("1. Enter as a librarian");
                System.out.println("2. Enter as a member");
                System.out.println("3. Exit");
                p = input.nextInt();
            }
            b = 1;
        }
            System.out.println("---------------------------------\n" +
                    "Thanks for visiting!\n" +
                    "---------------------------------\n");
        }
    }
