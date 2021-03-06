package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;
import proyectofincurso.Jf_InicioSesion;

public class CT_CRUD {

    Connection accesoDB = Jf_InicioSesion.conexion;

    public CT_CRUD() {
    }

    @SuppressWarnings("UseSpecificCatch")
    /**
     * Insert de un centro de trabajo en la base de datos.
     */
    public String insertCT(int Id, String P_CT_nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {

        String rptaRegistro = null;

        try {
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL UPDATE_INSERT_CENTRO(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            Id = 0;
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
                rptaRegistro = "Registro ACTUALIZADO";
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rptaRegistro;
    }

    /**
     * Listado de todos los centros de trabajo
     *
     * @return todos los centros de trabajo
     */
    public ArrayList<CT> listCT() {
        ArrayList listaCT = new ArrayList();
        CT ct;
        String sql = "{call CONSULTA_CT.BUSCAR_TOTAL_CT(?)}";
        try {
            //Statement sentencia = accesoDB.createStatement();
            CallableStatement rp = accesoDB.prepareCall(sql);
            rp.registerOutParameter(1, OracleTypes.CURSOR);
            rp.executeUpdate();
            ResultSet res = (ResultSet) rp.getObject(1);
            while (res.next()) {
                ct = new CT();
                ct.setID(res.getInt(1));
                ct.setNombre(res.getString(2));
                ct.setCalle(res.getString(3));
                ct.setNumero(res.getInt(4));
                ct.setCp(res.getString(5));
                ct.setCiudad(res.getString(6));
                ct.setProvincia(res.getString(7));
                ct.setTelefono(res.getString(8));
                listaCT.add(ct);
            }

        } catch (Exception e) {

        }
        return listaCT;
    }

    /**
     * Si se ha modificado un registro de centros de trabajo se actualiza
     *
     * @param Id
     * @param nombre
     * @param calle
     * @param numero
     * @param cp
     * @param ciudad
     * @param provincia
     * @param telefono
     * @return
     */
    public String editarCT(int Id, String nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {

        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL UPDATE_INSERT_CENTRO(?,?,?,?,?,?,?,?)} ");
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
                rptaEdit = "Registro ACTUALIZAZO";
            }

        } catch (Exception e) {
        }

        return rptaEdit;
    }

    /**
     * Eliminacion de un centro de trabajo elegido por ID
     *
     * @param Id el centro de trabajo a eliminar
     * @return
     */
    public int eliminarCT(int Id) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL BORRAR_CENTRO(?)}");
            cs.setInt(1, Id);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    /**
     * Busqueda de un centro de trabajo por nombre
     *
     * @param nombreBuscado
     * @return
     */
    public ArrayList<CT> buscarCTxProcedimiento(String nombreBuscado) {
        ArrayList<CT> listaCT = new ArrayList();
        CT ct;
        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_SELECT_CT (?,?)}");
            cs.setString(1, nombreBuscado);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(2);

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
            cs.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCT;
    }

}
