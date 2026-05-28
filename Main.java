public class Main {

    public static void main(String[] args) {

        HospitalController controller =
                new HospitalController();

        HospitalView view =
                new HospitalView();

        while (true) {

            view.menu();

            int choice = view.getChoice();

            switch (choice) {

                case 1:

                    int id = view.getId();
                    String name = view.getName();

                    controller.addPatient(id, name);

                    break;

                case 2:

                    controller.displayPatients();

                    break;

                case 3:

                    String search = view.getName();

                    if (controller.searchPatient(search))
                        System.out.println("Patient Found");
                    else
                        System.out.println("Patient Not Found");

                    break;

                case 4:

                    String admit = view.getName();

                    controller.admitPatient(admit);

                    break;

                case 5:

                    String discharge = view.getName();

                    controller.dischargePatient(discharge);

                    break;

                case 6:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}