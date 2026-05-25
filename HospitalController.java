class HospitalController {

    Patient[] patients;
    int count;

    HospitalController(int size) {
        patients = new Patient[size];
        count = 0;
    }

    void addPatient(int id, String name) {
        patients[count++] = new Patient(id, name);
    }

    Patient[] getPatients() {
        return patients;
    }

    int getCount() {
        return count;
    }

    Patient findPatient(String name) {

        for (int i = 0; i < count; i++) {

            if (patients[i].name.equalsIgnoreCase(name)) {
                return patients[i];
            }
        }

        return null;
    }

    String admitPatient(String name) {

        Patient p = findPatient(name);

        if (p == null)
            return "Patient Not Found";

        if (!p.admitted) {
            p.admitted = true;
            return "Patient Admitted Successfully";
        }

        return "Patient Already Admitted";
    }

    String dischargePatient(String name) {

        Patient p = findPatient(name);

        if (p == null)
            return "Patient Not Found";

        if (p.admitted) {
            p.admitted = false;
            return "Patient Discharged Successfully";
        }

        return "Patient Already Discharged";
    }
}