package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipamiento;

/**
 *
 * @author Juan Antonio
 */
public class EquipamientoDAO extends Conexion {

    String insert = "INSERT INTO equipment(name) VALUES (?)";
    String update = "UPDATE equipment SET name=? WHERE id=?";
    String delete = "DELETE FROM equipment WHERE id=?";
    String getAll = "SELECT * FROM equipment";
    String getOne = "SELECT * FROM equipment WHERE id=?";

    public boolean insert(Equipamiento e) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setString(1, e.getNombre());
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(EquipamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean update(Equipamiento e) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setString(1, e.getNombre());
            stat.setInt(2, e.getId());
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(EquipamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean delete(int id) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(delete);
            stat.setInt(1, id);
            if (stat.execute()) {
                stat.close();
                d = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public List<Equipamiento> getAll() {
        ArrayList<Equipamiento> equipamiento = null;
        try {
            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while (rs.next()) {
                if (rs.isFirst()) {
                    equipamiento = new ArrayList<>();
                }
                Equipamiento e = new Equipamiento(rs.getInt("id"), rs.getString("name"));
                equipamiento.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipamiento;
    }
}
