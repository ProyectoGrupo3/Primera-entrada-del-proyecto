package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection con = null;
    
    public static Connection getConexion() {

        try {
            String className = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@//192.168.56.101:1521/xe";
            String user = "SYSTEM";
            String password = "root";

            Class.forName(className).newInstance();
            
            con = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {

        }
        return con;
    }
    
    public static void exitConexion(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
