import java.sql.*;

class HospitalController {

    Connection con;

    HospitalController() {

        con = DBConnection.getConnection();
    }

    void addPatient(int id, String name) {

        try {

            String query =
                    "INSERT INTO patients VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setBoolean(3, false);

            ps.executeUpdate();

            System.out.println("Patient Added");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void displayPatients() {

        try {

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM patients");

            System.out.println("\nPatients List:");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        (rs.getBoolean("admitted")
                                ? "Admitted"
                                : "Discharged"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    boolean searchPatient(String name) {

        try {

            String query =
                    "SELECT * FROM patients WHERE name=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;
    }

    void admitPatient(String name) {

        try {

            String query =
                    "UPDATE patients SET admitted=true WHERE name=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Patient Admitted");
            else
                System.out.println("Patient Not Found");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void dischargePatient(String name) {

        try {

            String query =
                    "UPDATE patients SET admitted=false WHERE name=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Patient Discharged");
            else
                System.out.println("Patient Not Found");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}