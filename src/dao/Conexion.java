package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Antonio
 */
public abstract class Conexion {

    private static String db = "olympics";
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/" + db;
    private static Connection con = null;

    public Connection getConnect() {
        con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.err.print(ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión con la base de datos");
            System.exit(0);
        }
        return con;
    }

    /**
     * crea las tablas si no existen.
     */
    public void start() {
        String sql="";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

}
