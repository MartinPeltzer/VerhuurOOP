package database;

import model.Klant;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KlantDAO extends AbstractDAO {
    public KlantDAO (DBaccess db) {
        super(db);
    }

    public void storeKlant (Klant klant) {
        String sql = "INSERT INTO klant (klantnaam, emailadres) VALUES (?,?)";
        try {
            PreparedStatement ps = getStatement(sql);
            ps.setString(1, klant.getNaam());
            ps.setString(2, klant.getEmailadres());
            executeManipulatePreparedStatement(ps);
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
    }



}
