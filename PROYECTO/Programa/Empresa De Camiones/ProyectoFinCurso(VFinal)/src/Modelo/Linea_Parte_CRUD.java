package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofincurso.Jf_InicioSesion;

public class Linea_Parte_CRUD {
    
    Connection accesoDB = Jf_InicioSesion.conexion;

    public Linea_Parte_CRUD() {
    }

    @SuppressWarnings("UseSpecificCatch")

    public String insertLinea_Parte(java.sql.Date hora_inicio, java.sql.Date hora_final, java.sql.Date fecha, int id_trabajador) {

        String rptaRegistro = null;

        try {
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Linea_Parte(?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setDate(1, hora_inicio);
            cs.setDate(2, hora_final);
            cs.setDate(3, fecha);
            cs.setInt(4, id_trabajador);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro ACTUALIZADO";
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rptaRegistro;
    }

    public ArrayList<Linea_Parte> listLinea_Parte() {
        // El Array lo creo con LA VISTA "LP_VISTA" para que aparezca el nombre y el apellido 1 del trabajador
        ArrayList listaLinea_Parte = new ArrayList();
        Linea_Parte linea_parte;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM LP_VISTA");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                linea_parte = new Linea_Parte();
                linea_parte.setHora_inicio(rs.getString(1));
                linea_parte.setHora_final(rs.getString(2));
                linea_parte.setfecha(rs.getDate(3));
                linea_parte.setId_trabajador(rs.getInt(4));
                linea_parte.setNombre(rs.getString(5));
                listaLinea_Parte.add(linea_parte);
            }

        } catch (Exception e) {

        }
        return listaLinea_Parte;
    }

    public String editarLinea_Parte(Date hora_inicio, Date hora_final, Date fecha, int id_trabajador) {

        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Linea_Parte(?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setDate(1, hora_inicio);
            cs.setDate(2, hora_final);
            cs.setDate(3, fecha);
            cs.setInt(4, id_trabajador);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";
            }


        } catch (Exception e) {
        }

        return rptaEdit;
    }

    public int eliminarLinea_Parte(java.sql.Date fecha, int Id) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_Linea_Parte(?,?)}");
            cs.setDate(1, fecha);
            cs.setInt(2, Id);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Linea_Parte> buscarLinea_PartexFecha(java.sql.Date fecha, int Id) {
        ArrayList<Linea_Parte> listaLinea_Parte = new ArrayList();
        Linea_Parte linea_parte;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM LP WHERE CP_FECHA = (?) AND CP_TRABAJADOR_ID_TRABAJADOR = (?)");
            ps.setDate(1, fecha);
            ps.setInt(2, Id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                linea_parte = new Linea_Parte();
                linea_parte.setHora_inicio(rs.getString(1));
                linea_parte.setHora_final(rs.getString(2));
                linea_parte.setfecha(rs.getDate(3));
                linea_parte.setId_trabajador(rs.getInt(4));

                listaLinea_Parte.add(linea_parte);
            }

        } catch (Exception e) {

        }
        return listaLinea_Parte;
    }

}
