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
import modelo.Complejo;

public class ComplejoDAO extends Conexion {

    String insert = "INSERT INTO sportcomplex (location, boss, id_headquarter) VALUES (?,?,?)";
    String update = "UPDATE sportcomplex SET location=?, boss=?, id_headquarter=? WHERE id=?";
    String delete = "DELETE FROM sportcomplex WHERE id=?";
    String getAll = "SELECT * FROM sportcomplex";
    String getOne = "SELECT * FROM sportcomplex WHERE id=?";

    public boolean insertComplejo(Complejo c) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setString(1, c.getLocalizacion());
            stat.setString(2, c.getJefe());
            stat.setInt(3, c.getCod_sede());
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ComplejoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean updateComplejo(int id, Complejo c) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setString(1, c.getLocalizacion());
            stat.setString(2, c.getJefe());
            stat.setInt(3, c.getCod_sede());
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ComplejoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean deleteComplejo(int id) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(delete);
            stat.setInt(1, id);
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ComplejoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public List<Complejo> getAllComplejos() {
        ArrayList<Complejo> complejos = null;
        try {
            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while (rs.next()) {
                if (rs.isFirst()) {
                    complejos = new ArrayList<Complejo>();
                }
                Complejo c = new Complejo(rs.getInt("id"), rs.getString("location"), rs.getString("boss"), rs.getInt("id_headquarter"));
                complejos.add(c);
            }
            rs.close();
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ComplejoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return complejos;
    }

    public Complejo getComplejo(int cod) {
        Complejo c = null;
        return c;
    }
}
