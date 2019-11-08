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
import modelo.Material;

public class MaterialDAO extends Conexion {

    String insert = "INSERT INTO equipment(name) VALUES (?)";
    String update = "UPDATE equipment SET name=? WHERE id=?";
    String delete = "DELETE FROM equipment WHERE id=?";
    String getAll = "SELECT * FROM equipment";
    String getOne = "SELECT * FROM equipment WHERE id=?";

    public boolean insert(Material m) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setString(1, m.getNombre());
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean update(Material m) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setString(1, m.getNombre());
            stat.setInt(2, m.getCod());
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public List<Material> getAll() {
        ArrayList<Material> materiales = null;
        try {

            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while (rs.next()) {
                if (rs.isFirst()) {
                    materiales = new ArrayList<>();
                }
                Material m = new Material(rs.getInt("cod"), rs.getString("nombre"));
                materiales.add(m);
            }
            rs.close();
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materiales;
    }
}
