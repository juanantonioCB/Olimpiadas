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
import modelo.Polideportivo;

/**
 *
 * @author Juan Antonio
 */
public class PolideportivoDAO extends Conexion {

    String insert = "INSERT INTO multisportcenter VALUES(?,?)";
    String update = "UPDATE multisportcenter SET id_sportcomplex=?, information=? WHERE id_sportcomplex=?";
    String delete = "DELETE FROM multisportcenter WHERE id_sportcomplex=?";
    String getAll = "SELECT * FROM multisportcenter";
    String getOne = "SELECT * FROM multisportcenter WHERE id_sportcomplex=?";
    
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
            PreparedStatement stat = con.prepareStatement(update);
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
    
    public boolean delete(int cod){
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(delete);
            stat.setInt(1, cod);
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
    
    public List<Polideportivo> getAll(){
        ArrayList<Polideportivo> polideportivos = null;
        try {
            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while(rs.next()){
                if(rs.isFirst()){
                    polideportivos= new ArrayList<>();
                    Polideportivo p = new Polideportivo(rs.getInt("cod"), rs.getString("info"));
                    polideportivos.add(p);
                }
            }
            rs.close();
            disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(PolideportivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return polideportivos;
    }
    
    
    
    
    
    
}
