package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofincurso.InicioSesion;
import proyectofincurso.JF_CT_CRUD;

public class CT_CRUD {

    Connection accesoDB = InicioSesion.conexion;

    public CT_CRUD() {
    }

    @SuppressWarnings("UseSpecificCatch")

    public String insertCT(int Id, String P_CT_nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {

        String rptaRegistro = null;
        long myId = 0;

        try {

            // Ejecutamos la Secuencia para conocer el ID
            String Identificador = "SELECT CT_ID.NEXTVAL FROM DUAL";
            PreparedStatement ps = accesoDB.prepareStatement(Identificador);
            synchronized (this) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    myId = rs.getLong(1);
                }
            }
            Id = (int) myId;

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_INSERT_CT(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, Id);
            cs.setString(2, P_CT_nombre);
            cs.setString(3, calle);
            cs.setInt(4, numero);
            cs.setString(5, cp);
            cs.setString(6, ciudad);
            cs.setString(7, provincia);
            cs.setString(8, telefono);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro insertado";
            }

            Conexion.exitConexion();

        } catch (Exception e) {
        }

        return rptaRegistro;
    }

    public ArrayList<CT> listCT() {
        ArrayList listaCT = new ArrayList();
        CT ct;
        try {
            
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM TCENTRO_TRABAJO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct = new CT();
                ct.setID(rs.getInt(1));
                ct.setNombre(rs.getString(2));
                ct.setCalle(rs.getString(3));
                ct.setNumero(rs.getInt(4));
                ct.setCp(rs.getString(5));
                ct.setCiudad(rs.getString(6));
                ct.setProvincia(rs.getString(7));
                ct.setTelefono(rs.getString(8));
                listaCT.add(ct);
            }
            //Conexion.exitConexion();

        } catch (Exception e) {

        }
        return listaCT;
    }

    public String editarCT(int Id, String nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {

        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_INSERT_CT(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, Id);
            cs.setString(2, nombre);
            cs.setString(3, calle);
            cs.setInt(4, numero);
            cs.setString(5, cp);
            cs.setString(6, ciudad);
            cs.setString(7, provincia);
            cs.setString(8, telefono);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro insertado";
            }

            Conexion.exitConexion();

        } catch (Exception e) {
        }

        return rptaEdit;
    }

    public int eliminarCT(String nombre) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("(CALL PROCEDIMIENTO BORRADO(?) ");
            cs.setString(1, nombre);

            numFil = cs.executeUpdate();
            Conexion.exitConexion();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<CT> buscarCTxNombre(String nombre) {
        ArrayList<CT> listaCT = new ArrayList();
        CT ct;
        try {
            CallableStatement cs = accesoDB.prepareCall("(CALL PROCEDIMIENTO BUSQUEDA(?) ");
            cs.setString(1, nombre);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ct = new CT();
                ct.setID(rs.getInt(1));
                ct.setNombre(rs.getString(2));
                ct.setCalle(rs.getString(3));
                ct.setNumero(rs.getInt(4));
                ct.setCp(rs.getString(5));
                ct.setCiudad(rs.getString(6));
                ct.setProvincia(rs.getString(7));
                ct.setTelefono(rs.getString(8));
                listaCT.add(ct);
                Conexion.exitConexion();
            }

        } catch (Exception e) {

        }
        return listaCT;
    }

}
