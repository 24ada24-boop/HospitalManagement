import java.util.Scanner;

class HospitalView {

    Scanner sc = new Scanner(System.in);

    void showMenu() {

        System.out.println("\n--- Hospital Menu ---");
        System.out.println("1. Display Patients");
        System.out.println("2. Search Patient");
        System.out.println("3. Admit Patient");
        System.out.println("4. Discharge Patient");
        System.out.println("5. Exit");
    }

    int getChoice() {

        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    String getName(String msg) {

        sc.nextLine();
        System.out.print(msg);
        return sc.nextLine();
    }

    void displayPatients(Patient[] patients, int count) {

        System.out.println("\nPatients List:");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    patients[i].id + " - " +
                    patients[i].name + " - " +
                    (patients[i].admitted ? "Admitted" : "Discharged"));
        }
    }

    void showMessage(String msg) {
        System.out.println(msg);
    }
}