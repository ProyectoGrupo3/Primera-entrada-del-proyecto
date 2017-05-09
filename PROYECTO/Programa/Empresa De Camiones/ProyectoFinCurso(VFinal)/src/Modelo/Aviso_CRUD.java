package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;
import proyectofincurso.*;

public class Aviso_CRUD {

    public Aviso_CRUD() {
    }
    Connection accesoDB = Jf_InicioSesion.conexion;

    @SuppressWarnings("UseSpecificCatch")

    public String insertAviso(java.sql.Date fecha_aviso, String texto, int id_Admin, java.sql.Date fecha_parte, int id_Logis) {

        String rptaRegistro = null;

        try {
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_AVISO(?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setDate(1, fecha_aviso);
            cs.setString(2, texto);
            cs.setInt(3, id_Admin);
            cs.setDate(4, fecha_parte);
            cs.setInt(5, id_Logis);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro ACTUALIZADO";
            }

            cs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rptaRegistro;
    }

    public ArrayList<Aviso> listAviso() {
        ArrayList listaAviso = new ArrayList();
        Aviso aviso;
        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_LISTA_AVISO (?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                aviso = new Aviso();
                aviso.setFecha_aviso(rs.getDate(1));
                aviso.setFecha_parte(rs.getDate(2));
                aviso.setNombre(rs.getString(3));
                aviso.setApellido1(rs.getString(4));
                aviso.setTexto(rs.getString(5));
                aviso.setId_Logis(rs.getInt(6));
                aviso.setId_Admin(rs.getInt(7));

                listaAviso.add(aviso);
            }
            cs.close();
            rs.close();

        } catch (Exception e) {

        }
        return listaAviso;
    }

    public String editarAviso(java.sql.Date fecha_aviso, String texto, int id_Admin, java.sql.Date fecha_parte, int id_Logis) {

        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_AVISO(?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setDate(1, fecha_aviso);
            cs.setString(2, texto);
            cs.setInt(3, id_Admin);
            cs.setDate(4, fecha_parte);
            cs.setInt(5, id_Logis);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";
            }
            cs.close();

        } catch (Exception e) {
        }

        return rptaEdit;
    }

    public int eliminarAviso(int id_Admin, java.sql.Date fecha_parte, int id_Logis) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_AVISO(?,?)}");
            cs.setInt(1, id_Admin);
            cs.setDate(2, fecha_parte);
            cs.setInt(3, id_Logis);

            numFil = cs.executeUpdate();
            cs.close();
            Conexion.exitConexion();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Aviso> buscarAvisoxNombre(String nombre_logis) {
        ArrayList<Aviso> listaAviso = new ArrayList();
        Aviso aviso;
        try {
             CallableStatement cs = accesoDB.prepareCall("{CALL P_SELECT_AVISO (?,?)}");
            cs.setString(1, nombre_logis);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(2);
            
            while (rs.next()) {
                aviso = new Aviso();
                aviso.setFecha_aviso(rs.getDate(1));
                aviso.setFecha_parte(rs.getDate(2));
                aviso.setNombre(rs.getString(3));
                aviso.setApellido1(rs.getString(4));
                aviso.setTexto(rs.getString(5));
                aviso.setId_Logis(rs.getInt(6));
                aviso.setId_Admin(rs.getInt(7));

                listaAviso.add(aviso);
            }
            cs.close();
            rs.close();

        } catch (Exception e) {

        }
        return listaAviso;
    }

}
