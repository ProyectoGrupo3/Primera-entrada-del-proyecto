package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofincurso.Jf_InicioSesion;

public class Gestion_Parte_CRUD {

    public Gestion_Parte_CRUD() {
    }

    Connection accesoDB = Jf_InicioSesion.conexion;
    // UTILIZO una VISTA de las Cabeceras para tener todos los datos
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
                vista_cp.setNombre(rs.getString(13));
                vista_cp.setApellido1(rs.getString(14));
                vista_cp.setMatricula(rs.getString(15));

                listaVista_CP.add(vista_cp);
            }
            ps.close();
            rs.close();

        } catch (Exception e) {

        }
        return listaVista_CP;
    }

    public ArrayList<Vehiculo> listVehiculo() {
        ArrayList listaVehiculo = new ArrayList();
        Vehiculo vehiculo;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM VEHICULO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setMatricula(rs.getString(1));
                vehiculo.setMarca(rs.getString(2));
                vehiculo.setModelo(rs.getString(3));
                vehiculo.setColor(rs.getString(4));
                vehiculo.setKms(rs.getInt(5));

                listaVehiculo.add(vehiculo);
            }
            ps.close();
            rs.close();

        } catch (Exception e) {

        }
        return listaVehiculo;
    }

    public String editarGestion_Parte(Date fecha, int id, String matricula, int km_ini, int km_fin, double gasoil, double autopista, double dietas, double otros, String incidencias, Boolean crd, Boolean vrf, java.sql.Date he) {

        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Gestion_Parte(?,?,?,?,?,?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS            
            cs.setDate(1, fecha);
            cs.setInt(2, id);
            cs.setString(3, matricula);
            cs.setInt(4, km_ini);
            cs.setInt(5, km_fin);
            cs.setDouble(6, gasoil);
            cs.setDouble(7, autopista);
            cs.setDouble(8, dietas);
            cs.setDouble(9, otros);
            cs.setString(10, incidencias);
            cs.setBoolean(11, crd);
            cs.setBoolean(12, vrf);
            cs.setDate(13, he);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";
            }
            cs.close();

        } catch (Exception e) {
        }

        return rptaEdit;
    }

    public int eliminarGestion_Parte(Date fecha, String matricula, int id) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_Gestion_Parte(?,?,?)}");
            cs.setDate(1, fecha);
            cs.setString(2, matricula);
            cs.setInt(3, id);

            numFil = cs.executeUpdate();
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Gestion_Parte_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Vista_CP> buscarGestion_PartexFecha(java.sql.Date fechaBuscado, String cerrado, String verificado) {
        ArrayList<Vista_CP> listaGestion_Parte = new ArrayList();
        Vista_CP vista_cp;
        if (fechaBuscado != null) {
            try {
                PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CP_VISTA WHERE FECHA = (?) AND CERRAR_LOGIS = (?) AND VERIFICACIÓN_ADMIN = (?)");
                ps.setDate(1, fechaBuscado);
                ps.setString(2, cerrado);
                ps.setString(3, verificado);
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
                    vista_cp.setNombre(rs.getString(13));
                    vista_cp.setApellido1(rs.getString(14));
                    vista_cp.setMatricula(rs.getString(15));
                    vista_cp.setCt(rs.getInt(16));
                    listaGestion_Parte.add(vista_cp);
                }
                ps.close();
                rs.close();

            } catch (Exception e) {

            }
        } else {
            try {
                PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CP_VISTA WHERE CERRAR_LOGIS = (?) AND VERIFICACIÓN_ADMIN = (?)");
                ps.setString(1, cerrado);
                ps.setString(2, verificado);
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
                    vista_cp.setNombre(rs.getString(13));
                    vista_cp.setApellido1(rs.getString(14));
                    vista_cp.setMatricula(rs.getString(15));
                    vista_cp.setCt(rs.getInt(16));
                    listaGestion_Parte.add(vista_cp);
                }
                ps.close();
                rs.close();

            } catch (Exception e) {

            }
        }
        return listaGestion_Parte;
    }
}
