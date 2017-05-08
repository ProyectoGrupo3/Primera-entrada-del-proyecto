
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofincurso.*;

public class Cabe_Parte_CRUD {
    
    Connection accesoDB = Jf_InicioSesion.conexion;
    
    public Cabe_Parte_CRUD() {
    }

    public ArrayList<Cabe_Parte> listCabe_Parte() {
        ArrayList listaCabe_Parte = new ArrayList();
        Cabe_Parte cabe_parte;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CP");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cabe_parte = new Cabe_Parte();
                cabe_parte.setFecha(rs.getDate(1));
                cabe_parte.setKm_inicio(rs.getInt(2));
                cabe_parte.setKm_fin(rs.getInt(3));
                cabe_parte.setGasoil(rs.getInt(4));
                cabe_parte.setAutopista(rs.getInt(5));
                cabe_parte.setDietas(rs.getInt(6));
                cabe_parte.setOtros(rs.getInt(7));
                cabe_parte.setIncidencias(rs.getString(8));
                cabe_parte.setExceso_horas(rs.getLong(9));
                cabe_parte.setCerrar_parte(rs.getObject(10, Types.CHAR));
                cabe_parte.setVerificar_parte(rs.getObject(11, Types.CHAR));
                cabe_parte.setId_trabajador(rs.getInt(12));
                cabe_parte.setMatricula(rs.getString(13));                
                listaCabe_Parte.add(cabe_parte);
            }
            ps.close();

        } catch (Exception e) {

        }
        return listaCabe_Parte;
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


    public String editarCabe_Parte(java.sql.Date fecha, int km_in, int km_fin, double gasoil, double autopista, double dietas, double otros, String incidencias, java.sql.Date exceso_horas, boolean cerrar, boolean verificar, int id_trabajador, String matricula) {
        
        String rptaEdit =null;
        int numFil = 0;

        try {
            
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Cabe_Parte(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS            
            cs.setDate(1, fecha);
            cs.setInt(2, km_in);
            cs.setInt(3, km_fin);
            cs.setDouble(4, gasoil);
            cs.setDouble(5, autopista);
            cs.setDouble(6, dietas);
            cs.setDouble(7, otros);
            cs.setString(8, incidencias);
            cs.setDate(9, exceso_horas);
            cs.setBoolean(10, cerrar);
            cs.setBoolean(11, verificar);
            cs.setInt(12, id_trabajador);
            cs.setString(13, matricula);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";               
            }
            cs.close();
        
        } catch (Exception e) {
        }
        
        return rptaEdit;
    }

    public int eliminarCabe_Parte(java.sql.Date fecha, int id) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_Cabe_Parte(?)}");
            cs.setDate(1, fecha);
            cs.setInt(2,id);

            numFil = cs.executeUpdate();
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Cabe_Parte_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Cabe_Parte> buscarCabe_PartexNombre(java.sql.Date fechaBuscado) {
        ArrayList<Cabe_Parte> listaCabe_Parte = new ArrayList();
        Cabe_Parte cabe_parte;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CP WHERE FECHA = (?)");
            ps.setDate(1, fechaBuscado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cabe_parte = new Cabe_Parte();
                cabe_parte.setFecha(rs.getDate(1));
                cabe_parte.setKm_inicio(rs.getInt(2));
                cabe_parte.setKm_fin(rs.getInt(3));
                cabe_parte.setGasoil(rs.getInt(4));
                cabe_parte.setAutopista(rs.getInt(5));
                cabe_parte.setDietas(rs.getInt(6));
                cabe_parte.setOtros(rs.getInt(7));
                cabe_parte.setIncidencias(rs.getString(8));
                cabe_parte.setExceso_horas(rs.getLong(9));
                cabe_parte.setCerrar_parte(rs.getObject(10));
                cabe_parte.setVerificar_parte(rs.getObject(11));
                cabe_parte.setId_trabajador(rs.getInt(12));
                cabe_parte.setMatricula(rs.getString(13));                
                listaCabe_Parte.add(cabe_parte);
            }
            ps.close();
            rs.close();

        } catch (Exception e) {

        }
        return listaCabe_Parte;
    }    
    
}
