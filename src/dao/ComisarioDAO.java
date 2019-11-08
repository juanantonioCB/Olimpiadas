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
import modelo.Comisario;

/**
 *
 * @author Juan Antonio
 */
public class ComisarioDAO extends Conexion {

    String insert = "INSERT INTO commissioner(dni,name) VALUES (?,?)";
    String update = "UPDATE commissioner SET dni=?, nombre=? WHERE id = ?";
    String delete = "DELETE FROM commissioner WHERE id=?";
    String getAll = "SELECT dni, name FROM commissioner";
    String getOne = "SELECT dni, name FROM commissioner WHERE id=?";

    public boolean insert(Comisario c) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setString(1, c.getDni());
            stat.setString(2, c.getNombre());
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ComisarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean update(Comisario c, int id) {
        boolean d = false;
        try {

            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setString(1, c.getDni());
            stat.setString(2, c.getNombre());
            stat.setInt(3, id);
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ComisarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public boolean delete(int id){
        boolean d=false;
        try {
            
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(delete);
            stat.setInt(1, id);
            if(stat.execute()){
                d=true;
                stat.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComisarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public List<Comisario> getAllComisarios() {
        ArrayList<Comisario> comisarios = null;
        try {
            Connection con = getConnect();
            Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(getAll);
            while (rs.next()) {
                if (rs.isFirst()) {
                    comisarios = new ArrayList<Comisario>();
                }
                Comisario c = new Comisario(rs.getInt("cod"),rs.getString("dni"),rs.getString("nombre"));
                comisarios.add(c);
            }
            rs.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comisarios;
    }
}
