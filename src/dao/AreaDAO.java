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
import modelo.Area;

public class AreaDAO extends Conexion {

    String insert = "INSERT INTO area (id_multisportcenter,location,sport) VALUES (?,?,?)";
    String update = "UPDATE area SET id_multisportcenter=?, location=?, sport=? WHERE id=?";
    String delete = "DELETE FROM area WHERE id=?";
    String getAll = "SELECT * FROM area";
    String getOne = "SELECT * FROM area WHERE id=?";

    public boolean insert(Area a) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setInt(1, a.getCod_polideportivo());
            stat.setString(2, a.getLocalizacion());
            stat.setString(3, a.getDeporte());
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean update(Area a) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setInt(1, a.getCod_polideportivo());
            stat.setString(2, a.getLocalizacion());
            stat.setString(3, a.getDeporte());
            stat.setInt(4, a.getCod_polideportivo());
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            return d;
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public List<Area> getAll() {
        ArrayList<Area> areas = null;
        try {

            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while (rs.next()) {
                if (rs.isFirst()) {
                    areas = new ArrayList<>();
                }
                areas.add(new Area(rs.getInt("id"), rs.getInt("id_multisportcenter"), rs.getString("location"), rs.getString("sport")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return areas;
    }
}
