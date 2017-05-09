package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofincurso.Jf_InicioSesion;

public class Aviso_CRUD {
    
    Connection accesoDB = Jf_InicioSesion.conexion;

    public Aviso_CRUD() {
    }

    @SuppressWarnings("UseSpecificCatch")

    public String insertAvisos(java.sql.Date fecha_aviso, String texto, int id_trabajador, java.sql.Date fecha_parte, int id_trabajador_parte) {

        String rptaRegistro = null;

        try {
            
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_AVISO(?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setDate(1, fecha_aviso);
            cs.setString(2, texto);
            cs.setInt(3, id_trabajador);
            cs.setDate(4, fecha_parte);
            cs.setInt(5, id_trabajador_parte);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro ACTUALIZADO";
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rptaRegistro;
    }

    public ArrayList<Aviso> listAviso() {
        ArrayList listaAviso = new ArrayList();
        Aviso aviso;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM AVISO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aviso = new Aviso();
                aviso.setFecha_aviso(rs.getDate(1));
                aviso.setTexto(rs.getString(2));
                aviso.setId_trabajador(rs.getInt(3));
                aviso.setFecha_parte(rs.getDate(4));
                aviso.setId_trabajador_parte(rs.getInt(5));

                listaAviso.add(aviso);
            }

        } catch (Exception e) {

        }
        return listaAviso;
    }

    public String editarAviso(java.sql.Date fecha_aviso, String texto, int id_trabajador, java.sql.Date fecha_parte, int id_trabajador_parte) {

        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_AVISO(?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setDate(1, fecha_aviso);
            cs.setString(2, texto);
            cs.setInt(3, id_trabajador);
            cs.setDate(4, fecha_parte);
            cs.setInt(5, id_trabajador_parte);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";
            }


        } catch (Exception e) {
        }

        return rptaEdit;
    }

    public int eliminarAviso(java.sql.Date fecha_parte, int id_trabajador_parte) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_AVISO(?,?)}");
            cs.setDate(1, fecha_parte);
            cs.setInt(2, id_trabajador_parte);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Aviso> buscarAviso(java.sql.Date fecha_parte, int id_trabajador_parte) {
        ArrayList<Aviso> listaAviso = new ArrayList();
        Aviso aviso;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM AVISO WHERE CP_FECHA = (?) AND CP_TRABAJADOR_ID_TRABAJADOR = (?)");
            ps.setDate(1, fecha_parte);
            ps.setInt(2, id_trabajador_parte);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aviso = new Aviso();
                aviso.setFecha_aviso(rs.getDate(1));
                aviso.setTexto(rs.getString(2));
                aviso.setId_trabajador(rs.getInt(3));
                aviso.setFecha_parte(rs.getDate(4));
                aviso.setId_trabajador_parte(rs.getInt(5));

                listaAviso.add(aviso);
            }

        } catch (Exception e) {

        }
        return listaAviso;
    }

}
