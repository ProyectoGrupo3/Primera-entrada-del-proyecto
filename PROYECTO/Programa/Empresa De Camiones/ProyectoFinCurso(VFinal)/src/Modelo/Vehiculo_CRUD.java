package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofincurso.InicioSesion;

public class Vehiculo_CRUD {
    
    Connection accesoDB = InicioSesion.conexion;

    public String insertVehiculo(String matricula, String marca, String modelo, String color, int kms) {

        String rptaRegistro = null;

        try {
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Vehiculo(?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setString(1, matricula);
            cs.setString(2, marca);
            cs.setString(3, modelo);
            cs.setString(4, color);
            cs.setInt(5, kms);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro ACTUALIZADO";
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rptaRegistro;
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

        } catch (Exception e) {

        }
        return listaVehiculo;
    }

    public String editarVehiculo(String matricula, String marca, String modelo, String color, int kms) {
        
        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Vehiculo(?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setString(1, matricula);
            cs.setString(2, marca);
            cs.setString(3, modelo);
            cs.setString(4, color);
            cs.setInt(5, kms);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";
            }


        } catch (Exception e) {
        }

        return rptaEdit;
    }

    public int eliminarVehiculo(String matricula) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_Vehiculo(?)}");
            cs.setString(1, matricula);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Vehiculo> buscarVehiculoxNombre(String nombreBuscado) {
        ArrayList<Vehiculo> listaVehiculo = new ArrayList();
        Vehiculo vehiculo;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM VEHICULO WHERE MATRICULA LIKE (?)");
            ps.setString(1, nombreBuscado);
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

        } catch (Exception e) {

        }
        return listaVehiculo;
    }

}
