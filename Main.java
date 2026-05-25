public class Main {

    public static void main(String[] args) {

        HospitalController controller = new HospitalController(10);
        HospitalView view = new HospitalView();

        controller.addPatient(1, "Arun");
        controller.addPatient(2, "Kavi");
        controller.addPatient(3, "Rahul");

        while (true) {

            view.showMenu();

            int choice = view.getChoice();

            switch (choice) {

                case 1:

                    view.displayPatients(
                            controller.getPatients(),
                            controller.getCount());

                    break;

                case 2:

                    String search = view.getName("Enter patient name: ");

                    if (controller.findPatient(search) != null)
                        view.showMessage("Patient Found");
                    else
                        view.showMessage("Patient Not Found");

                    break;

                case 3:

                    String admit = view.getName("Enter patient name: ");

                    view.showMessage(
                            controller.admitPatient(admit));

                    break;

                case 4:

                    String discharge = view.getName("Enter patient name: ");

                    view.showMessage(
                            controller.dischargePatient(discharge));

                    break;

                case 5:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}