import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Librarian {

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
        do {
            randomId = new Random().nextInt(1000) + 1;
        } while (isMemberIdUsed(randomId)); // Check if the ID is already in use
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

        String data = name + "<" + ph_no + ">\n"; // Added line break
        writer.write(data);
        writer.close();
        System.out.println("Data appended successfully to the file.");
    }
    void removeMember() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Member ID to remove: ");
        int memberIdToRemove = scanner.nextInt();

        // Code to remove the member with the provided ID from the 'members' list
        // (You need to implement this part)
        // For example:
        // members.removeIf(member -> member.memberId == memberIdToRemove);
        // Update the list according to your actual implementation

        System.out.println("Member with Member ID: " + memberIdToRemove + " has been removed.");
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
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Library Portal Initialized….");
        System.out.println("---------------------------------\n");
        System.out.println("1. Enter as a librarian");
        System.out.println("2. Enter as a member");
        System.out.println("3. Exit");

        Scanner input1 = new Scanner(System.in);
        int p = input1.nextInt();

        switch (p) {
            case 1:
                Librarian lib = new Librarian();
                lib.abc();
                Scanner inp = new Scanner(System.in); // Corrected 'syste' to 'System'
                switch (inp.nextInt()) {
                    case 1:
                        try {
                            lib.register(); // Corrected 'Lib' to 'lib'
                        } catch (IOException e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            lib.removeMember();
                        } catch (IOException e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                        break;
                }
                break;
            case 2:
                Member mem = new Member();
                mem.abc();
                break;
            case 3:
                break;
        }
    }
}
