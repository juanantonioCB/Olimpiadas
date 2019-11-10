package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Comisario;
import modelo.Evento;

public class EventoDAO extends Conexion {

    String insert = "INSERT INTO event (name,date,id_sportcomplex,id_area) VALUES (?,?,?,?)";
    String insertComisario = "INSERT INTO comissioner_event(id_event,id_comissioner) VALUES (?,?)";
    String update = "UPDATE event SET name=?, date=?, id_sportcomplex=?, id_area=? WHERE cod=?";
    String delete = "DELETE FROM event WHERE id=?";
    String getAll = "SELECT evento.id, evento.name, evento.date, complejo.location as localizacion_complejo, "
            + "area.location as area, evento.id_sportcomplex, evento.id_area "
            + "FROM event as evento JOIN sportcomplex as complejo "
            + "JOIN area as area WHERE complejo.id=evento.id_sportcomplex || area.id=evento.id_area "
            + "GROUP By evento.id";
    String getOne = "SELECT * FROM event WHERE id=?";

    public boolean insertEvento(Evento e) {
        boolean d = false;

        try {
            Connection con = getConnect();
            PreparedStatement stat = null;
            stat = con.prepareStatement(insert);
            stat.setString(1, e.getNombre());
            stat.setDate(2, e.getDate());
            stat.setInt(3, e.getCod_complejo());
            stat.setInt(4, e.getCod_area());
            if (stat.execute()) {
                d = true;
            }
            stat.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean updateEvento(int id, Evento e) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(update);
            stat.setString(1, e.getNombre());
            stat.setInt(2, e.getCod_complejo());
            stat.setDate(3, (Date) e.getDate());
            stat.setInt(4, e.getCod_area());
            stat.setInt(5, id);
            if (stat.execute()) {
                d = true;
                stat.close();
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public boolean deleteEvento(int id) {
        boolean d = false;
        try {
            Connection con = getConnect();
            PreparedStatement stat = con.prepareStatement(delete);
            stat.setInt(1, id);
            if (stat.execute()) {
                stat.close();
                d = true;
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public List<Evento> getAll() {
        ArrayList<Evento> eventos = null;
        try {
            Connection con = getConnect();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getAll);
            while (rs.next()) {
                if (rs.isFirst()) {
                    eventos = new ArrayList<Evento>();
                }
                Evento e = new Evento(rs.getInt("id"), rs.getString("name"), rs.getInt("id_sportcomplex"), rs.getDate("date"), rs.getInt("id_area"),
                        rs.getString("localizacion_complejo"), rs.getString("area"));
                eventos.add(e);
            }
            rs.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }



    public Evento getEvento(int id) {
        Evento e = null;

        return e;
    }
}
