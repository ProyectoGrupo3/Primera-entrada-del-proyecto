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

    public ArrayList<CT> buscarCTxNombre(String nombreBuscado) {
        ArrayList<CT> listaCT = new ArrayList();
        CT ct;
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CENTRO_TRABAJO WHERE NOMBRE LIKE (?)");
            ps.setString(1, nombreBuscado);
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

        } catch (Exception e) {

        }
        return listaCT;
    }

}
