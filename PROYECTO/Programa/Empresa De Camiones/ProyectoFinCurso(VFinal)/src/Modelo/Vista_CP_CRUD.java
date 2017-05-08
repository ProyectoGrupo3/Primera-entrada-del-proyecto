
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofincurso.Jf_InicioSesion;

public class Vista_CP_CRUD {

    public Vista_CP_CRUD() {
    }
    Connection accesoDB = Jf_InicioSesion.conexion;
    public ArrayList<Vista_CP> listVista_CP() {
        ArrayList listaVista_CP = new ArrayList();
        Vista_CP vista_cp;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CP_VISTA");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vista_cp = new Vista_CP();
                vista_cp.setFecha(rs.getDate(1));
                vista_cp.setKm_in(rs.getInt(2));
                vista_cp.setKm_fin(rs.getInt(3));
                vista_cp.setGasoil(rs.getDouble(4));
                vista_cp.setAutopista(rs.getDouble(5));
                vista_cp.setDietas(rs.getDouble(6));
                vista_cp.setOtros(rs.getDouble(7));
                vista_cp.setIncidencias(rs.getString(8));
                vista_cp.setExceso_horas(rs.getDate(9));
                vista_cp.setCerrar_parte(rs.getBoolean(10));
                vista_cp.setVerificar_parte(rs.getBoolean(11));
                vista_cp.setId_trabajador(rs.getInt(12));
                vista_cp.setMatricula(rs.getString(13));                
                listaVista_CP.add(vista_cp);
            }
            ps.close();
            rs.close();

        } catch (Exception e) {

        }
        return listaVista_CP;
    }
    
}
