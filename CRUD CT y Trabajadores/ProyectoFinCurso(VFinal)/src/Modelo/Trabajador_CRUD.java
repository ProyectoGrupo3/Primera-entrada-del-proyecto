package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofincurso.InicioSesion;

public class Trabajador_CRUD {

    Connection accesoDB = InicioSesion.conexion;

    public Trabajador_CRUD() {
    }

    public String insertTrabajador(int ID, String dni, String nombre, String apellido1, String apellido2, String calle, String portal, String piso, String mano, String telefono_p, String movil_em, double salario, Date fecha_nac, String categoria, int ct) {

        String rptaRegistro = null;

        try {
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("(CALL INSERTAR_TRABAJADOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, ID);
            cs.setString(2, dni);
            cs.setString(3, nombre);
            cs.setString(4, apellido1);
            cs.setString(5, apellido2);
            cs.setString(6, calle);
            cs.setString(7, portal);
            cs.setString(8, piso);
            cs.setString(9, mano);
            cs.setString(10, telefono_p);
            cs.setString(11, movil_em);
            cs.setDouble(12, salario);
            cs.setDate(13, fecha_nac);
            cs.setString(14, categoria);
            cs.setInt(15, ct);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro insertado";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }

    public int eliminarTrabajador(String nombre) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("(CALL PROCEDIMIENTO BORRADO(?) ");
            cs.setString(1, nombre);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Trabajador_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Trabajador> listTrabajador() {
        ArrayList listaTrabajador = new ArrayList();
        Trabajador trabajador;
        Statement sentencia = null;
        try {
            sentencia = accesoDB.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Trabajador_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM TTRABAJADOR");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setID_trabajador(rs.getInt(1));
                trabajador.setDni(rs.getString(2));
                trabajador.setNombre(rs.getString(3));
                trabajador.setApellido1(rs.getString(4));
                trabajador.setApellido2(rs.getString(5));
                trabajador.setCalle(rs.getString(6));
                trabajador.setPortal(rs.getString(7));
                trabajador.setPiso(rs.getString(8));
                trabajador.setMano(rs.getString(9));
                trabajador.setTelef_personal(rs.getString(10));
                trabajador.setMovil_empresa(rs.getString(11));
                trabajador.setSalario(rs.getDouble(12));
                trabajador.setFecha_nac(rs.getDate(13));
                trabajador.setCategoria(rs.getString(14));
                trabajador.setCt(rs.getInt(15));

                listaTrabajador.add(trabajador);
            }

        } catch (Exception e) {

        }

        try {
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(Trabajador_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTrabajador;
    }

    public int editarTrabajador(int ID, String dni, String nombre, String apellido1, String apellido2, String calle, String portal, String piso, String mano, String telefono_p, String movil_em, double salario, Date fecha_nac, String categoria, int ct) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("(CALL PROCEDIMIENTO EDICION(?,?,?,?,?,?,?) ");
            cs.setInt(1, ID);
            cs.setString(2, dni);
            cs.setString(3, nombre);
            cs.setString(4, apellido1);
            cs.setString(5, apellido2);
            cs.setString(6, calle);
            cs.setString(7, portal);
            cs.setString(8, piso);
            cs.setString(9, mano);
            cs.setString(10, telefono_p);
            cs.setString(11, movil_em);
            cs.setDouble(12, salario);
            cs.setDate(13, fecha_nac);
            cs.setString(14, categoria);
            cs.setInt(15, ct);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

}
