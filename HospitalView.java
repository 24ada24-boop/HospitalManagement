import java.util.Scanner;

class HospitalView {

    Scanner sc = new Scanner(System.in);

    void menu() {

        System.out.println("\n--- Hospital Menu ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Display Patients");
        System.out.println("3. Search Patient");
        System.out.println("4. Admit Patient");
        System.out.println("5. Discharge Patient");
        System.out.println("6. Exit");
    }

    int getChoice() {

        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    int getId() {

        System.out.print("Enter ID: ");
        return sc.nextInt();
    }

    String getName() {

        sc.nextLine();

        System.out.print("Enter Name: ");
        return sc.nextLine();
    }
}