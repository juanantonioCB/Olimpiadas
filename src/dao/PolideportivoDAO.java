/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Polideportivo;

/**
 *
 * @author Juan Antonio
 */
public class PolideportivoDAO extends Conexion {

    String insert = "INSERT INTO polideportivo VALUES(?,?)";
    String update = "UPDATE polideportivo SET cod=?, info=? WHERE cod=?";
    String delete = "DELETE FROM polideportivo where cod=?";
    String getAll = "SELECT * FROM polideportivo";
    String getOne = "SELECT * FROM polideportivo WHERE cod=?";
    
    public boolean insert(Polideportivo p){
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setInt(1, p.getCod_complejo());
            stat.setString(2, p.getInfo());
            if(stat.execute()){
                d=true;
                stat.close();
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PolideportivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public boolean update(Polideportivo p){
        boolean d= false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(insert);
            stat.setInt(1, p.getCod_complejo());
            stat.setString(2, p.getInfo());
            if(stat.execute()){
                stat.close();
                d=true;
            }
            disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PolideportivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d; 
    }
}
