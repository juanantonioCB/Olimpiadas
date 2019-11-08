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
import modelo.Unideportivo;

public class UnideportivoDAO extends Conexion {

    String insert = "INSERT INTO sportcenter VALUES (?,?,?)";
    String update = "UPDATE sportcenter SET id_sportcomplex=?, sport=?, information=?";
    String delete = "DELETE FROM sportcenter WHERE id_sportcomplex=?";
    String getAll = "SELECT * FROM sportcenter";
    String getOne = "SELECT * FROM sportcenter WHERE id_sportcomplex=?";

    public boolean insert(Unideportivo u) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setInt(1, u.getCod_complejo());
            stat.setString(2, u.getDeporte());
            stat.setString(3, u.getInfo());
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UnideportivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean update(int cod, Unideportivo u) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setInt(1, u.getCod_complejo());
            stat.setString(2, u.getDeporte());
            stat.setInt(3, cod);
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UnideportivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean delete(int cod) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(delete);
            stat.setInt(1, cod);
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UnideportivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public List<Unideportivo> getAll() {
        ArrayList<Unideportivo> unideportivos = null;
        try {
            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while (rs.next()) {
                if (rs.isFirst()) {
                    unideportivos = new ArrayList<>();
                }
                Unideportivo u = new Unideportivo(rs.getInt("cod"), rs.getString("deporte"), rs.getString("info"));
                unideportivos.add(u);
            }
            rs.close();
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UnideportivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unideportivos;
    }

}
