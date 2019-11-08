/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Sede;

/**
 *
 * @author Juan Antonio
 */
public class SedeDAO extends Conexion {

    String insert = "INSERT INTO headquarter (name,budget) VALUES (?,?)";
    String update = "UPDATE headquarter SET name=?, budget=? WHERE id=?";
    String delete = "DELETE FROM headquarter WHERE id=?";
    String getAll = "SELECT * FROM headquarter";
    String getOne = "SELECT * FROM headquarter WHERE id=?";

    public boolean insert(Sede s) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setString(1, s.getNombre());
            stat.setDouble(2, s.getPresupuesto());
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean update(Sede s) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setString(1, s.getNombre());
            stat.setDouble(2, s.getPresupuesto());
            stat.setInt(3, s.getCod());
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public List<Sede> getAll() {
        ArrayList<Sede> sedes = null;
        try {
            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while(rs.next()){
                if(rs.isFirst()){
                    sedes=new ArrayList<>();
                }
                Sede s = new Sede(rs.getInt("id"),rs.getString("name"),rs.getDouble("budget"));
                sedes.add(s);
            }
            rs.close();
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sedes;
    }
}
