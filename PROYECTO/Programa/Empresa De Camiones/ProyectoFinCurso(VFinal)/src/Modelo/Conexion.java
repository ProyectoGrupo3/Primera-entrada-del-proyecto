package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection con;

    public static Connection getConexionGod() {

        try {
            String className = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@10.10.10.9:1521:db12102";
            String user = "system";
            String password = "oracle";

            Class.forName(className).newInstance();

            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

        }
        return con;
    }

    public static Connection getConexionUsuario(String usuario, String contra) {

        try {
            String className = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@10.10.10.9:1521:db12102";
            String user = usuario;
            String password = contra;

            Class.forName(className).newInstance();

            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

        }
        return con;

    }

    public static void exitConexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
